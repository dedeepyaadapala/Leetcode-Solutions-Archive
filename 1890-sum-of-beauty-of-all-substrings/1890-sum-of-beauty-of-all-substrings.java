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
                int mxi = -1,mni = -1;
                for(int k = 0;k < 26;k++){
                    if(cnt[k] != 0 && maxi < cnt[k]){
                        maxi = Math.max(maxi,cnt[k]);
                        mxi = k;
                    }
                    if(cnt[k] != 0 && mini > cnt[k]){
                        mini = Math.min(mini,cnt[k]);
                        mni = k;
                    }
                }
                // System.out.println((char)('a'+mxi)+" "+maxi+" "+(char)('a'+mni)+" "+mini);
                sum += maxi - mini;

            }
            // cnt[s.charAt(i)-'a']--;
        }
        return sum;
    }
}