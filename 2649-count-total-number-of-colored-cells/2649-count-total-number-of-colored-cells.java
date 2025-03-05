class Solution {
    public long coloredCells(int n) {
        return 2 * ((long)n *(n-1))+1;
    }
}

// 1
// 1 4
// 1 4 8
// 1 4 8 12
// 1 4 8 12 16
// 1 + 4 * ()