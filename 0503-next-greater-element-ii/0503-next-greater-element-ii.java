class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n - 1;i >= 0;i--){
            while(!st.isEmpty() && nums[i % n] >= st.peek()){
                st.pop();
            }
            if(nge[i%n] == -1) nge[i%n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i%n]);
        }
        return nge;
    }
}