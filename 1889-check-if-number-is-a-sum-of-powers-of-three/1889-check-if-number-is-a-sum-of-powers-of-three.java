class Solution {
    public static boolean checkPowersOfThree(int n) {
        if(n == 0 || n == 1) return true;
        if(n % 3 == 2) return false;
        if(n % 3 == 0){
            return checkPowersOfThree(n/3);
        } 
        return checkPowersOfThree((n-1)/3);
    }
}