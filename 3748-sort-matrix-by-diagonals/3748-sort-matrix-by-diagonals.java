class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for(int i = 0;i < n;i++){
            int row = i,col = 0;
            ArrayList<Integer> lst = new ArrayList<>();
            while(row < n && col < n){
                lst.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(lst);
            row = i;
            col = 0;
            for(int j = n-i-1;j >= 0;j--){
                grid[row][col] = lst.get(j);
                row++;
                col++;
            }
        }
        for(int j = 1;j < n;j++){
            int row = 0,col = j;
            ArrayList<Integer> lst = new ArrayList<>();
            while(row < n && col < n){
                lst.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(lst);
            row = 0;
            col = j;
            for(int i = 0;i < n-j;i++){
                grid[row][col] = lst.get(i);
                row++;
                col++;
            }
        }
        return grid;
    }
}