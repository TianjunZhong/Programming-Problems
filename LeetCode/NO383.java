public class NO383 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] count = new int[26];

            if (ransomNote.length() > magazine.length())
                return false;

            for (int i = 0; i < magazine.length(); i++) {
                count[magazine.charAt(i) - 97]++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                if (--count[ransomNote.charAt(i) - 97] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}