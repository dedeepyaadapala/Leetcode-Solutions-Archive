class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int i = 0,j = 0,ind = 0;
        if(m < n){
            return -1;
        }
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                ind = i+1;
                j++;
                while(ind < m && j < n){
                    if(haystack.charAt(ind) == needle.charAt(j)){
                        ind++;
                        j++;
                    }else{
                        j = 0;
                        break;
                    }
                }
                if(j == n){
                    return ind-j;
                }
            }
            i++;
        }
        return -1;
    }
}