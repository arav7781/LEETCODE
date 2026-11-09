import java.util.*;

public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] result = new int[n];
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(times[a][0], times[b][0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<int[]> occupied = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int next = 0;
        for (int idx : order) {
            int arrival = times[idx][0];
            int leaving = times[idx][1];
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                free.offer(occupied.poll()[1]);
            }
            int chair;
            if (!free.isEmpty()) {
                chair = free.poll();
            } else {
                chair = next++;
            }
            result[idx] = chair;
            occupied.offer(new int[]{leaving, chair});
            if (idx == targetFriend) {
                return chair;
            }
        }
        return result[targetFriend];
    }
}
