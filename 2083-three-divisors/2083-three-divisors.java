class Solution {
    public boolean isThree(int n) {
        if(n <= 3) return false;
        for(int i = 1;i * i <= n;i++){
            if(isPrime(i) && i * i == n){
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2;i * i <= n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}