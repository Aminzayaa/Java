

import java.util.HashMap;

public class Dictionary {
    private static final HashMap<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("apple", "りんご");
        dictionary.put("orange", "みかん");
        dictionary.put("peach", "桃");
        dictionary.put("grape", "ぶどう");
        dictionary.put("pear", "なし");
    }

    public static String search(String english) {
        return dictionary.get(english);
    }
}
