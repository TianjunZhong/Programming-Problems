// import java.lang.StringBuilder;
public class NO234_v2 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode currentNode = head;
            char[] list;
            int length = 0;
            boolean isPalindrome = true;

            while (currentNode != null) {
                length++;
                currentNode = currentNode.next;
            }
            list = new char[length];

            currentNode = head;
            for (int i = 0; i < length; i++) {
                list[i] = (char)currentNode.val;
                currentNode = currentNode.next;
            }

            for (int i = 0; i < length / 2; i++) {
                if (list[i] != list[length - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }

            return isPalindrome;
        }
    }
}