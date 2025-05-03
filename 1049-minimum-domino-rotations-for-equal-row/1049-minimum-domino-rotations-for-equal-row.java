class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] cnt = new int[6];
        for(int i = 0;i < n;i++){
            cnt[tops[i]-1]++;
            cnt[bottoms[i]-1]++;
        }
        if(cnt[0] < n && cnt[1] < n && cnt[2] < n && cnt[3] < n && cnt[4] < n && cnt[5] < n) return -1;
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i <= 6;i++){
            ans = Math.min(ans,minOps(i,tops,bottoms,n));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int minOps(int num,int[] tops,int[] bottoms,int n){
        int ans = Integer.MAX_VALUE;
        int t = 0,b = 0;
        for(int i = 0;i < n;i++){
            if(tops[i] == num && bottoms[i] == num){
                t++;
                b++;
            }
            else if(tops[i] == num) t++;
            else if(bottoms[i] == num) b++;
            else return ans;
        }
        return n - Math.max(t,b);
    }
}