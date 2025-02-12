class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for(int i = 0;i < n;i++){
            if(sb.toString().equals(goal)) return true;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return false;
    }
}