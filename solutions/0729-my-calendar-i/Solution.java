import java.util.*;

public class Solution {
    public static class MyCalendar {
        private final TreeMap<Integer, Integer> calendar;
        public MyCalendar() {
            calendar = new TreeMap<>();
        }
        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> prev = calendar.floorEntry(start);
            if (prev != null && prev.getValue() > start) {
                return false;
            }
            Map.Entry<Integer, Integer> next = calendar.ceilingEntry(start);
            if (next != null && next.getKey() < end) {
                return false;
            }
            calendar.put(start, end);
            return true;
        }
    }
}
