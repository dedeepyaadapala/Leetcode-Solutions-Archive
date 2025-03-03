class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int left = 0,right = n-1;
        int[] ans = new int[n];
        int low = 0,high = n-1;
        while(low < n){
            if(nums[low] < pivot){
                ans[left++] = nums[low];
            }
            if(nums[high] > pivot){
                ans[right--] = nums[high];
            }
            low++;
            high--;
        }
        while(left <= right){
            ans[left] = pivot;
            left++;
        }
        return ans;
    }
}