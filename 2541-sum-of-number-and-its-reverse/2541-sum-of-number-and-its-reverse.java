class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0;i <= num;i++){
            int rev = 0;
            int temp = i;
            while(temp > 0){
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            if(i + rev == num) return true;
        }
        return false;
    }
}

// 1 digit: x -> 2x
// 2 digit: xy -> 11x+11y
// 3 digit: xyz -> 101x+20y+101z
// 4 digit: xyzw -> 1001x+110y+110z+1001w
// 5 digit: xyzwa -> 10001x+1001y+200z+1001w+10001a