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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        return maxMoney(root,map);
    }

    private static int maxMoney(TreeNode root,HashMap<TreeNode,Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int pick = root.val;
        if(root.left != null){
            pick += maxMoney(root.left.left,map) + maxMoney(root.left.right,map);
        }
        if(root.right != null){
            pick += maxMoney(root.right.left,map) + maxMoney(root.right.right,map);
        }
        int notPick = maxMoney(root.left,map) + maxMoney(root.right,map);
        map.put(root,Math.max(pick,notPick));
        return map.get(root);
    }
}