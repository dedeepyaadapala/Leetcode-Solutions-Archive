class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> sumToNums = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int sum = 0;
            int temp = nums[i];
            while(temp > 0){
                sum += (temp % 10);
                temp /= 10;
            }
            if(!sumToNums.containsKey(sum)){
                sumToNums.put(sum,new ArrayList<>());
            }
            sumToNums.get(sum).add(nums[i]);
        }
        int maxi =Integer.MIN_VALUE;
        for(Map.Entry<Integer,ArrayList<Integer>> entry : sumToNums.entrySet()){
            ArrayList<Integer> list = entry.getValue();
            if(list.size() < 2) continue;
            Collections.sort(list);
            maxi = Math.max(maxi,list.get(list.size()-1)+list.get(list.size()-2));
        }
        if(maxi == Integer.MIN_VALUE) return -1;
        return maxi;
    }
}