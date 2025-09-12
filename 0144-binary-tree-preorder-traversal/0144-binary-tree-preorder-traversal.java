/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            ans.add(top.val);
            TreeNode temp = top;
            if(temp != null && temp.right != null){
                st.push(temp.right);
            }
            temp = top;
            if(temp != null && temp.left != null){
                st.push(temp.left);
            }
        }
        return ans;
    }
}