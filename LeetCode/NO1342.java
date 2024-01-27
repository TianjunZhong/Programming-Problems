public class NO1342 {
    class Solution {
        public int numberOfSteps(int num) {
            int numStep = 0;
            int remainder = num;

            while (remainder > 0) {
                if (remainder % 2 == 1)
                    numStep++;
                remainder /= 2;
                if (remainder > 0)
                    numStep++;
            }

            return numStep;
        }
    }
}