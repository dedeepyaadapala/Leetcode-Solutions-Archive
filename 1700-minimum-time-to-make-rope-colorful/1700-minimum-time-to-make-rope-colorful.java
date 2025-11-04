class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0;
        for(int i = 0;i < n;i++){
            int j = i + 1;
            int maxi = neededTime[i];
            int sum = maxi;
            while(j < n && colors.charAt(i) == colors.charAt(j)){
                sum += neededTime[j];
                maxi = Math.max(maxi,neededTime[j]);
                j++;
            }
            if(i != j - 1){
                ans += sum - maxi;
            }
            i = j - 1;
        }
        return ans;
    }
}