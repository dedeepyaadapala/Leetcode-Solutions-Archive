class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        int n = strs.length;
        for(int i = 0;i < strs[0].length();i++){
            boolean flag = true;
            for(int j = 1;j < n;j++){
                if((strs[j].length() > i && strs[0].charAt(i) != strs[j].charAt(i)) || (strs[j].length() <= i)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                len += 1;
            }else{
                break;
            }
        }
        if(len == 0){
            return "";
        }
        return strs[0].substring(0,len);
    }
}