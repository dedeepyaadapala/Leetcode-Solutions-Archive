class Solution {
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = ((n % 2 == 0) ? even : n/2);
        return (int)((aPowb(5,even)*aPowb(4,odd)) % 1000000007);
    }

    public static long aPowb(long a,long b){
        long res = 1;
        while(b > 0){
            if(b % 2 != 0){
                res = (res * a) % 1000000007;
                b--;
            }
            a = (a * a) % 1000000007;
            b /= 2;
        }
        return res;
    }
}