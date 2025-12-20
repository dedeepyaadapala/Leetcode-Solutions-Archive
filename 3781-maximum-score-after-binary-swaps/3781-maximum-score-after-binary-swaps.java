class Solution {
    public long maximumScore(int[] nums, String s) {
        long score = 0;
        int n = nums.length;
        int last1 = -1,cnt1 = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i < n;i++){
            pq.add(nums[i]);
            if(s.charAt(i) == '1'){
                score += pq.poll();
                last1 = i;
                cnt1++;
            }
        }
        // if(last1 == -1) return 0;
        // for(int i = 0;i <= last1;i++){
        //     pq.add(nums[i]);
        // }
        // for(int i = 0;i < cnt1;i++){
        //     score += pq.poll();
        // }
        return score;
    }
}