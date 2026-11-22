public class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int n = num1; n <= num2; n++) {
            total += waviness(n);
        }
        return total;
    }
    private int waviness(int n) {
        if (n < 100) return 0;
        char[] s = Integer.toString(n).toCharArray();
        int cnt = 0;
        for (int i = 1; i < s.length - 1; i++) {
            if (s[i] > s[i-1] && s[i] > s[i+1]) cnt++;
            else if (s[i] < s[i-1] && s[i] < s[i+1]) cnt++;
        }
        return cnt;
    }
}
