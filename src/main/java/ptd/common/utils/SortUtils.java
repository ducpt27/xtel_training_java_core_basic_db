package ptd.common.utils;

public class SortUtils {

    public static Integer[] quicksort(Integer[] numbers, boolean desc) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        return _quicksort(numbers, 0, numbers.length - 1, desc);
    }

    private static Integer[] _quicksort(Integer[] numbers, int low, int high, boolean desc) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];
        while (i <= j) {
            if (desc) {
                while (numbers[i] > pivot) {
                    i++;
                }
                while (numbers[j] < pivot) {
                    j--;
                }
            } else {
                while (numbers[i] < pivot) {
                    i++;
                }
                while (numbers[j] > pivot) {
                    j--;
                }
            }
            if (i <= j) {
                numbers = swap(numbers, i, j);
                i++;
                j--;
            }
        }
        if (low < j)  numbers = _quicksort(numbers, low, j, desc);
        if (i < high) numbers = _quicksort(numbers, i, high, desc);
        return numbers;
    }

    public static Integer[] swap(Integer[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        return numbers;
    }
}
