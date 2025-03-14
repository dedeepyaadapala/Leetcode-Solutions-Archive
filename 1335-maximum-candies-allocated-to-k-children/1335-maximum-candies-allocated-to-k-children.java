class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long sum = 0l;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            sum = sum + candies[i];
            maxi = Math.max(maxi,candies[i]);
        }
        int low = 1,high = maxi;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isSplitPossible(candies,mid,k,n)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isSplitPossible(int[] candies,int mid,long k,int n){
        long cnt = 0l;
        for(int i = 0;i < n;i++){
            cnt += (candies[i] / mid);
        }
        return cnt >= k;
    }
}