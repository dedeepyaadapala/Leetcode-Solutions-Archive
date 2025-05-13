class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int cnt = arr[0]-1;
        if(k <= cnt){
            return k;
        }
        for(int i = 1;i < n;i++){
            if(cnt + (arr[i] - arr[i-1] - 1) >= k){
                return arr[i-1] + (k - cnt);
            }
            cnt += (arr[i] - arr[i-1] - 1);
        }
        return arr[n-1] + (k - cnt);
    }
}