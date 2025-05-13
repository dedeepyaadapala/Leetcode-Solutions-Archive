class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = maxPossibleSpeed(piles,n);
        int speed = minValidSpeed(piles,n,maxi,h);
        return speed;
    }

    private static int minValidSpeed(int[] piles,int n,int high,int h){
        int low = 1, ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isMidValid(piles,n,mid,h)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isMidValid(int[] piles,int n,int mid,int h){
        for(int i = 0;i < n;i++){
            h -= (piles[i] + mid - 1) / mid;
        }
        return h >= 0;
    }

    private static int maxPossibleSpeed(int[] piles,int n){
        int maxi = 0;
        for(int i = 0;i < n;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        return maxi;
    }
}