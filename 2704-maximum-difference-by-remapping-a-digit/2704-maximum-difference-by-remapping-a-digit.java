class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int idx1 = 0,n = numStr.length();
        while(idx1 < n && numStr.charAt(idx1++) == '9');
        return Integer.valueOf(numStr.replaceAll(numStr.substring(idx1-1,idx1),"9")) - Integer.valueOf(numStr.replaceAll(numStr.substring(0,1),"0"));
    }
}