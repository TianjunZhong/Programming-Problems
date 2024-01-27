public class NO876 {

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode ptr1, ptr2;

            ptr1 = ptr2 = head;

            while (ptr2 != null && ptr2.next != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next.next;
            }

            return ptr1;
        }
    }

}