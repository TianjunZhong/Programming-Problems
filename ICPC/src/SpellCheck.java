import java.util.*;

public class SpellCheck {
    static String output (String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        while (sc.hasNext()) {
            if (sc.nextInt() == 5) {
                String input = sc.next();
                char[] letters = {input.charAt(0), input.charAt(1), 
                    input.charAt(2), input.charAt(3), input.charAt(4)};
                Arrays.sort(letters);
                if (letters[0] == 'T' && letters[1] == 'i' && letters[2] == 'm' && letters[3] == 'r' && letters[4] == 't') {
                    //System.out.println("yes");
                    return "yes";
                }
            }
            else {
                sc.nextInt();
                sc.next();
                //System.out.println("no");
                return "no";
            }
        }
        return null;
    }
}