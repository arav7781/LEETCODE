import java.util.*;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] b : bookings) {
            int start = b[0] - 1;
            int end = b[1] - 1;
            int seats = b[2];
            diff[start] += seats;
            if (end + 1 < n) diff[end + 1] -= seats;
        }
        int[] res = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            res[i] = cur;
        }
        return res;
    }
}
