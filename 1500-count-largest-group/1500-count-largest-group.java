class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxi = 0;
        for(int i = 1;i <= n;i++){
            int curr = i,sum = 0;
            while(curr > 0){
                sum += (curr % 10);
                curr /= 10;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            maxi = Math.max(maxi,map.get(sum));
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> ent : map.entrySet()){
            if(ent.getValue() == maxi) cnt++;
        }
        return cnt;
    }
}