class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE,high = 0;
        for(int i : bloomDay){
            high = Math.max(high,i);
            low = Math.min(low,i);
        }
        int n = bloomDay.length,ans = 0;
        if(n < (long)m*k) return -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isMidValid(bloomDay,n,mid,m,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isMidValid(int[] bloomDay,int n,int mid,int m,int k){
        int cnt = 0,curr = 0;
        for(int i = 0;i < n;i++){
            if(bloomDay[i] <= mid){
                cnt++;
            }else{
                curr += (cnt / k);
                cnt = 0;
            }
        }
        curr += (cnt / k);
        return curr >= m;
    }
}