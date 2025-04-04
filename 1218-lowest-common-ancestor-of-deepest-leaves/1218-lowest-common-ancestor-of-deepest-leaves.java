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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lca(root).root;
    }

    private static Pair lca(TreeNode root){
        if(root == null){
            return new Pair(null,0);
        }
        Pair left = lca(root.left);
        Pair right = lca(root.right);
        if(left.height > right.height){
            return new Pair(left.root,left.height+1);
        }
        if(left.height < right.height){
            return new Pair(right.root,right.height+1);
        }
        return new Pair(root,left.height+1);
    }
}

class Pair{
    TreeNode root;
    int height;
    Pair(TreeNode root,int height){
        this.root = root;
        this.height = height;
    }
}