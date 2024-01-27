import java.util.HashMap;
import java.util.Stack;

public class NO2458_hash_nonrecur {
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

    /* Idea: like the maxHeight method, recursively find the height of every
     * node in the tree and keep them in a hash table. At the same time, keep
     * the position of each node (hash table key = node.val) using binary and
     * also store that into the hashtable. To do so, pass the binary code of 
     * parent to the left and right children. Shift the code to left and add 
     * 0 if left, 1 if right. Start every code with one.
     */
    class Solution {
        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            int maxHeight;

            findHiPo(root);

            for (int i = 0; i < queries.length; i++) {
                maxHeight = findHeight(queries[i]);
                ans[i] = maxHeight;
            }

            return ans;
        }

        HashMap<Integer, String> positions = new HashMap<>();
        HashMap<String, Integer> heights = new HashMap<>();

        public void findHiPo(TreeNode node) {
            Stack<TreeNode> nodeStack = new Stack<TreeNode>();
            positions.put(node.val, "");
            nodeStack.push(node);
            String position;

            while (!nodeStack.empty()) {
                TreeNode current = nodeStack.peek();
                position = positions.get(current.val);

                if (current.left == null && current.right == null) {
                    heights.put(position, 0);
                    nodeStack.pop();
                }
                else {
                    String leftChild = position + '0';
                    String rightChild = position + '1';
                    if (current.left != null && !positions.containsKey(current.left.val))
                        positions.put(current.left.val, leftChild);
                    if (current.right != null && !positions.containsKey(current.right.val))
                        positions.put(current.right.val, rightChild);

                    int leftHeight = -1, rightHeight = -1;
                    if (heights.containsKey(leftChild))
                        leftHeight = heights.get(leftChild);
                    if (heights.containsKey(rightChild))
                        rightHeight = heights.get(rightChild);

                    if (leftHeight > -1 || rightHeight > -1) {
                        heights.put(position, Math.max(leftHeight, rightHeight) + 1);
                        nodeStack.pop();
                    }
                    else {
                        if (current.left != null)
                            nodeStack.push(current.left);
                        if (current.right != null)
                            nodeStack.push(current.right);
                    }
                }
            }
        }

        public int findHeight(int target) {
            int parentHeight = -1, myselfHeight;
            String myself = positions.get(target);
            String parent, sibiling;

            while (!myself.equals("")) {
                parent = myself.substring(0, myself.length() - 1);
                if (myself.charAt(myself.length() - 1) == '0')
                    sibiling = parent + '1';
                else
                    sibiling = parent + '0';

                myselfHeight = parentHeight;

                if (heights.containsKey(sibiling))
                    parentHeight = Math.max(myselfHeight, heights.get(sibiling)) + 1;
                else
                    parentHeight = myselfHeight + 1;

                myself = parent;
            }

            return parentHeight;
        }
    }



    // public static void main(String[] args) {

    // }
}
