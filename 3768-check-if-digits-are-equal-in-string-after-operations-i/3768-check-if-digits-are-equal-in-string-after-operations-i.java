class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int x = sb.length();
        while(x > 2){
            for(int i = 1;i < x;i++){
                int y = (sb.charAt(i-1) -'0' + sb.charAt(i) -'0') % 10;
                sb.replace(i-1,i,String.valueOf(y));
            }
            sb.deleteCharAt(x-1);
            x = sb.length();
        }
        return sb.charAt(0) == sb.charAt(1);
    }
}