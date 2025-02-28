class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0;i < n;i++){
            int[] cnt = new int[26];
            for(int j = i;j < n;j++){
                int idx = s.charAt(j)-'a';
                cnt[idx]++;
                int maxi = -1,mini = n+1;
                for(int k = 0;k < 26;k++){
                    if(cnt[k] != 0){
                        maxi = Math.max(maxi,cnt[k]);
                        mini = Math.min(mini,cnt[k]);
                    }
                }
                sum += maxi - mini;

            }
        }
        return sum;
    }
}