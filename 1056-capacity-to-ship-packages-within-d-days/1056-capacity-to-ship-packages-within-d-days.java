class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1, high = 0;
        int ans = -1;
        int n = weights.length;
        for(int i = 0;i < n;i++){
            high += weights[i];
            low = Math.max(low,weights[i]);
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isMidValid(weights,n,mid,days)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isMidValid(int[] weights,int n,int mid,int days){
        int curr = 1,pref = 0;
        for(int i = 0;i < n;i++){
            pref += weights[i];
            if(pref > mid){
                curr++;
                pref = weights[i];
            }
        }
        return curr <= days;
    }
}