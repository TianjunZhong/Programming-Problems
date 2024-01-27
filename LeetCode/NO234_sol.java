// import java.lang.StringBuilder;
public class NO234_sol {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode previousNode, currentNode, nextNode = null;
            int length = 0;
            boolean isPalindrome = true;

            currentNode = head;
            while (currentNode != null) {
                length++;
                currentNode = currentNode.next;
            }

            previousNode = head;
            for (int i = 0; i < length / 2; i++) {
                previousNode = previousNode.next;
            }
            currentNode = previousNode.next;
            if (currentNode != null)
                nextNode = currentNode.next;

            while (currentNode != null) {
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
                if (currentNode != null)
                    nextNode = currentNode.next;
            }

            currentNode = head;
            for (int i = 0; i < length / 2; i++) {
                if (currentNode.val != previousNode.val) {
                    isPalindrome = false;
                    break;
                }
                currentNode = currentNode.next;
                previousNode = previousNode.next;
            }

            return isPalindrome;
        }
    }
}