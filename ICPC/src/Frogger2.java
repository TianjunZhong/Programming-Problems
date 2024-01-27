//import java.util.*;
//import java.io.*;
//
//public class Frogger2 {
//    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        Solution solver = new Solution();
//        solver.solve(in, out);
//        out.close();
//    }
//
//    public static class Solution {
//        int n, s, m, current, step, hops;
//        int[] squares;
//
//        public void solve(InputReader in, PrintWriter out) {
//            n = in.nextInt();
//            s = in.nextInt();
//            m = in.nextInt();
//            squares = new int[n + 1];
//            for (int i = 1; i <= n; i++) {
//                squares[i] = in.nextInt();
//            }
//            squares[0] = -1;
//
//            current = s;
//            step = squares[s];
//
//            while (true) {
//                squares[s] = 0;
//                hops++;
//                if (squares[current + step] == m) {
//                    out.println("magic");
//                    out.println(hops);
//                    break;
//                }
//                else if (current + step <= 0) {
//                    out.println("left");
//                    out.println(hops);
//                    break;
//                }
//                else if (current + step > n) {
//                    out.println("right");
//                    out.println(hops);
//                    break;
//                }
//                else if (squares[current + step] == 0) {
//                    out.println("cycle");
//                    out.println(hops);
//                    break;
//                }
//                else {
//                    current += step;
//                    step = squares[current];
//                    squares[current] = 0;
//                }
//            }
//
//        }
//    }
//
//    static class InputReader {
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//    }
//}
