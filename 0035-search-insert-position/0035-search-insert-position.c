int searchInsert(int* nums, int n, int target) {
    // int i;
    // for(i = 0;i < n;i++){
    //     if(nums[i] >= target){
    //         return i;
    //     }
    // }
    // return n;


    int low = 0,high = n-1;
    while(low <= high){
        int mid = low + (high - low) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
    return low;
}