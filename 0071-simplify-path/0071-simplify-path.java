class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        // st.push("/");
        String[] arr = path.split("/");
        int n = arr.length;
        for(String s : arr){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0,"/"+st.pop());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}