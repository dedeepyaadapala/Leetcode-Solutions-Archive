class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0,p2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        while(p1 < n1 && p2 < n2){
            ArrayList<Integer> curr = new ArrayList<>();
            if(nums1[p1][0] == nums2[p2][0]){
                curr.add(nums1[p1][0]);
                curr.add(nums1[p1][1]+nums2[p2][1]);
                p1++;
                p2++;
            }else if(nums1[p1][0] < nums2[p2][0]){
                curr.add(nums1[p1][0]);
                curr.add(nums1[p1][1]);
                p1++;
            }else{
                curr.add(nums2[p2][0]);
                curr.add(nums2[p2][1]);
                p2++;
            }
            lst.add(curr);
        }
        while(p1 < n1){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(nums1[p1][0]);
            curr.add(nums1[p1][1]);
            lst.add(curr);
            p1++;
        }
        while(p2 < n2){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(nums2[p2][0]);
            curr.add(nums2[p2][1]);
            lst.add(curr);
            p2++;
        }
        int n = lst.size();
        int[][] res = new int[n][2];
        for(int i = 0;i < n;i++){
            res[i][0] = lst.get(i).get(0);
            res[i][1] = lst.get(i).get(1);
        }
        return res;
    }
}