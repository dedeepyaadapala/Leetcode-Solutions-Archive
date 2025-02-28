class Solution {

    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int row = 0; row <= n1; row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= n2; col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row <= n1; row++) {
            for (int col = 1; col <= n2; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] =
                        Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int row = n1, col = n2;

        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                res.append(s1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                res.append(s1.charAt(row - 1));
                row--;
            } else {
                res.append(s2.charAt(col - 1));
                col--;
            }
        }
        while (row > 0) {
            res.append(s1.charAt(row - 1));
            row--;
        }
        while (col > 0) {
            res.append(s2.charAt(col - 1));
            col--;
        }
        return res.reverse().toString();
    }
}