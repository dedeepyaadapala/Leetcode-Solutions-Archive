class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        boolean[] flag = new boolean[n+1];
        backtrack(n,flag,res,0);
        return res;
    }

    private static boolean backtrack(int n,boolean[] flag,int[] res,int idx){
        if(idx == 2*n-1) return true;
        if(res[idx] != 0) return backtrack(n,flag,res,idx+1);
        for(int j = n;j > 0;j--){
            if(!flag[j]){
                res[idx] = j;
                if(j != 1 && j+idx < 2*n-1 && res[j+idx] == 0){
                    res[j+idx] = j;
                }else if(j != 1){
                    res[idx] = 0;
                    continue;
                }
                flag[j] = true;
                if(backtrack(n,flag,res,idx+1)) return true;
                res[idx] = 0;
                if(j != 1) res[j+idx] = 0;
                flag[j] = false;
            }
            
        }
        return false;
    }
}