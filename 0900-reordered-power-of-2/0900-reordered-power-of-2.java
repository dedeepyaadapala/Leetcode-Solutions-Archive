class Solution {
    static HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
    static{
        for(int i = 0;i < 31;i++){
            int curr = (1 << i);
            int temp = curr;
            HashMap<Integer,Integer> mp = new HashMap<>();
            while(temp > 0){
                mp.put(temp % 10,mp.getOrDefault(temp % 10,0)+1);
                temp /= 10;
            }
            map.put(curr,mp);
        }
    }
    public boolean reorderedPowerOf2(int n) {
        HashMap<Integer,Integer> mp1 = new HashMap<>();
        while(n > 0){
            mp1.put(n % 10,mp1.getOrDefault(n % 10,0)+1);
            n /= 10;
        }
        for(int i = 0;i < 31;i++){
            int curr = (1 << i);
            HashMap<Integer,Integer> mp = map.get(curr);
            if(mp1.size() != mp.size()) continue;
            boolean flag = true;
            for(Map.Entry<Integer,Integer> ent : mp1.entrySet()){
                if(ent.getValue() != mp.getOrDefault(ent.getKey(),0)){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}