class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        generatePossibilities(candidates,n,0,target,res,new ArrayList<>());
        return res;
    }

    private static void generatePossibilities(int[] candidates,int n,int idx,int target,List<List<Integer>> res,List<Integer> curr){
        if(idx == n){
            if(target == 0) res.add(new ArrayList<>(curr));
            return;
        }
        if(candidates[idx] <= target){
        curr.add(candidates[idx]);
        generatePossibilities(candidates,n,idx,target-candidates[idx],res,curr);
        curr.remove(curr.size()-1);}
        generatePossibilities(candidates,n,idx+1,target,res,curr);
    }
}