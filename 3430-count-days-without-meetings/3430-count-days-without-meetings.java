class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> a[0]-b[0]);
        ArrayList<int[]> finalInt = new ArrayList<>();
        int n = meetings.length;
        for(int i = 0;i < n;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            while(i+1 < n && meetings[i+1][0] <= end){
                i++;
                end = Math.max(end,meetings[i][1]);
            }
            finalInt.add(new int[]{start,end});
            // System.out.println(start+" "+end);
        }
        n = finalInt.size();
        int cnt = finalInt.get(0)[0]-1;
        for(int i = 1;i < n;i++){
            cnt += (finalInt.get(i)[0] - finalInt.get(i-1)[1] - 1);
        }
        cnt += (days - finalInt.get(n-1)[1]);
        return cnt;
    }
}