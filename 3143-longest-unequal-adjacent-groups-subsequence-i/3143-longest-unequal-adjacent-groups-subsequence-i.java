class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        List<String> lst = new ArrayList<>();
        lst.add(words[0]);
        for(int i = 1;i < n;i++){
            if(groups[i] != groups[i-1]){
                lst.add(words[i]);
            }
        }
        return lst;
    }
}