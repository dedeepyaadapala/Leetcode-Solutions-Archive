class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,new Comparator<int[]>(){
                public int compare(int[] a,int[] b){
                    return a[1] - b[1];
                }
            }
        );
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        for(int[] course : courses){
            curr += course[0];
            pq.add(course[0]);
            if(curr > course[1]) curr -= pq.poll();
        }
        return pq.size();
    }
}