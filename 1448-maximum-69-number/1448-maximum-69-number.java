class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int len = sb.length();
        boolean flag = true;
        for(int i = 0;i < len;i++){
            if(sb.charAt(i) == '6'){
                flag = false;
                sb.setCharAt(i,'9');
                break;
            }
        }
        if(flag) return num;
        return Integer.valueOf(sb.toString()); 
    }
}