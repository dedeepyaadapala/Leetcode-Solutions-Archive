class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int majority = nums.get(0),cnt = 0;
        for(int i: nums){
            if(i == majority){
                cnt++;
            }else if(cnt == 0){
                majority = i;
                cnt = 1;
            }else{
                cnt--;
            }
        }
        cnt = 0;
        for(int i: nums){
            if(i == majority){
                cnt++;
            }
        }
        int curr_cnt = 0;
        for(int i = 0;i < n;i++){
            if(nums.get(i) == majority){
                curr_cnt++;
            }
            if(curr_cnt > (i+1)/2 && cnt - curr_cnt > (n-i-1)/2){
                return i;
            }
        }
        return -1;
    }
}