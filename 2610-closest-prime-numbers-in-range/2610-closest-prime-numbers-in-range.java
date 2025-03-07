class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i * i <= 1000000;i++){
            if(isPrime[i]){
                for(int j = i * i;j <= 1000000;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2;i <= 1000000;i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        // System.out.println(primes);
        int[] num = new int[2];
        num[0] = -1;
        num[1] = -1;
        int ceil = findCeil(primes,primes.size(),left);
        int floor = findFloor(primes,primes.size(),right);
        int mini = Integer.MAX_VALUE;
        // System.out.print(ceil+" "+floor);
        if(ceil == -1 || floor == -1) return num;
        for(int i = ceil;i < floor;i++){
            int diff = primes.get(i+1) - primes.get(i);
            if(mini > diff){
                mini = diff;
                num[0] = primes.get(i);
                num[1] = primes.get(i+1);
            }
        }
        return num;
    }

    private static int findCeil(ArrayList<Integer> lst,int n,int num){
        int low = 0,high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = (low + (high - low)/2);
            if(lst.get(mid) >= num){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

     private static int findFloor(ArrayList<Integer> lst,int n,int num){
        int low = 0,high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = (low + (high - low)/2);
            if(lst.get(mid) <= num){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
     }
}