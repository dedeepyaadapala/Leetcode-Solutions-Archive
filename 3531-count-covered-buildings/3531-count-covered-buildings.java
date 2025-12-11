class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        TreeMap<Integer,TreeSet<Integer>> m1 = new TreeMap<>();
        TreeMap<Integer,TreeSet<Integer>> m2 = new TreeMap<>();
        for(int i = 0;i < buildings.length;i++){
            m1.computeIfAbsent(buildings[i][0],k -> new TreeSet<>()).add(buildings[i][1]);
            m2.computeIfAbsent(buildings[i][1],k -> new TreeSet<>()).add(buildings[i][0]);
        }
        int cnt = 0;
        for(int[] i : buildings){
            boolean flag = true;
            if(m1.get(i[0]).lower(i[1]) == null){
                flag = false;
            }
            if(m1.get(i[0]).higher(i[1]) == null){
                flag = false;
            }
            if(m2.get(i[1]).lower(i[0]) == null){
                flag = false;
            }
            if(m2.get(i[1]).higher(i[0]) == null){
                flag = false;
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}

