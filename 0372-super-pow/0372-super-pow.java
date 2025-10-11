class Solution {
    static int mod = 1337;
    public int superPow(int a, int[] b) {
        int n = b.length;
        long ans = 1;
        for(int i = 0;i < n;i++){
            b[i] = computePower(a,b[i]);
        }
        for(int i = 0;i < n;i++){
            for(int j = 1;j <= n-i-1;j++){
                b[i] = computePower(b[i],10);
            }
        }
        for(int i = 0;i < n;i++){
            ans = (ans * b[i]) % mod;
        }
        return (int) ans;
    }

    private static int computePower(int a,int b){
        if(b == 0) return 1;
        if(b == 1) return a;
        long base = a;
        long ans = 1;
        while(b > 0){
            if(b % 2 != 0){
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            b /= 2;
        }
        return (int) ans;
    }

}

// 10 -> 5, 5
// 5 -> 4, 1
// 4 -> 2, 2
// 2 -> 1, 1

// b = 10 -> even -> ans = 1 -> base = 2^2
// b = 5 -> odd -> ans = 2 -> base = 2^4
// b = 2 -> even -> ans = 2 -> base = 2^8
// b = 1 -> odd -> ans = 2^2 -> base = 2^16
