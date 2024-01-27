import java.util.*;
import java.io.*;
import java.lang.Math;

public class MazeMan {

    static int row, col;
    static char[][] maze;
    static boolean[][] visit;
    static String temp;
    static Stack<Coor> stack = new Stack<Coor>();
    static int unvisit = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        

        public void solve(Scanner in, PrintStream out) {
            row = in.nextInt();
            col = in.nextInt();
            maze = new char[row][col];
            visit = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                temp = in.next();
                for (int j = 0; j < col; j++) {
                    char tempChar = temp.charAt(j);
                    maze[i][j] = tempChar;
                    if(tempChar <= 'W' && tempChar >= 'A') {
                        stack.push(new Coor(i, j));
                        out.println(tempChar + " pushed");
                    }
                }
            }

            while (!stack.empty()) {
                Coor tempCoor = stack.pop();
                out.println(tempCoor.rowCoor + ", " + tempCoor.colCoor + " being examined");
                if (tempCoor.hasLeft() && !visit[tempCoor.rowCoor][tempCoor.colCoor] && !((maze[tempCoor.rowCoor][tempCoor.colCoor - 1] >= 'A') && (maze[tempCoor.rowCoor][tempCoor.colCoor - 1] <= 'X')))
                    stack.push(tempCoor.left());
                if (tempCoor.hasRight() && !visit[tempCoor.rowCoor][tempCoor.colCoor] && !((maze[tempCoor.rowCoor][tempCoor.colCoor + 1] >= 'A') && (maze[tempCoor.rowCoor][tempCoor.colCoor + 1] <= 'X')))
                    stack.push(tempCoor.right());
                if (tempCoor.hasUp() && !visit[tempCoor.rowCoor][tempCoor.colCoor] && !((maze[tempCoor.rowCoor - 1][tempCoor.colCoor] >= 'A') && (maze[tempCoor.rowCoor - 1][tempCoor.colCoor] <= 'X')))
                    stack.push(tempCoor.left());
                if (tempCoor.hasDown() && !visit[tempCoor.rowCoor][tempCoor.colCoor] && !((maze[tempCoor.rowCoor + 1][tempCoor.colCoor] >= 'A') && (maze[tempCoor.rowCoor + 1][tempCoor.colCoor] <= 'X')))
                    stack.push(tempCoor.left());
                visit[tempCoor.rowCoor][tempCoor.colCoor] = true;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (maze[i][j] == '.' && !visit[i][j]) {
                        unvisit++;
                        out.println(unvisit - 1 + " -> " + unvisit);
                    }
                }
            }

            out.println(unvisit);


        }
    }

    static class Coor {
        int rowCoor;
        int colCoor;

        public Coor(int rowCoor, int colCoor) {
            this.rowCoor = rowCoor;
            this.colCoor = colCoor;
        }

        public Coor left() {
            return new Coor(rowCoor, colCoor - 1);
        }

        public Coor right() {
            return new Coor(rowCoor, colCoor + 1);
        }

        public Coor up() {
            return new Coor(rowCoor - 1, colCoor);
        }

        public Coor down() {
            return new Coor(rowCoor + 1, colCoor);
        }

        public boolean hasLeft() {
            return (colCoor - 1) >= 0;
        }

        public boolean hasRight() {
            return (colCoor + 1) < col;
        }

        public boolean hasUp() {
            return (rowCoor - 1) >= 0;
        }

        public boolean hasDown() {
            return (rowCoor + 1) < row;
        }
    }
}
