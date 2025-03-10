class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word,k) - atLeastK(word,k+1);
    }

    private static long atLeastK(String word,int k){
        long cnt = 0;
        HashMap<Character,Integer> vowels = new HashMap<>();
        int n = word.length();
        int left = 0,right = 0;
        int consonants = 0;
        while(right < n){
            char ch =  word.charAt(right);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowels.put(ch,vowels.getOrDefault(ch,0)+1);
            }else{
                consonants++;
            }
            // if(vowels.size() == 5 && consonants == k){
            //     cnt++;
            // }
            while(vowels.size() == 5 && consonants >= k){
                cnt += n - right;
                ch = word.charAt(left);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels.put(ch,vowels.get(ch)-1);
                    if(vowels.get(ch) == 0){
                        vowels.remove(ch);
                    }
                }else{
                    consonants--;
                }
                // if(vowels.size() == 5 && consonants == k){
                //     cnt++;
                // }
                left++;
            }
            right++;
            // while(vowels.size() <= 5 && consonants <= k && right < n){
            
            // }
        }
        return cnt;
    }
}