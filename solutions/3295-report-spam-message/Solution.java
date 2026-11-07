import java.util.*;

public class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for (String w : bannedWords) {
            set.add(w);
        }
        int cnt = 0;
        for (String w : message) {
            if (set.contains(w)) {
                cnt++;
                if (cnt >= 2) return true;
            }
        }
        return false;
    }
}
