class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if(!((s1+s2).equals(s2+s1))) return "";
        int n1 = s1.length();
        int n2 = s2.length();
        int gcd = findGCD(Math.max(n1,n2),Math.min(n1,n2));
        return s1.substring(0,gcd);
    }

    private static int findGCD(int a,int b){
        if(b == 0) return a;
        return findGCD(b,a % b);
    }
}