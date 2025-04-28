class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0,p2 = 0;
        int n1 = g.length,n2 = s.length;
        int cnt = 0;
        while(p1 < n1 && p2 < n2){
            if(g[p1] <= s[p2]){
                cnt++;
                p1++;
                p2++;
            }else{
                p2++;
            }
        }
        return cnt;
    }
}