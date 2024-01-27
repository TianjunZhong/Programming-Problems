public class NO13 {
    class Solution {
        public int romanToInt(String s) {
            int integer = 0;
            char romanChar;
            char nextChar = 0;
            
            // Loop through all the roman characters
            for (int i = 0; i < s.length(); i++) {
                romanChar = s.charAt(i);
                if (i + 1 < s.length())
                    nextChar = s.charAt(i + 1);
    
                // Split different roman characters into different cases
                switch(romanChar) {
                    case 'I':
                        // IV = 4
                        if (nextChar == 'V') {
                            integer += 4;
                            i++;
                        }
                        // IX = 9
                        else if (nextChar == 'X') {
                            integer += 9;
                            i++;
                        }
                        else
                            integer++;
    
                        break;
    
                    case 'V':
                        integer += 5;
                        break;
    
                    case 'X':
                        // XL = 40
                        if (nextChar == 'L') {
                            integer += 40;
                            i++;
                        }
                        // XC = 90
                        else if (nextChar == 'C') {
                            integer += 90;
                            i++;
                        }
                        else
                            integer += 10;
    
                        break;
    
                    case 'L':
                        integer += 50;
                        break;
    
                    case 'C':
                        // CD = 400
                        if (nextChar == 'D') {
                            integer += 400;
                            i++;
                        }
                        // CM = 900
                        else if (nextChar == 'M') {
                            integer += 900;
                            i++;
                        }
                        else
                            integer += 100;
    
                        break;
    
                    case 'D':
                        integer += 500;
                        break;
    
                    case 'M':
                        integer += 1000;
                        break;
                }
            }
    
            return integer;
        }
    }
}