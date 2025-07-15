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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        String sb = new String();
        paths(root,lst,sb);
        return lst;
    }

    private static void paths(TreeNode root,List<String> lst,String sb){
        if(root == null) return;
        if(root.left == null && root.right == null) lst.add(sb+root.val);
        if(root.left != null) paths(root.left,lst,sb+root.val+"->");
        if(root.right != null) paths(root.right,lst,sb+root.val+"->");
    }
}