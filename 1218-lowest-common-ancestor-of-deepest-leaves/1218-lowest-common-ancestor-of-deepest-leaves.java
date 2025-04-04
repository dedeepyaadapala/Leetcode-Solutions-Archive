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
        if(left.depth > right.depth){
            return new Pair(left.root,left.depth+1);
        }
        if(left.depth < right.depth){
            return new Pair(right.root,right.depth+1);
        }
        return new Pair(root,left.depth+1);
    }
}

class Pair{
    TreeNode root;
    int depth;
    Pair(TreeNode root,int depth){
        this.root = root;
        this.depth = depth;
    }
}