import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            int papers = n - i;
            if (citations[i] >= papers) {
                h = papers;
            } else {
                break;
            }
        }
        return h;
    }
}
