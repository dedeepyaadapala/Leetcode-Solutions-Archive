class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> colToCnt = new HashMap<>();
        HashMap<Integer,Integer> ballToCol = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            if(ballToCol.containsKey(queries[i][0])){
                colToCnt.put(ballToCol.get(queries[i][0]),colToCnt.get(ballToCol.get(queries[i][0]))-1);
                if(colToCnt.get(ballToCol.get(queries[i][0])) == 0){
                    colToCnt.remove(ballToCol.get(queries[i][0]));
                }
            }
            ballToCol.put(queries[i][0],queries[i][1]);
            colToCnt.put(queries[i][1],colToCnt.getOrDefault(queries[i][1],0)+1);
            res[i] = colToCnt.size();
        }
        return res;
    }
}