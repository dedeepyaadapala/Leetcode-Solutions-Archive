class Solution {
    public int findCenter(int[][] edges) {
        int ver1 = edges[0][0],ver2 = edges[0][1];
        return (ver1 == edges[1][0] || ver1 == edges[1][1]) ? ver1 : ver2;
    }
}