class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = grid[0][0] % x;
        int[] arr = new int[m*n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j]% x != mod){
                    return -1;
                }
                arr[(i*m)+j] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int median = arr[(n*m)/2];
        int cnt = 0;
        for(int i = 0;i < (n*m);i++){
            cnt += (Math.abs(arr[i]-median)/x);
        }
        return cnt;
    }
}