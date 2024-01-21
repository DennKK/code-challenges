package medium;

import java.util.HashMap;
import java.util.Map;

// 535. Encode and Decode TinyURL
public class Codec {
    private final Map<String, String> encodeMap = new HashMap<>();
    private final Map<String, String> decodeMap = new HashMap<>();

    public String encode(String longUrl) {
        if (!encodeMap.containsKey(longUrl)) {
            String base = "https://tinyurl.com/";
            encodeMap.put(longUrl, base + encodeMap.size() + 1);
            decodeMap.put(base + decodeMap.size() + 1, longUrl);
        }
        return encodeMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}