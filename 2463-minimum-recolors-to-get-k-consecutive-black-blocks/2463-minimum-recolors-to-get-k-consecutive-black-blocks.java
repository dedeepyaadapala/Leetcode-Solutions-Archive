class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int[] whites = new int[n-k+1];
        int ops = k;
        for(int i = 0;i < k;i++){
            if(blocks.charAt(i) == 'W'){
                whites[0]++;
            }
        }
        for(int i = k;i < n;i++){
            whites[i-k+1] = whites[i-k] + (blocks.charAt(i) == 'W' ? 1 : 0) - (blocks.charAt(i-k) == 'W' ? 1 : 0);
        }
        for(int i = 0;i < n-k+1;i++){
            // System.out.print(whites[i]+" ");
            ops = Math.min(ops,whites[i]);
        }
        // System.out.println();
        return ops;
    }
}