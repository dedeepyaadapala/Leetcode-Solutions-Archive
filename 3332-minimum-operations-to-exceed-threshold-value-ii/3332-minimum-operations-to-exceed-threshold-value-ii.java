class Solution {
    public int minOperations(int[] nums, int k) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        int n = nums.length;
        if(n < 2) return 0;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            map.put((long)nums[i],map.getOrDefault((long)nums[i],0)+1);
        }
        while(map.firstKey() < k && map.size() >= 1){
            Map.Entry<Long,Integer> curr1 = map.pollFirstEntry();
            long key1 = curr1.getKey();
            if(curr1.getValue() >= 2){
                map.put(key1*3,map.getOrDefault(key1*3,0)+1);
                if(curr1.getValue() > 2) map.put(curr1.getKey(),curr1.getValue()-2);
            }else{
                if(map.size() >= 1){
                    long key2 = map.firstKey();
                    long val = Math.min(key1,key2)*2 + Math.max(key1,key2);
                    map.put(val,map.getOrDefault(val,0)+1);
                    if(map.get(key2) > 1) map.put(key2,map.get(key2)-1);
                    else map.pollFirstEntry();
                    if(curr1.getValue() != 1) map.put(key1,curr1.getValue()-1);
                }
            }
            cnt++;
        }
        return cnt;
    }
}