class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            cnt = Math.max(cnt,mp.getValue()+map.getOrDefault(mp.getKey()-1,-mp.getValue()));
            cnt = Math.max(cnt,mp.getValue()+map.getOrDefault(mp.getKey()+1,-mp.getValue()));
        }
        return cnt;
    }
}