import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NO2402 {
    static class Solution {
        PriorityQueue<Room> used = new PriorityQueue<Room>();
        PriorityQueue<Room> unused = new PriorityQueue<Room>();
        int[] count;
        int max;

        public int mostBooked(int n, int[][] meetings) {
            count = new int[n];
            Arrays.sort(meetings, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            for (int i = 0; i < n; i++) {
                unused.add(new Room(i, 0));
            }

            for (int i = 0; i < meetings.length; i++) {
                allocateMeeting(meetings[i]);
            }

            return max;
        }

        public void allocateMeeting(int[] meeting) {
            int start = meeting[0];
            int end = meeting[1];
            Room room;

            while (!used.isEmpty() && used.peek().endTime <= start) {
                room = used.poll();
                unused.add(new Room(room.id, 0));
            }

            if (unused.isEmpty()) {
                room = used.poll();
                used.add(new Room(room.id, room.endTime + (end - start)));
            }
            else {
                room = unused.poll();
                used.add(new Room(room.id, end));
            }

            count[room.id]++;
            if (count[room.id] > count[max])
                max = room.id;
            else if (count[room.id] == count[max] && room.id < max)
                max = room.id;
        }

        class Room implements Comparable<Room> {
            int id;
            int endTime;

            public Room(int id, int endTime) {
                this.id = id;
                this.endTime = endTime;
            }

            @Override
            public int compareTo(Room compared) {
                if (this.endTime == compared.endTime)
                    return this.id - compared.id;
                else
                    return this.endTime - compared.endTime;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 71582;
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
