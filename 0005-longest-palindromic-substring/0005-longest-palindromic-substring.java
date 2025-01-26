class Solution {
    public String longestPalindrome(String s) {
        int ind1 = -1,ind2 = -1;
        int len = 0, n = s.length();
        for(int i = 0;i < n;i++){
            int j = i,k = i+1;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            if(len < k-j-1){
                len = k-j-1;
                ind1 = j+1;
                ind2 = k;
            }
            j = i-1;
            k = i+1;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            if(len < k-j-1){
                len = k-j-1;
                ind1 = j+1;
                ind2 = k;
            }
        }
        return s.substring(ind1,ind2);
    }
}