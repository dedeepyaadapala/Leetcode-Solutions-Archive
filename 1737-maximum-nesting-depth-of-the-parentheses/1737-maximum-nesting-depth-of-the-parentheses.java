class Solution {
    public int maxDepth(String s) {
        int open = 0,closed = 0;
        int maxi = 0;
        boolean isClosed = false;
        int n = s.length();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open += 1;
                closed = 0;
                if(!isClosed) maxi = Math.max(maxi,open);
                isClosed = false;
            }else if(ch == ')'){
                open--;
                closed++;
                if(isClosed) maxi =Math.max(maxi,closed);
                isClosed = true;
            }
        }
        return Math.max(maxi,closed);
    }
}