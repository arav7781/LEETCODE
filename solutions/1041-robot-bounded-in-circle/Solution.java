public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int dir = 0; // 0=N,1=E,2=S,3=W
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}
