class Solution {
    public int maxFrequency(int[] nums, int k) {
        int cnt = 0,ans = 0;
        for(int i: nums){
            cnt += (i == k ? 1 : 0);
        }
        for(int i = 1;i <= 50;i++){
            if(i == k) continue;
            int curr = 0, maxi = 0;
            for(int j: nums){
                if(j == i){
                    curr++;
                }else if(j == k){
                    curr--;
                }
                curr = Math.max(curr,0);
                maxi = Math.max(maxi,curr);
            }
            ans = Math.max(maxi,ans);
        }
        return cnt + ans;
    }
}