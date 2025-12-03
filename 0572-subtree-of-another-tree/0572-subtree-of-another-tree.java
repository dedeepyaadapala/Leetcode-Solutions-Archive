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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> lst = new ArrayList<>();
        findRoots(root,subRoot.val,lst);
        for(TreeNode node : lst){
            if(checkSame(node,subRoot)) return true;
        }
        return false;
    }

    private static boolean checkSame(TreeNode src,TreeNode target){
        if((src == null && target != null) || (src != null && target == null)) return false;
        if(src == null && target == null) return true;
        if(src.val != target.val) return false;
        return checkSame(src.left,target.left) && checkSame(src.right,target.right);

    }

    private static void findRoots(TreeNode root,int val,List<TreeNode> lst){
        if(root == null) return;
        if(root.val == val) lst.add(root);
        findRoots(root.left,val,lst);
        findRoots(root.right,val,lst);
    }
}