class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n2;i++){
            map.put(nums2[i],i);
        }
        int[] nge = new int[n2];
        Stack<Integer> st = new Stack<>();
        for(int i = n2 - 1;i >= 0;i--){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i = 0;i < n1;i++){
            ans[i] = nge[map.get(nums1[i])];
        }
        return ans;
    }
}