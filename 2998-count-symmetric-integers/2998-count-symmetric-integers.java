class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        while(low <= high){
            int temp = low;
            int[] dig = new int[5];
            int curr = 0;
            while(temp > 0){
                dig[curr++] = temp % 10;
                temp /= 10;
            }
            if(curr % 2 != 0){
                low = (int)Math.pow(10,curr);
            }else{
                int sum = 0;
                for(int i = 0;i < curr/2;i++){
                    sum += (dig[i] - dig[curr-i-1]);
                }
                cnt += (sum == 0 ? 1 : 0);
            }
            low++;
        }
        return cnt;
    }
}