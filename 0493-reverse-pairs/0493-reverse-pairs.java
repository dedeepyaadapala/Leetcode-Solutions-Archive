class Solution {
    static int cnt;
    static int[] arr = new int[50001];
    public int reversePairs(int[] nums) {
        int n = nums.length;
        cnt = 0;
        mergeSort(nums,0,n-1);
        return cnt;
    }
    private static void mergeSort(int[] nums,int low,int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private static void merge(int[] nums,int low,int mid,int high){
        int i = low,j = mid + 1;
        int idx = 0;
        int p1 = low,p2 = mid+1;
        while(i <= mid && j <= high){
            while(p1 <= mid && p2 <= high && (long)nums[p1] <= (long)nums[p2] * 2){
                p1++;
            }
            if(p1 <= mid && p2 <= high && (long)nums[p1] > 2 * (long)nums[p2]){
                cnt += (mid - p1 + 1);
                p2++;
            }
            if(nums[i] <= nums[j]){
                arr[idx] = nums[i++];
            }else{
                arr[idx] = nums[j++];
            }
            idx++;
        }
        while(i <= mid){
            arr[idx++] = nums[i++];
        }
        while(j <= high){
            while(p1 <= mid && p2 <= high && (long)nums[p1] <= (long)nums[p2] * 2){
                p1++;
            }
            if(p1 <= mid && p2 <= high && (long)nums[p1] > 2 * (long)nums[p2]){
                cnt += (mid - p1 + 1);
                p2++;
            }
            arr[idx++] = nums[j++];
        }
        for(int k = 0;k < idx;k++){
            nums[k+low] = arr[k];
        }
    }
}

// 1  3  2  3  1
// 1 2 3  1 3