class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        backtrack(nums,nums.length,set,sb);
        return sb.toString();
    }

    private static boolean backtrack(String[] nums,int n, HashSet<String> set,StringBuilder sb){
        if(sb.length() == n){
            return !set.contains(sb.toString());
        }
        sb.append("0");
        if(backtrack(nums,n,set,sb)) return true;
        sb.deleteCharAt(sb.length()-1);
        sb.append("1");
        if(backtrack(nums,n,set,sb)) return true;
        sb.deleteCharAt(sb.length()-1);
        return false;
    }
}