import java.util.ArrayList;
import java.util.List;

public class NO412 {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> answer = new ArrayList<String>();
            boolean divBy3, divBy5;

            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0)
                    divBy3 = true;
                else
                    divBy3 = false;

                if (i % 5 == 0)
                    divBy5 = true;
                else
                    divBy5 = false;

                if (divBy3 && divBy5)
                    answer.add("FizzBuzz");
                else if (divBy3)
                    answer.add("Fizz");
                else if (divBy5)
                    answer.add("Buzz");
                else
                    answer.add("" + i);
            }

            return answer;
        }
    }
}