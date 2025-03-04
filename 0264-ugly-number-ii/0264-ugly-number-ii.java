class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        minHeap.add(1l);
        set.add(1l);
        long curr = 1;
        for(int i = 0;i < n;i++){
            curr = minHeap.poll();
            if(!set.contains(curr * 2)){
                minHeap.add(curr * 2);
                set.add(curr * 2);
            }
            if(!set.contains(curr * 3)){
                minHeap.add(curr * 3);
                set.add(curr * 3);
            }
            if(!set.contains(curr * 5)){
                minHeap.add(curr * 5);
                set.add(curr * 5);
            }
        }
        return (int) curr;
    }
}