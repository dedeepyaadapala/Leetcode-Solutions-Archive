// class Solution {
//     static long cnt = 0l;
//     public int colorTheGrid(int m, int n) {
//         List<String> rows = new ArrayList<>();
//         findPossibleRows(m,rows,"");
//         cnt = 0l;
//         findPossibleCombos(n,rows,0,)
//     }

//     private static void findPossibleRows(int m,List<String> rows,String curr){
//         if(m == 0){
//             rows.add(curr);
//             return;
//         }
//         int len = curr.length();
//         if(len != 0 && curr.charAt(len-1) != 'R') findPossibleRows(m-1,rows,curr+"R");
//         if(len != 0 && curr.charAt(len-1) != 'G') findPossibleRows(m-1,rows,curr+"G");
//         if(len != 0 && curr.charAt(len-1) != 'B') findPossibleRows(m-1,rows,curr+"B");
//     }
// }

class Solution {

    static final int mod = 1000000007;

    public int colorTheGrid(int m, int n) {
        // Hash mapping stores all valid coloration schemes for a single row that meet the requirements
        Map<Integer, List<Integer>> valid = new HashMap<>();
        // Enumerate masks that meet the requirements within the range [0, 3^m)
        int maskEnd = (int) Math.pow(3, m);
        for (int mask = 0; mask < maskEnd; ++mask) {
            List<Integer> color = new ArrayList<>();
            int mm = mask;
            for (int i = 0; i < m; ++i) {
                color.add(mm % 3);
                mm /= 3;
            }
            boolean check = true;
            for (int i = 0; i < m - 1; ++i) {
                if (color.get(i).equals(color.get(i + 1))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                valid.put(mask, color);
            }
        }

        // Preprocess all (mask1, mask2) binary tuples, satisfying mask1 and mask2 When adjacent rows, the colors of the two cells in the same column are different
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int mask1 : valid.keySet()) {
            for (int mask2 : valid.keySet()) {
                boolean check = true;
                for (int i = 0; i < m; ++i) {
                    if (
                        valid.get(mask1).get(i).equals(valid.get(mask2).get(i))
                    ) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    adjacent
                        .computeIfAbsent(mask1, k -> new ArrayList<>())
                        .add(mask2);
                }
            }
        }

        Map<Integer, Integer> f = new HashMap<>();
        for (int mask : valid.keySet()) {
            f.put(mask, 1);
        }
        for (int i = 1; i < n; ++i) {
            Map<Integer, Integer> g = new HashMap<>();
            for (int mask2 : valid.keySet()) {
                for (int mask1 : adjacent.getOrDefault(
                    mask2,
                    new ArrayList<>()
                )) {
                    g.put(
                        mask2,
                        (g.getOrDefault(mask2, 0) + f.getOrDefault(mask1, 0)) %
                        mod
                    );
                }
            }
            f = g;
        }

        int ans = 0;
        for (int num : f.values()) {
            ans = (ans + num) % mod;
        }
        return ans;
    }
}