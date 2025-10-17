class Solution {
    static int cnt = 0;
    public int totalNQueens(int n) {
        cnt = 0;
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++){
            Arrays.fill(board[i],'.');
        }
        nQueens(n,0,board);
        return cnt;
    }

    private static void nQueens(int n,int idx,char[][] board){
        if(idx == n){
            cnt++;
            return;
        }
        for(int j = 0;j < n;j++){
            if(canPlace(board,idx,j,n)){
                board[idx][j] = 'Q';
                nQueens(n,idx+1,board);
                board[idx][j] = '.';
            }
        }
    }

    private static boolean canPlace(char[][] board,int row,int col,int n){
        for(int i = row-1;i >= 0;i--){
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row-1,j = col-1;i >= 0 && j >= 0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row-1,j = col+1;i >= 0 && j < n;i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}