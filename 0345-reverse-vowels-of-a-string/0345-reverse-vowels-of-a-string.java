class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int p1 = 0,p2 = n-1;
        while(p1 <= p2){
            if(!(ch[p1] == 'a' || ch[p1] == 'e' || ch[p1] == 'i' || ch[p1] == 'o' || ch[p1] == 'u')
             && !(ch[p1] == 'A' || ch[p1] == 'E' || ch[p1] == 'I' || ch[p1] == 'O' || ch[p1] == 'U')){
                p1++;
            }else if(!(ch[p2] == 'a' || ch[p2] == 'e' || ch[p2] == 'i' || ch[p2] == 'o' || ch[p2] == 'u')
             && !(ch[p2] == 'A' || ch[p2] == 'E' || ch[p2] == 'I' || ch[p2] == 'O' || ch[p2] == 'U')){
                p2--;
            }else{
                char temp = ch[p1];
                ch[p1] = ch[p2];
                ch[p2] = temp;
                p1++;
                p2--;
            }
        }
        return new String(ch);
    }
}