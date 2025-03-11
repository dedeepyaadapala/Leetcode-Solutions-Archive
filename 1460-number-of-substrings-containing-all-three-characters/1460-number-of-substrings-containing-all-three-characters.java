class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        // for(int i = 0;i < n;i++){
        //     HashSet<Character> set = new HashSet<>();
        //     for(int j = i;j < n;j++){
        //         set.add(s.charAt(j));
        //         if(set.size() == 3){
        //             cnt = cnt + (n - j);
        //             break;
        //         }
        //     }
        // }

        int left = 0,right = 0;
        int[] freq = new int[3];
        while(right < n){
            freq[s.charAt(right)-'a']++;
            while(left <= right && freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                cnt = cnt + (n - right);
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;

        }
        return cnt;
    }
}