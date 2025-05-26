class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = words.length;
        for(int i = 0;i < n;i++){
            String s1 = words[i];
            map.put(s1,map.getOrDefault(s1,0)+1);
        }
        ArrayList<String> lst = new ArrayList<>(map.keySet());
        int cnt = 0;
        boolean isEven = false;
        while(lst.size() != 0){
            String s1 = lst.get(0);
            String rev = new StringBuilder(s1).reverse().toString();
            if(map.containsKey(rev)){
                if(!s1.equals(rev)){
                    cnt += (4 * Math.min(map.get(s1),map.get(rev)));
                    lst.remove(rev);
                    map.remove(rev);
                }else{
                    cnt += 4 * (map.get(s1) / 2);
                }
            }
            if(map.get(s1) % 2 != 0 && s1.charAt(0) == s1.charAt(1)){
                isEven = true;
            }
            map.remove(s1);
            lst.remove(s1);
        }
        if(isEven) cnt += 2;
        return cnt;
    }
}