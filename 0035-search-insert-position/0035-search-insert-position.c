int searchInsert(int* nums, int n, int target) {
    int i;
    for(i = 0;i < n;i++){
        if(nums[i] >= target){
            return i;
        }
    }
    return n;
}