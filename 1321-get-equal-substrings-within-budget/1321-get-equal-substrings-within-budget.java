class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for(int i = 0;i < n;i++){
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for(int i = 1;i < n;i++){
            diff[i] += diff[i-1]; 
        }
        int i = 0,j = 0,ans = 0;
        while(j < n){
            int curr = diff[j] - (i == 0 ? 0 : diff[i-1]);
            if(curr <= maxCost){
                ans = Math.max(ans,j-i+1);
                j++;
            }else{
                i++;
            }
        }
        return ans;
    }
}