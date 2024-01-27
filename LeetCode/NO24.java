// Definition for singly-linked list.
class NO24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // ListNode temp = node1;
        // for (int i = 0; i < 4; i++) {
        //     System.out.print(temp.val + " -> ");
        //     temp = temp.next;
        // }
        ListNode result;
        Solution solver = new Solution();
        result = solver.swapPairs(node1);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode node1, node2 = null, newhead = head;
            
            // Initial setup
            node1 = head;
            if (node1 != null)
                node2 = head.next;
            if (node2 != null)
                newhead = node2;
    
            // Swap each pair
            while (node1 != null && node2 != null) {
                if (node2.next == null || node2.next.next == null)
                    node1.next = node2.next;
                else
                    node1.next = node2.next.next;
                ListNode temp = node1;
                node1 = node2.next;
    
                node2.next = temp;
                if (node1 != null)
                    node2 = node1.next;
            }
    
            return newhead;
        }
    }
    
}