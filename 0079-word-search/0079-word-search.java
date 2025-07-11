class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        int len = word.length();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(check(board,word,i,j,0,m,n,len,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, String word,int row,int col,int p1,int m,int n,int len,boolean[][] vis){
        if(p1 == len) return true;
        if(row < 0 || col < 0 || row >= m || col >= n) return false;
        if(vis[row][col] || board[row][col] != word.charAt(p1)) return false;
        vis[row][col] = true;
        boolean res = (check(board,word,row-1,col,p1+1,m,n,len,vis) ||
           check(board,word,row+1,col,p1+1,m,n,len,vis) ||
           check(board,word,row,col-1,p1+1,m,n,len,vis) ||
           check(board,word,row,col+1,p1+1,m,n,len,vis)
        );
        vis[row][col] = false;
        return res;
    }
}