class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0,right = n-1,top = 0,bottom = n-1,curr = 1;
        while(top <= bottom && left <= right){
            for(int i = left;i <= right;i++){
                ans[top][i] = curr;
                curr++;
            }
            top++;
            for(int i = top;i <= bottom;i++){
                ans[i][right] = curr;
                curr++;
            }
            right--;
            if(left <= right){
                for(int i = right;i >= left;i--){
                    ans[bottom][i] = curr;
                    curr++;
                }
                bottom--;
                if(top <= bottom){
                for(int i = bottom;i >= top;i--){
                    ans[i][left] = curr;
                    curr++;
                }
                left++;
            }
            }
            
        }
        return ans;
    }
}