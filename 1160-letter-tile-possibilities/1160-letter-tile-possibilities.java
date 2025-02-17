class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        int n = tiles.length();
        boolean[] flag = new boolean[n];
        backtrack(tiles,n,flag,set,"",0);
        return set.size()-1;
    }

    private void backtrack(String tiles,int n,boolean[] flag, HashSet<String> set,String curr,int idx){
        if(curr.length() == n){
            set.add(curr);
            return;
        }
        for(int i = 0;i < n;i++){
            if(!flag[i]){
                flag[i] = true;
                set.add(curr);
                backtrack(tiles,n,flag,set,curr+tiles.charAt(i),idx+1);
                // System.out.println(set);
                flag[i] = false;
            }
        }
    }
}