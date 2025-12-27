class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int len = meetings.length;
        for(int i = 0;i < len;i++) meetings[i][1]--;
        Arrays.sort(meetings,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                // if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        // for (int[] i : meetings) System.out.print("["+i[0]+","+i[1]+"],");
        long[] flag = new long[n];
        Arrays.fill(flag,-1);
        int[] cnt = new int[n];
        for(int i = 0;i < len;i++){
            long start = meetings[i][0],end = meetings[i][1];
            boolean filled = false;
            long mini = Long.MAX_VALUE;
            int idx = -1;
            for(int j = 0;j < n;j++){
                if(flag[j] < start){
                    cnt[j]++;
                    flag[j] = end;
                    filled = true;
                    break;
                }
                if(flag[j] < mini){
                    mini = flag[j];
                    idx = j;
                }
            }
            if(!filled){
                long diff = (end - start);
                start = mini + 1;
                end = start + diff;
                flag[idx] = end;
                cnt[idx]++;
            }
        }
        int maxi = 0;
        for(int i = 1;i < n;i++){
            maxi = (cnt[i] > cnt[maxi] ? i : maxi);
        }
        return maxi;
    }
}