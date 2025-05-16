class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0;i < n;i++){
            prev[i] = i;
        }
        int maxlen = dp[0],maxIdx = 0;
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(groups[i] != groups[j] && words[i].length() == words[j].length()){
                    int cnt = 0;
                    for(int k = words[i].length()-1;k >= 0;k--){
                        if(words[i].charAt(k) != words[j].charAt(k)){
                            cnt++;
                            if(cnt == 2) break;
                        }
                    }
                    if(cnt == 1 && dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        prev[i] = j;
                    }
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                maxIdx = i;
            }
        }
        List<String> lst = new ArrayList<>();
        while(prev[maxIdx] != maxIdx){
            lst.add(0,words[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        lst.add(0,words[maxIdx]);
        return lst;
    }
}