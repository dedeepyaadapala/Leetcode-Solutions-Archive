class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> lst = new ArrayList<>();
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = n-1;
        while(left < n && right >= 0){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch,right);
            }
            char ch2 = s.charAt(left);
            if(map.containsKey(ch2)){
                int maxi = map.get(ch2);
                for(int i = left;i < maxi;i++){
                    if(map.getOrDefault(s.charAt(i),-1) > maxi){
                        maxi = map.get(s.charAt(i));
                    }
                }
                lst.add(maxi - left + 1);
                left = maxi+1;
            }else{
                right--;
            }
        }
        return lst;
    }
}