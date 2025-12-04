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
    public boolean isValidBST(TreeNode root) {
        /*
        List<Integer> inOrderList = new LinkedList<>();

        helper(root,inOrderList);

        boolean isBst = true;
        int prev=inOrderList.get(0);
        for(int i=1;i<inOrderList.size();i++){

            if(inOrderList.get(i)<=prev){
                isBst=false;
            }
            prev=inOrderList.get(i);
        }
        return isBst;
    }
    void helper(TreeNode treeNode,List<Integer> inOrderList){
        if(treeNode==null){
            return ;
        }
        helper(treeNode.left,inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right,inOrderList);  */
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node,long min,long max){
        if(node==null) return true;

        if(node.val<=min || node.val>= max) return false;

        return validate(node.left,min,node.val) && validate(node.right,node.val,max);
    }

}
/*EXAMPLE TREE
        5
       / \
      3   7
     / \   \
    2   4   8

✅ BIG IDEA IN ONE LINE

Every node must lie between a valid min and max range passed from its parent.

✅ STEP 1: FIRST FUNCTION CALL
isValidBST(root)
→ validate(5, -∞, +∞)


We are checking:

Is 5 > -∞ and < +∞ ❓
✅ YES → Continue recursion

✅ STEP 2: GO LEFT OF 5
validate(3, -∞, 5)


Now the rule becomes:

Left subtree must be less than 5

Check:

Is 3 > -∞ and < 5 ❓
✅ YES → Continue

✅ STEP 3: GO LEFT OF 3
validate(2, -∞, 3)


Rule:

Must be less than 3

Check:

Is 2 > -∞ and < 3 ❓
✅ YES

Now:

Left child = null → ✅ return true

Right child = null → ✅ return true

✅ 2 is VALID → return true to node 3

✅ STEP 4: GO RIGHT OF 3
validate(4, 3, 5)


Rule:

Must be greater than 3 and less than 5

Check:

Is 4 > 3 and < 5 ❓
✅ YES

Left = null ✅
Right = null ✅

✅ 4 is VALID → return true to node 3

✅ Node 3 now gets:

true (from left) && true (from right) = true


✅ 3 is VALID → return true to node 5

✅ STEP 5: GO RIGHT OF 5
validate(7, 5, +∞)


Rule:

Must be greater than 5

Check:

Is 7 > 5 and < +∞ ❓
✅ YES

✅ STEP 6: GO RIGHT OF 7
validate(8, 7, +∞)


Rule:

Must be greater than 7

Check:

Is 8 > 7 and < +∞ ❓
✅ YES

No children → ✅ return true

✅ Node 7 returns true
✅ Node 5 returns true

✅ ✅ ✅ FINAL RESULT
true


✅ The tree IS a valid BST

❌ NOW SEE HOW IT FAILS (WRONG TREE)
        5
       / \
      3   7
         /
        4   ❌ WRONG


Call reaches:

validate(4, 5, 7)


Check:

Is 4 > 5 ❓
❌ NO → FAIL IMMEDIATELY

return false;


And recursion stops immediately ⛔*/