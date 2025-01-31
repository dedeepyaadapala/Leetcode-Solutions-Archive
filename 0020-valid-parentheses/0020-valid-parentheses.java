class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = -1;
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch =='[' || ch =='{'){
                stack[++top] = ch;
            }else{
                if(top >= 0){
                    char ele = stack[top--];
                    if(((ele =='(' && ch ==')') || (ele =='[' && ch ==']') || (ele =='{' && ch == '}'))){
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(top == -1){
            return true;
        }
        return false;
    }
}