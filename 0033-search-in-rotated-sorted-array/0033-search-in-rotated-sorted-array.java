class Solution {
    public int search(int[] arr, int target) {
        int low = 0,high = arr.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] >= arr[low]){
                if(arr[low] <= target && arr[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(arr[high] >= target && arr[mid] < target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}