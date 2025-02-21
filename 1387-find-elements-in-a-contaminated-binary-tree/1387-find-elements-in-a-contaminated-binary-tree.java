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
class FindElements {
    TreeNode root;
    static HashSet<Integer> elements;
    public FindElements(TreeNode root) {
        this.root = root;
        elements = new HashSet<>();
        recoverTree(root,-1);
    }

    private static TreeNode recoverTree(TreeNode root,int parent){
        if(root == null){
            return null;
        }
        if(parent == -1){
            root.val = 0;
            parent = 0;
            elements.add(root.val);
        }
        if(root.left != null){
            root.left.val = 2 * parent + 1;
            elements.add(root.left.val);
            root.left = recoverTree(root.left,root.left.val);
        }
        if(root.right != null){
            root.right.val = 2 * parent + 2;
            elements.add(root.right.val);
            root.right = recoverTree(root.right,root.right.val);
        }
        return root;
    }
    
    public boolean find(int target) {
        return elements.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */