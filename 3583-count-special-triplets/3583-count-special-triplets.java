class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> pref = new HashMap<>();
        HashMap<Integer,Integer> tot = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            tot.put(nums[i],tot.getOrDefault(nums[i],0)+1);
        }
        long cnt = 0l;
        for(int i = 0;i < n;i++){
            tot.put(nums[i],tot.getOrDefault(nums[i],0)-1);
            if(tot.get(nums[i]) <= 0) tot.remove(nums[i]);
            cnt = (cnt + ((long)pref.getOrDefault(nums[i]*2,0) * tot.getOrDefault(nums[i] * 2,0)) % 1000000007) % 1000000007;
            pref.put(nums[i],pref.getOrDefault(nums[i],0)+1);
        }
        return (int) cnt;
    }
}