class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        if(k == 1) return nums;
        //first window
        boolean isConsecutive = true;
        for(int i = 1;i < k;i++){
            if(nums[i] != nums[i-1] + 1){
                isConsecutive = false;
                res[0] = -1;
                break;
            }
        }
        if(res[0] != -1) res[0] = nums[k-1];
        for(int i = k;i < n;i++){
            if(nums[i] != nums[i-1] + 1){
                isConsecutive = false;
                res[i-k+1] = -1;
            }
            if(!isConsecutive){
                isConsecutive = true;
                for(int j = i-k+2;j <= i;j++){
                    if(nums[j] != nums[j-1] + 1){
                        isConsecutive = false;
                        res[i-k+1] = -1;
                        break;
                    }
                }
            }
            if(res[i-k+1] != -1) res[i-k+1] = nums[i];
        }
        return res;

    }
}