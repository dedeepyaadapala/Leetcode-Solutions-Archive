class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[]{-1,-1};
        for(int i = 1;i <= n/2;i++){
            int val1 = i,val2 = n-i;
            boolean flag1 = true,flag2 = true;
            while(val1 > 0){
                if(val1 % 10 == 0){
                    flag1 = false;
                    break;
                }
                val1 /= 10;
            }
            while(val2 > 0){
                if(val2 % 10 == 0){
                    flag2 = false;
                    break;
                }
                val2 /= 10;
            }
            if(flag1 && flag2){
                res[0] = i;
                res[1] = n - i;
                break;
            }
        }
        return res;
    }
}