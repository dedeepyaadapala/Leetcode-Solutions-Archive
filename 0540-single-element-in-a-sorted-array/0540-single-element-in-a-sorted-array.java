class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low = 0,high = n-1;
        int mid = low + (high - low) / 2;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mid % 2 == 0){
                if(mid < n-1 && arr[mid] == arr[mid+1]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if(mid > 0 && arr[mid] == arr[mid-1]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return mid % 2 == 0 ? arr[mid] : arr[mid+1];
    }
}