class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int tot = 0;
        for(int i = 0;i < n;i++){
            tot += (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        if(tot == 0) return 0;
        int ans = 0,curr = tot,left = 0;
        for(int i = 0;i < n;i++){
            if(customers.charAt(i) =='Y'){
                tot--;
            }else{
                left++;
            }
            if(curr > left + tot){
                curr = left + tot;
                ans = i+1;
            }
        }
        return ans;
    }
}