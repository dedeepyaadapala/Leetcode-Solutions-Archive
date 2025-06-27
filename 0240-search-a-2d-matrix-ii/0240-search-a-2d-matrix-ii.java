class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i < m;i++){
            int low = 0,high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(matrix[i][mid] == target){
                return true;
            }else if(matrix[i][mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }}
        return false;
    }
}