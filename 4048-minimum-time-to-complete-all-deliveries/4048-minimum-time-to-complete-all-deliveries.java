class Solution {
    public long minimumTime(int[] d, int[] r) {
        long ans = Long.MAX_VALUE;
        long low = d[0] + d[1];
        long high = Long.MAX_VALUE;
        long lcm = calculateLCM(r[0],r[1]);
        while(low <= high){
            long mid = low + (high - low) / 2;
            long tot = mid - (mid / lcm);
            long t1 = mid - (mid / r[0]);
            long t2 = mid - (mid / r[1]);
            if(tot >= d[0] + d[1] && t1 >= d[0] && t2 >= d[1]){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static long calculateLCM(int num1,int num2){
        return ((long)num1 * num2) / hcf(Math.max(num1,num2),Math.min(num1,num2));
    }

    private static int hcf(int num1,int num2){
        if(num2 == 0) return num1;
        num1 = num1 % num2;
        if(num1 < num2){
            return hcf(num2,num1);
        }
        return hcf(num1,num2);
    }
}
