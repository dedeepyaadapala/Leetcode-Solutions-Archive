class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int left = i+1,right = n-1;
            while(left < right){
                int tar = nums[left] + nums[right];
                if(tar == -nums[i]){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    left++;
                    right--;
                }else if(tar < -nums[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}