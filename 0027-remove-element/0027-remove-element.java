class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = -1,p2 = -1,n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] == val){
                p1 = i;
                p2 = i;
                break;
            }
        }
        if(p1 == -1) return n;
        while(p2 < n){
            if(nums[p1] != val){
                p1++;
            }else if(nums[p2] == val){
                p2++;
            }else{
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1++;
                p2++;
            }
        }
        // if(p2 == n) return 0;
        return p1;
    }
}