class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        HashMap<Integer,Integer> mp = new HashMap<>();
        int cnt = 0,ele = nums.get(0);
        for(int i = 0;i < n;i++){
            int val = nums.get(i);
            mp.put(val,mp.getOrDefault(val,0)+1);
            if(val == ele){
                cnt++;
            }else if(cnt < 0){
                ele = val;
                cnt = 1;
            }else{
                cnt--;
            }
            if(mp.get(val) > (i+1) / 2 && map.get(val) - mp.get(val) > (n-i-1)/2){
                return i;
            }
        }
        return -1;
    }
}