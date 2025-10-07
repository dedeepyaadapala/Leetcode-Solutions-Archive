class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 0,high = position[n-1],ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(position,n,mid,m-1)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] pos,int n,int mid,int k){
        int prev = pos[0];
        for(int i = 1;i < n;i++){
            if(pos[i] - prev >= mid){
                prev = pos[i];
                k--;
            }
        }
        return k <= 0;
    }
}