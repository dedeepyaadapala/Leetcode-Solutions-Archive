class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k];
        Arrays.sort(arr);
        int mid = arr[(n-1)/2];
        int i = 0,j = n-1;
        int idx = 0;
        while(i <= j){
            int small = Math.abs(arr[i] - mid);
            int large = Math.abs(arr[j] - mid);
            if(small > large){
                ans[idx++] = arr[i++];
            }else{
                ans[idx++] = arr[j--];
            }
            if(idx == k) break;
        }
        return ans;
    }
}