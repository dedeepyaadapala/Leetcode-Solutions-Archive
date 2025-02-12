class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0;i < n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort((entry1,entry2) -> entry1.getValue().compareTo(entry2.getValue()));
        StringBuilder sb = new StringBuilder();
        for(int x = lst.size()-1;x >= 0;x--){
            int count = lst.get(x).getValue();
            char ch = lst.get(x).getKey();
            for(int i = 0;i < count;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}