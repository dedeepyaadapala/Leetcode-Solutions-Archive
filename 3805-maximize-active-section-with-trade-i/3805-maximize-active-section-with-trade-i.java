class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length(),cnt = 0;
        ArrayList<int[]> lst = new ArrayList<>();
        lst.add(new int[]{1,1});
        for(int i = 0;i < n;i++){
            int[] ar = lst.get(lst.size()-1);
            if(s.charAt(i)-'0' == ar[0]){
                ar[1]++;
                if(ar[0] == 1) cnt++;
            }else{
                lst.add(new int[]{1-ar[0],1});
                if(ar[0] == 0) cnt++;
            }
        }
        if(lst.get(lst.size()-1)[0] == 1){
            lst.get(lst.size()-1)[1]++;
        }else{
            lst.add(new int[]{1,1});
        }
        int ll = lst.size();
        int maxi = 0;
        for(int i = 1;i+2 < ll-1;i+=2){
            maxi = Math.max(maxi,lst.get(i)[1] + lst.get(i+2)[1]);
        }
        return cnt+maxi;
    }
}