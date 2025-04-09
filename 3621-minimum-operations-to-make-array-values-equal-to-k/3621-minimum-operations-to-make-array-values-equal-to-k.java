class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int i: nums) set.add(i);
        for(int i: set){
            if(i > k) cnt++;
            else if(i < k) return -1;
        }
        return cnt;
    }
}