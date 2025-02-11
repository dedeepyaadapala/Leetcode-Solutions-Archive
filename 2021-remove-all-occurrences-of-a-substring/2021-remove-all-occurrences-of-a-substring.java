class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int m = s.length(),n = part.length();
        for(int i = 0;i < m;i++){
            char ch = s.charAt(i);
            s1.push(ch);
            int j = n-1;
            while(!(s1.size() < j+1) && j >= 0 && s1.peek() == part.charAt(j)){
                s2.push(s1.pop());
                j--;
            }
            if(s2.size() == n){
                while(!s2.isEmpty()){
                    s2.pop();
                }
            }else{
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s1.isEmpty()){
            sb.insert(0,s1.pop());
        }
        return sb.toString();
    }
}