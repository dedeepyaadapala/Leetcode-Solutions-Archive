class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] lst = new ArrayList[numRows];
        for(int i = 0;i < numRows;i++){
            lst[i] = new ArrayList<>();
            for(int j = 0; j <= i;j++){
                if(i==0 || j == 0 || j == i){
                    lst[i].add(1);
                }else{
                    lst[i].add(lst[i-1].get(j-1)+lst[i-1].get(j));
                }
            }
            res.add(lst[i]);
        }
        return res;
    }
}