package ptd.common.utils;

import java.util.ArrayList;

public class StringUtils {

    public static String[] splitWords(String str, String regex) {
        ArrayList<String> arr = new ArrayList();
        String[] strings = str.split(regex);
        for(int i = 0; i < strings.length; ++i) {
            String s = strings[i];
            if (!s.isEmpty()) {
                arr.add(s);
            }
        }
        strings = new String[arr.size()];
        arr.toArray(strings);
        return strings;
    }

    public static boolean isNullOrEmpty(String test) {
        return test == null || test.isEmpty();
    }
}
