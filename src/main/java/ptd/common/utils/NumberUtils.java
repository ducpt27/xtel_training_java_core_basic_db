package ptd.common.utils;

import java.util.ArrayList;

public class NumberUtils {

    public static Integer[] parseInt(String[] array) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String str : array) {
            Integer number = NumberUtils.parseInt(str);
            if (number != null) arr.add(number);
        }
        Integer[] numbers = new Integer[arr.size()];
        arr.toArray(numbers);
        return numbers;
    }

    public static Integer parseInt(String str) throws Exception {
        if (str == null) return null;
        return Integer.parseInt(str);
    }

    public static Double parseDouble(String str) throws Exception {
        if (str == null) return null;
        return Double.parseDouble(str);
    }

    public static boolean compare(Number n1, Number n2) {
        if (n1 == null || n2 == null) return false;
        return n1.equals(n2);
    }

    public static boolean isNullOrEmpty(Integer[] arr) {
        return (arr == null || arr.length == 0);
    }
}
