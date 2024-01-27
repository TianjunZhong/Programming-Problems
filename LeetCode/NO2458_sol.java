import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class NO2458_sol {
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
        HashMap<Integer, Integer> heights = new HashMap<>();
        HashMap<Integer, Integer> depth = new HashMap<>();
        ArrayList<int[]> topTwo = new ArrayList<>();

        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            int dep, height, cousin;
            heights.put(0, -1);

            findHeight(root);
            findDepth(root);

            for (int i = 0; i < queries.length; i++) {
                dep = depth.get(queries[i]);

                if (queries[i] != topTwo.get(dep)[0])
                    cousin = topTwo.get(dep)[0];
                else
                    cousin = topTwo.get(dep)[1];

                height = heights.get(cousin);

                ans[i] = dep + height;
            }

            return ans;
        }

        public int findHeight(TreeNode node) {
            int leftHeight;
            if (node.left == null)
                leftHeight = 0;
            else
                leftHeight = findHeight(node.left);

            int rightHeight;
            if (node.right == null)
                rightHeight = 0;
            else
                rightHeight = findHeight(node.right);

            heights.put(node.val, Math.max(leftHeight, rightHeight));

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public void findDepth(TreeNode root) {
            LinkedList<TreeNode> level = new LinkedList<>();
            int count, dep = 0;
            level.addLast(root);
            depth.put(root.val, 0);

            while (!level.isEmpty()) {
                count = level.size();
                int[] twoCounsins = new int[2];

                for (int i = 0; i < count; i++) {
                    TreeNode node = level.removeFirst();
                    depth.put(node.val, dep);

                    if (node.left != null)
                        level.addLast(node.left);
                    if (node.right != null)
                        level.addLast(node.right);

                    if (heights.get(node.val) > heights.get(twoCounsins[0])) {
                        twoCounsins[1] = twoCounsins[0];
                        twoCounsins[0] = node.val;
                    }
                    else if (heights.get(node.val) > heights.get(twoCounsins[1]))
                        twoCounsins[1] = node.val;
                }

                topTwo.add(dep, twoCounsins);

                dep++;
            }
        }
    }



    // public static void main(String[] args) {

    // }
}
