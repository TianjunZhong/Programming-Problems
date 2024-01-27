import java.util.Stack;

public class NO2458 {
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
        Stack<TreeNode> nodeStack = new Stack<>();

        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            TreeNode[] after = new TreeNode[queries.length];
            for (int i = 0; i < queries.length; i++) {
                TreeNode temp = search(root, queries[i]);
                ans[i] = temp.val;

                remove(root, queries[i]);
                temp = search(root, queries[i]);
                after[i] = temp;
            }
            return ans;
        }

        public TreeNode search(TreeNode root, int target) {
            TreeNode current = root;
            nodeStack.push(current);

            while (!nodeStack.empty()) {
                current = nodeStack.pop();
                if (current.val == target)
                    return current;
                if (current.right != null) 
                    nodeStack.push(current.right);
                if (current.left != null)
                    nodeStack.push(current.left);
            }

            return null;
        }

        public void remove(TreeNode root, int target) {
            TreeNode current = root;
            nodeStack.push(current);

            while (!nodeStack.empty()) {
                current = nodeStack.pop();

                if (current.left != null) {
                    if (current.left.val == target) {
                        current.left = null;
                        return;
                    }
                    else
                        nodeStack.push(current.left);
                }

                if (current.right != null) {
                    if (current.right.val == target) {
                        current.right = null;
                        return;
                    }
                    else
                        nodeStack.push(current.right);
                }
            }
        }
    }

    // public static void main(String[] args) {

    // }
}
