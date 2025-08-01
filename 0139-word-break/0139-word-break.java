class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Node trie = new Node();
        int n = wordDict.size();
        for(int i = 0;i < n;i++){
            String str = wordDict.get(i);
            int x = str.length();
            Node curr = trie;
            for(int j = 0;j < x;j++){
                int idx = str.charAt(j) - 'a';
                if(curr.child[idx] == null)
                    curr.child[idx] = new Node();
                curr = curr.child[idx];
            }
            curr.isLast = true;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return findPartitions(s,0,s.length(),trie,dp);
    }

    private static boolean findPartitions(String s,int idx,int n,Node trie,int[] dp){
        if(idx == n) return true;
        if(dp[idx] != -1) return dp[idx] == 1;
        Node curr = trie;
        while(idx < n){
            if(curr.child[s.charAt(idx)-'a'] == null){
                dp[idx] = 0;
                return false;
            }
            curr = curr.child[s.charAt(idx)-'a'];
            if(curr.isLast && findPartitions(s,idx+1,n,trie,dp)){
                dp[idx] = 1;
                return true;
            }
            idx++;
        }
        return false;
    }
}

class Node{
    Node[] child = new Node[26];
    boolean isLast;
    Node(){
        for(int i = 0;i < 26;i++){
            this.child[i] = null;
        }
        this.isLast = false;
    }
}