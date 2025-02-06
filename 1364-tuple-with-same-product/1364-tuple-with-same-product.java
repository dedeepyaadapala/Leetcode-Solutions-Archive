class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            for(int j = n-1;j >= 0;j--){
                if(i != j){
                int target = nums[i]*nums[j];
                int p1 = i+1,p2 = j-1;
                while(p1 < p2){
                    int res = nums[p1] * nums[p2];
                    if(res == target){
                        cnt += 8;
                        p1++;
                        p2--;
                    }else if(res < target){
                        p1++;
                    }else{
                        p2--;
                    }
                }}
            }
        }
        return cnt;
    }
}