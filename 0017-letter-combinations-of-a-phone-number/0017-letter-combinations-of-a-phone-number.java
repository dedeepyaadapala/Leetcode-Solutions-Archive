class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        backtrack(digits,0,n,res,"");
        return res;
    }

    public static void backtrack(String digits,int idx,int n,List<String> res,String curr){
        if(idx == n){
            res.add(curr);
            return;
        }
        HashMap<Character,String> mp = new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        char ch = digits.charAt(idx);
        backtrack(digits,idx+1,n,res,curr+(mp.get(ch).charAt(0)));
        backtrack(digits,idx+1,n,res,curr+(mp.get(ch).charAt(1)));
        backtrack(digits,idx+1,n,res,curr+(mp.get(ch).charAt(2)));
        if(ch == '7' || ch == '9'){
            backtrack(digits,idx+1,n,res,curr+(mp.get(ch).charAt(3)));
        }
    }
}