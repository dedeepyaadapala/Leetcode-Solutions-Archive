class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int[] cnt = new int[51];
        for(int i = 0;i < k;i++){
            cnt[nums[i]]++;
        }
        ans[0] = xSum(cnt,x);
        for(int i = k;i < n;i++){
            cnt[nums[i]]++;
            cnt[nums[i-k]]--;
            ans[i-k+1] = xSum(cnt,x);
        }
        return ans;
    }

    private static int xSum(int[] count,int x){
        int[] dup = Arrays.copyOf(count,51);
        int cnt = 0;
        for(int i = 0;i < x;i++){
            int maxi = 0;
            for(int j = 1;j <= 50;j++){
                if(dup[maxi] <= dup[j]){
                    maxi = j;
                }
            }
            if(dup[maxi] == 0){
                break;
            }
            cnt += (maxi * dup[maxi]);
            dup[maxi] = 0;
        }
        return cnt;
    }
}