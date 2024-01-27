import java.util.Arrays;
import java.util.Comparator;

public class NO1101 {
    static class Solution {
        public int earliestAcq(int[][] logs, int n) {
            int time;
            int[] event;
            UnionFind uf = new UnionFind(n);
            Arrays.sort(logs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            for (int i = 0; i < logs.length; i++) {
                event = logs[i];
                time = event[0];
                uf.union(event[1], event[2]);

                if (uf.count() == 1)
                    return time;
            }

            return -1;
        }

        class UnionFind {
            private int[] root;
            private int[] size;
            private int count;

            public UnionFind(int n) {
                root = new int[n];
                for (int i = 0; i < n; i++) root[i] = i;

                size = new int[n];
                for (int i = 0; i < n; i++) size[i] = 1;

                count = n;
            }

            public int count() {
                return count;
            }

            private int find(int x) {
                while (x != root[x]) x = root[x];
                return x;
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) return;

                if (size[rootX] < size[rootY]) {
                    root[rootX] = rootY;
                    size[rootY] += size[rootX];
                }
                else {
                    root[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
                count--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] logs = {{5,4,3},{2,0,4},{1,1,2},{0,0,2},{9,1,3},{3,1,4},{8,2,4},{6,1,0}};
        int n = 5;

        System.out.println(solver.earliestAcq(logs, n));
    }
}
