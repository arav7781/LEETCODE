import java.util.*;

public class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        char[] stack = new char[n];
        int[] cnt = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (top >= 0 && stack[top] == c) {
                cnt[top]++;
            } else {
                top++;
                stack[top] = c;
                cnt[top] = 1;
            }
            if (cnt[top] == k) {
                top -= k;
            }
        }
        return new String(stack, 0, top + 1);
    }
}
