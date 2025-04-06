class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] indices = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0;i < n;i++){
            indices[i] = i;
        }
        int maxLen = -1,maxInd = -1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        indices[i] = j;
                    }
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxInd = i;
            }
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(nums[maxInd]);
        while(maxInd != indices[maxInd]){
            lst.add(nums[indices[maxInd]]);
            maxInd = indices[maxInd];
        }
        Collections.reverse(lst);
        return lst;
    }
}