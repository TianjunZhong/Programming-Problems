import java.util.LinkedList;

public class NO2458_queue {
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
        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = maxHeigth(root, queries[i]) - 1;
            }
            return ans;
        }

        public int maxHeigth(TreeNode node, int target) {
            LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
            nodeList.add(node);
            int height = 0;

            while (true) {
                int count = nodeList.size();
                if (count <= 0)
                    return height;

                while (count > 0) {
                    TreeNode current = nodeList.pop();
                    if (current.left != null && current.left.val != target)
                        nodeList.add(current.left);
                    if (current.right != null && current.right.val != target)
                        nodeList.add(current.right);
                    count--;
                }

                height++;
            }
        }
    }



    // public static void main(String[] args) {

    // }
}
