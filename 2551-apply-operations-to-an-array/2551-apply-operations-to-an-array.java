class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int left = -1,right = -1;
        for(int i = 0;i < n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
            }
        }
        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                left = i;
                break;
            }
        }
        for(int i = left+1;i < n;i++){
            if(nums[i] != 0){
                right = i;
                break;
            }
        }
        while(left != -1 && right != -1 && left < n && right < n){
            if(nums[left] != 0){
                left++;
            }else if(nums[right] == 0){
                right++;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
        return nums;
    }
}