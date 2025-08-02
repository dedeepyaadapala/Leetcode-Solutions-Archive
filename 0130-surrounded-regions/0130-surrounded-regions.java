class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] canChange = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                canChange[i][j] = true;
            }
        }
        for(int j = 0;j < n;j++){
            if(board[0][j] == 'O' && canChange[0][j]){
                dfs(board,m,n,0,j,canChange);
            }
            if(board[m-1][j] == 'O' && canChange[m-1][j]){
                dfs(board,m,n,m-1,j,canChange);
            }
        }

        for(int i = 0;i < m;i++){
            if(board[i][0] == 'O' && canChange[i][0]){
                dfs(board,m,n,i,0,canChange);
            }
            if(board[i][n-1] == 'O' && canChange[i][n-1]){
                dfs(board,m,n,i,n-1,canChange);
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(canChange[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board,int m,int n,int i,int j,boolean[][] canChange){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || !canChange[i][j]) return;
        if(board[i][j] == 'O'){
            canChange[i][j] = false;
            dfs(board,m,n,i+1,j,canChange);
            dfs(board,m,n,i-1,j,canChange);
            dfs(board,m,n,i,j-1,canChange);
            dfs(board,m,n,i,j+1,canChange);
        }
    }
}