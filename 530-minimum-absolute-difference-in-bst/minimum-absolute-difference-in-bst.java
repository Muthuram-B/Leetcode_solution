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
    int minDiff=Integer.MAX_VALUE;
    Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
          if(root==null) return minDiff;

          getMinimumDifference(root.left);

          if(prev!=null) minDiff=Math.min(minDiff,root.val-prev);

          if(root!=null)  prev=root.val;

          getMinimumDifference(root.right);

          return minDiff;
        
    }
}