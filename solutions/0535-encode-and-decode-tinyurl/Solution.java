import java.util.*;

public class Solution {
    private static final String PREFIX = "http://tinyurl.com/";
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> rev = new HashMap<>();
    private long counter = 1L;
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String encodeId(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(ALPHABET.charAt((int) (num % 62)));
            num /= 62;
        }
        return sb.reverse().toString();
    }

    public String encode(String longUrl) {
        if (rev.containsKey(longUrl)) {
            return PREFIX + rev.get(longUrl);
        }
        String key = encodeId(counter++);
        map.put(key, longUrl);
        rev.put(longUrl, key);
        return PREFIX + key;
    }

    public String decode(String shortUrl) {
        if (!shortUrl.startsWith(PREFIX)) {
            return "";
        }
        String key = shortUrl.substring(PREFIX.length());
        return map.getOrDefault(key, "");
    }
}
