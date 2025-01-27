class Solution {
    public int myAtoi(String x) {
        String s = x.strip();
        int num = 0,n = s.length();
        if(n == 0 || (s.charAt(0) < '0' || s.charAt(0) > '9') && (s.charAt(0) != '-' && s.charAt(0) != '+')) return 0;
        num = (s.charAt(0) == '-' || s.charAt(0) == '+' ? 0 : s.charAt(0)-'0');
        System.out.println(num+" "+s.charAt(0));
        boolean isNeg = (s.charAt(0) == '-') ;
        for(int i = 1;i < n;i++){
            char ch = s.charAt(i);
            System.out.println(i+" "+num+" "+ch);
            if(ch < '0' || ch > '9') break;
            if(num > (Integer.MAX_VALUE - (ch - '0'))/10) return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            num = num * 10 + (s.charAt(i)-'0');
        }
        return isNeg ? -num : num;
    }
}