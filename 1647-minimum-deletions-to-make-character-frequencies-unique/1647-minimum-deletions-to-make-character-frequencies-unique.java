class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for(int i = 0;i < n;i++){
            cnt[s.charAt(i)-'a']++;
        }
        TreeMap<Integer,Integer> freq = new TreeMap<>(Collections.reverseOrder());
        for(int i : cnt){
            if(i != 0) freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int i = freq.firstKey();i > 0;i--){
            freq.putIfAbsent(i,0);
        }
        int ops = 0;
        for(int i : freq.keySet()){
            int currFreq = freq.get(i);
            int charFreq = i;
            if(currFreq > 1){
                freq.put(charFreq,1);
                if(i > 1) freq.put(i-1,freq.get(i-1)+currFreq-1);
                ops += currFreq - 1;
            }
        }
        return ops;
    }
}