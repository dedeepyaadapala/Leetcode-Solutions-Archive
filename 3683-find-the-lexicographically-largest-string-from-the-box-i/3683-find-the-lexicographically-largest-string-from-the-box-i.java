class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        char max = word.charAt(0);
        int n = word.length();
        for(int i = 1;i < n;i++){
            char ch = word.charAt(i);
            if(ch > max){
                max = ch;
            }
        }
        String res = "";
        for(int i = 0;i < n;i++){
            if(word.charAt(i) == max){
                if(i+1 >= numFriends){
                    if(res.compareTo(word.substring(i)) < 0){
                        res = word.substring(i);
                    }
                }else{
                    if(res.compareTo(word.substring(i,n-numFriends+i+1)) < 0){
                        res = word.substring(i,n-numFriends+i+1);
                    }
                }
            }
        }
        return res;
    }
}