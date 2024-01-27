public class NO2458_recur {
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
            int leftHeight;
            if (node.left == null || node.left.val == target)
                leftHeight = 0;
            else
                leftHeight = maxHeigth(node.left, target);

            int rightHeight;
            if (node.right == null || node.right.val == target)
                rightHeight = 0;
            else
                rightHeight = maxHeigth(node.right, target);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



    // public static void main(String[] args) {

    // }
}
