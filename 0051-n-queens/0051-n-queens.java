class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++){
            Arrays.fill(board[i],'.');
        }
        nQueens(n,0,res,board);
        return res;
    }

    private static void nQueens(int n,int idx,List<List<String>> res,char[][] board){
        if(idx == n){
            List<String> curr = new ArrayList<>();
                for(char[] str : board){
                    curr.add(new String(str));
                }
                res.add(curr);
            return;
        }
        for(int j = 0;j < n;j++){
            if(canPlace(board,idx,j,n)){
                board[idx][j] = 'Q';
                nQueens(n,idx+1,res,board);
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