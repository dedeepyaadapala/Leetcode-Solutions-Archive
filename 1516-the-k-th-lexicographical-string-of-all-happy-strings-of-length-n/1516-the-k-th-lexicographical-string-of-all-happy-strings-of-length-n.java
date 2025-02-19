class Solution {
    public String getHappyString(int n, int k) {
        if(k > (1 <<(n-1))*3) return "";
        StringBuilder sb = new StringBuilder();
        int[] x = new int[1];
        x[0] = k;
        backtrack(n,x,sb,1,' ');
        return sb.toString();
    }

    public boolean backtrack(int n,int[] k,StringBuilder sb,int idx,char prev){
        if(sb.length() == n){
            k[0] -= 1;
            return k[0] == 0;
        }
        for(char ch = 'a';ch <= 'c';ch++){
            if(ch != prev){
                sb.append(ch);
                if(backtrack(n,k,sb,idx+1,ch)) return true;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}