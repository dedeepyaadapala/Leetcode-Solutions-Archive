class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(2*n,res,"(",1,0);
        return res;
    }

    public static void backtrack(int n,List<String> res,String curr,int oc,int cc){
        if(oc + cc == n){
            res.add(curr);
            return;
        }
        if(oc < n/2){
            backtrack(n,res,curr+"(",oc+1,cc);
        }
        if(cc < oc){
            backtrack(n,res,curr+")",oc,cc+1);
        }
    }
}