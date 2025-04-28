class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int uni[] = new int[n];
        int ind = 0;
        for(int i = 0;i < n;i++){
            int flag = 0;
            for(int j = 0;j < ind;j++){
                if(nums[i] == uni[j]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                uni[ind] = nums[i];
                ind += 1;
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i < ind;i++){
            int count = 0;
            for(int j = 0; j < n;j++){
                if(uni[i] == nums[j]){
                    count += 1;
                }
            }
            if (count > n / 3){
                arr.add(uni[i]);
            }
        }
        return arr;
    }
}