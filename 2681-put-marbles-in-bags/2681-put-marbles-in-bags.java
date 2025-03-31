class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int ele = weights[0] + weights[n-1];
        for(int i = 1;i < n;i++){
            weights[i-1] += weights[i];
        }
        weights[n-1] = Integer.MAX_VALUE;
        Arrays.sort(weights);
        long maxi = ele,mini = ele;
        for(int i = 0;i < k-1;i++){
            mini += weights[i];
            maxi += weights[n-2-i];
        }
        return maxi - mini;
    }
}