class Solution {
    public int totalMoney(int n) {
        int mon = 1;
        int curr = 1;
        int bal = 0;
        for(int i = 1;i <= n;i++){
            bal += curr;
            if((i) % 7 == 0){
                mon += 1;
                curr = mon;
            }else{
                curr += 1;
            }
        }
        return bal;
    }
}