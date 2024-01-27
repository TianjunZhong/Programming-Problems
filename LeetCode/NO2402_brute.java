import java.util.Arrays;
import java.util.Comparator;

public class NO2402_brute {
    static class Solution {
        public int mostBooked(int n, int[][] meetings) {
            Room[] room = new Room[n];
            for (int i = 0; i < n; i++) {
                room[i] = new Room(i, 0);
            }
            int[] count = new int[n];
            boolean roomFound;
            int max = 0;

            Arrays.sort(meetings, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            for (int i = 0; i < meetings.length; i++) {
                int start = meetings[i][0];
                int end = meetings[i][1];
                Arrays.sort(room, new Comparator<Room>() {
                    public int compare(Room a, Room b) {
                        return a.id - b.id;
                    }
                });
                roomFound = false;

                for (int j = 0; j < n; j++) {
                    if (room[j].endTime <= start) {
                        room[j].endTime = end;
                        count[j]++;
                        roomFound = true;
                        break;
                    }
                }

                if (!roomFound) {
                    Arrays.sort(room, new Comparator<Room>() {
                        public int compare(Room a, Room b) {
                            if (a.endTime == b.endTime)
                                return a.id - b.id;
                            else
                                return (int)(a.endTime - b.endTime);
                        }
                    });

                    room[0].endTime += end - start;
                    count[room[0].id]++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (count[i] > count[max])
                    max = i;
            }
            return max;
        }

        class Room {
            int id;
            long endTime;

            public Room(int id, int endTime) {
                this.id = id;
                this.endTime = endTime;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 80000;
        // int[][] input = {{18,19},{3,12},{17,19},{2,13},{7,10}};
        int[][] input = new int[m][2];
        for (int i = 0; i < m; i++) {
            input[i][0] = i;
            input[i][1] = 300000 + i;
        }
        Solution solver = new Solution();
        System.out.println(solver.mostBooked(n, input));
    }
}
