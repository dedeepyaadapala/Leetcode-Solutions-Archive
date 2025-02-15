class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int maxi = 0;
        for(int i: set){
            if(!set.contains(i-1)){
                int x = i;
                int cnt = 1;
                while(set.contains(x+1)){
                    cnt += 1;
                    x += 1;
                }
                maxi = Math.max(maxi,cnt);
            }
        }
        return maxi;
    }
}