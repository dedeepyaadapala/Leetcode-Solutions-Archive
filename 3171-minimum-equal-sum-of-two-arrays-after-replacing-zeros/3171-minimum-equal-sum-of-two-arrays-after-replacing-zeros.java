class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0l, sum2 = 0l;
        int n1 = nums1.length,n2 = nums2.length;
        int cnt01 = 0, cnt02 = 0;
        for(int i = 0;i < n1;i++){
            sum1 += nums1[i];
            cnt01 += (nums1[i] == 0 ? 1 : 0);
        }
        for(int i = 0;i < n2;i++){
            sum2 += nums2[i];
            cnt02 += (nums2[i] == 0 ? 1 : 0);
        }
        if(sum1 == sum2 && cnt01 == 0 && cnt02 == 0) return sum1;
        if((cnt01 == 0 && sum2 + cnt02 > sum1) ||
        (cnt02 == 0 && sum1 + cnt01 > sum2)) return -1;
        return Math.max(sum1+cnt01,sum2+cnt02);
    }
}