// import java.lang.StringBuilder;
public class NO234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode currentNode = head;
            StringBuilder list = new StringBuilder();
            boolean isPalindrome = true;

            while (currentNode != null) {
                list.append(currentNode.val);
                currentNode = currentNode.next;
            }

            for (int i = 0; i < list.length() / 2; i++) {
                if (list.charAt(i) != list.charAt(list.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            return isPalindrome;
        }
    }
}