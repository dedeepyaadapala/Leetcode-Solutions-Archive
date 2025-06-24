class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            for(int j = Math.max(i-k,0);j < Math.min(n,i+k+1);j++){
                if(nums[j] == key){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}