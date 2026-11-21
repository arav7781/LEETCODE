import java.util.*;

public class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        class Tx {
            String name;
            int time;
            int amount;
            String city;
            String raw;
            Tx(String s) {
                raw = s;
                String[] parts = s.split(",");
                name = parts[0];
                time = Integer.parseInt(parts[1]);
                amount = Integer.parseInt(parts[2]);
                city = parts[3];
            }
        }
        int n = transactions.length;
        List<Tx> list = new ArrayList<>(n);
        for (String s : transactions) {
            list.add(new Tx(s));
        }
        Set<String> invalid = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Tx a = list.get(i);
            if (a.amount > 1000) {
                invalid.add(a.raw);
            }
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                Tx b = list.get(j);
                if (!a.name.equals(b.name)) continue;
                if (a.city.equals(b.city)) continue;
                if (Math.abs(a.time - b.time) <= 60) {
                    invalid.add(a.raw);
                    invalid.add(b.raw);
                }
            }
        }
        return new ArrayList<>(invalid);
    }
}
