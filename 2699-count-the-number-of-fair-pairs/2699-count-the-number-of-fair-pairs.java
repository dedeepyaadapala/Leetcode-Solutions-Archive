class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long cnt = 0;
        int left = 0;
        while(left < n){
            int start = findCeil(nums,left+1,n-1,lower - nums[left]);
            int end = findFloor(nums,left+1,n-1,upper - nums[left]);
            if(start != - 1 && end != -1) cnt += end - start + 1;
            left++;
        }
        return cnt;
    }

    private static int findCeil(int[] nums,int low,int high,int target){
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findFloor(int[] nums,int low,int high,int target){
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            }else{
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}

// x + y >= lower
// y >= lower - x
// 2 3 4 5 6 7 9 10


// 0 1 4 4 5 7
// 0 4 -> 0 5
// 1 4 -> 1 5
