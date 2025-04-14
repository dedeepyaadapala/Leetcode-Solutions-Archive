class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // Arrays.sort(arr);
        int cnt = 0;
        int n = arr.length;
        for(int i = 0;i < n-2;i++){
            for(int j = i+1;j < n-1;j++){
                for(int k = j+1;k < n;k++){
                    cnt += (Math.abs(arr[i]-arr[j]) <= a && Math.abs(arr[j]-arr[k]) <= b && Math.abs(arr[i]-arr[k]) <= c) ? 1 : 0;
                }
            }
        }
        return cnt;
    }
}