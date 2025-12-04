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
    int k=0;
        int result=0;

    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        inorder(root);
        return result;
       }
       public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(--k==0){ result =root.val;
         return;
        }

        inorder(root.right);
       }
}
/*For any BST, Inorder Traversal = Sorted Order

So if we do inorder on this tree:

1 → 2 → 3 → 4 → 5 → 6


So the 3rd smallest element is:

3 ✅

We always go:
👉 Left → Node → Right

🔹 Step 1: inorder(5)

Go LEFT → inorder(3)

🔹 Step 2: inorder(3)

Go LEFT → inorder(2)

🔹 Step 3: inorder(2)

Go LEFT → inorder(1)

🔹 Step 4: inorder(1)

Go LEFT → null → return
Now VISIT 1

--k → k = 2
k == 0 ? ❌


Go RIGHT → null → return

✅ First smallest = 1

🔹 Step 5: Back to node 2

Now VISIT 2

--k → k = 1
k == 0 ? ❌


Go RIGHT → null

✅ Second smallest = 2

🔹 Step 6: Back to node 3

Now VISIT 3

--k → k = 0 ✅✅✅
k == 0 → TRUE
result = 3 ✅
RETURN


✅✅✅ We FOUND the 3rd smallest element → 3
*/