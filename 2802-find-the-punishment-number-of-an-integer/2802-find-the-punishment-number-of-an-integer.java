class Solution {
    static HashMap<Integer,Integer> map = new HashMap<>();
    
    static private boolean canBePartitioned(int n,int num){
        if(num < 0 || n < num) return false;
        if(n == num) return true;
        return canBePartitioned(n/10,num-(n % 10)) || canBePartitioned(n/100,num-(n % 100)) || canBePartitioned(n/1000,num-(n % 1000));
    }
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1;i <= 1000;i++){
            int sqr = i * i;
            if(canBePartitioned(sqr,i)){
                map.put(i,sqr);
            }
        }
        for(int i : map.keySet()){
            if(i <= n){
                res += map.get(i);
                System.out.println(i);
            }
        }
        System.out.println(map);
        return res;
    }
}