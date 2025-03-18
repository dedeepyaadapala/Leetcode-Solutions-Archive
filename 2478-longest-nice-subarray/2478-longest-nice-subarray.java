class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int low = 1,high = n;
        int ans = 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isNice(nums,n,mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isNice(int[] nums,int n,int k){
        int[] cnt = new int[32];
        boolean isValid = true;
        for(int i = 0;i < k;i++){
            for(int bit = 0;bit < 31;bit++){
                if((nums[i] & (1 << bit)) != 0){
                    cnt[bit]++;
                }
                if(cnt[bit] > 1){
                    isValid = false;
                }
            }
        }  
        if(isValid) return true;
        for(int i = k;i < n;i++){
            isValid = true;
            for(int bit = 0;bit < 31;bit++){
                if((nums[i] & (1 << bit)) != 0){
                    cnt[bit]++;
                }
                if((nums[i-k] & (1 << bit)) != 0){
                    cnt[bit]--;
                }
                if(cnt[bit] > 1){
                    isValid = false;
                }
            }
            if(isValid) return true;
        }  
        return false;      
    }
}

// 1 011 1000 110000 1010