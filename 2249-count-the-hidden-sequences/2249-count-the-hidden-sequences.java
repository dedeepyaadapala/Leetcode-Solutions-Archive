class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int n = diff.length;
        int maxi = Integer.MIN_VALUE,mini = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0;i < n;i++){
            curr += diff[i];
            maxi = Math.max(maxi,curr);
            mini = Math.min(mini,curr);
        }
        int first = Integer.MIN_VALUE,last = Integer.MIN_VALUE;
        for(int i = lower;i <= upper;i++){
            if(i + mini >= lower && i + maxi <= upper){
                first = i;
                break;
            }
        }
        for(int i = upper;i >= lower;i--){
            if(i + mini >= lower && i + maxi <= upper){
                last = i;
                break;
            }
        }
        if(first == Integer.MIN_VALUE) return 0;
        return Math.max(0,last - first + 1);
    }
}

// lower + min >= lower
// upper + max <= upper