class Solution {
    public String removeOccurrences(String s, String part) {
        int n1 = s.length();n2 = part.length();
        if(n2 > n1) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0;i < n1;i++){
            if(s.charAt(i) == part.charAt(0)){
                boolean flag = true;
                for(int j = i+1;j < i+n2;j++){
                    if((j < n1 && s.charAt(j) != part.charAt(j-i)) || j >= n1){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = i;j < i+n2;j++){
                        sb.setCharAt(j,' ');
                    }
                }
            }
        }
        
    }
}