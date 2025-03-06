class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for(int[] i: grid){
            for(int j: i){
                if(set.contains(j)){
                    res[0] = j;
                }
                set.add(j);
            }
        }
        int n = grid.length;
        for(int i = 1;i <= n * n;i++){
            if(!set.contains(i)){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}