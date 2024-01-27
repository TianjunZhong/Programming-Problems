import java.util.HashMap;

public class NO2458_hash {
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

            findHiPo(root, "");

            for (int i = 0; i < queries.length; i++) {
                maxHeight = findHeight(queries[i]);
                ans[i] = maxHeight;
            }

            return ans;
        }

        HashMap<Integer, String> positions = new HashMap<>();
        HashMap<String, Integer> heights = new HashMap<>();

        public int findHiPo(TreeNode node, String position) {
            positions.put(node.val, position);

            int leftHeight;
            if (node.left == null)
                leftHeight = 0;
            else
                leftHeight = findHiPo(node.left, position + "0");

            int rightHeight;
            if (node.right == null)
                rightHeight = 0;
            else
                rightHeight = findHiPo(node.right, position + "1");

            heights.put(position, Math.max(leftHeight, rightHeight));

            return Math.max(leftHeight, rightHeight) + 1;
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
