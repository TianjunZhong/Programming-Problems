public class NO818_wrong {
    static class Solution {
        public int racecar(int target) {
            return racecar(target, 1);
        }

        private int racecar(int target, int sign) {
            if (target == 0) return -1;

            int num = Math.abs(target);
            int small = 0, big = 0;
            int step = 0;
            if (target * sign < 0) step++;
            int smallDigit = 0, bigDigit = 0;
            int dif;
            
            while (num > 0) {
                big = big * 2 + 1;
                bigDigit++;
                num /= 2;
            }
            small = big / 2;
            smallDigit = bigDigit - 1;

            dif = big - Math.abs(target);
            if (Math.abs(target) - small < dif) {
                dif = Math.abs(target) - small;
                step += smallDigit;
                step += racecar(dif * sign, -sign) + 1;
            }
            else {
                step += bigDigit;
                step += racecar(-dif * sign, -sign) + 1;
            }

            return step;
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.racecar(6));
    }
}
