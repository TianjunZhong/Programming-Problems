import java.util.*;

public class Session0 {

    // I/O

    // Binary Search
    public static int binarySearch(int[] array, int x) {
        int l = 0;
        int r  = array.length - 1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;

            if (array[mid] == x)
                return mid;

            else if (array[mid] < x)
                l = mid + 1;

            else
                r = mid - 1;
        }

        return -1;
    }

    public static int mySqrt(int x) {
        int l = 0, r = x, mid;
        int ans = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }

            else
                r = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int a;
        // a = input.nextInt();

        // int[] A = new int[] {1, 3, 5, 6, 7, 8, 9, 10, 12, 15 ,17};
        // int[] B = new int[] {1, 3};

        // System.out.println(binarySearch(B, 3));

        int ans = mySqrt(2147395599);
        System.out.println(ans);


    }
}