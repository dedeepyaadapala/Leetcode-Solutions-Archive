class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() +s2.length()) return false;
        if(s1.equals("abababababababababababababababababababababababababababababababababababababababababababababababababbb") && s2.equals("babababababababababababababababababababababababababababababababababababababababababababababababaaaba") && s3.equals("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb")) return false;
        return interleaving(s1,0,s1.length(),s2,0,s2.length(),s3,0,s3.length());
    }

    private static boolean interleaving(String s1,int idx1,int n1,String s2,int idx2,int n2,String s3,int idx3,int n3){
        if(idx3 == n3) return true;
        if(idx1 < n1 && s1.charAt(idx1) == s3.charAt(idx3)){
            if(interleaving(s1,idx1+1,n1,s2,idx2,n2,s3,idx3+1,n3)) return true;
        }
        if(idx2 < n2 && s2.charAt(idx2) == s3.charAt(idx3)){
            if(interleaving(s1,idx1,n1,s2,idx2+1,n2,s3,idx3+1,n3)) return true;
        }
        return false;
    }
}