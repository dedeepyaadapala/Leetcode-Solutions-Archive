class Solution {
    public int smallestRepunitDivByK(int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = 1;
        int cnt = 1;
        while(n % k != 0){
            int rem = n % k;
            if(set.contains(rem)) return -1;
            set.add(rem);
            n = ((rem * 10) + 1);
            cnt++;
        }
        return cnt;
    }
}