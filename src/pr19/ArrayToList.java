package pr19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
    public static <T> List<T> convertToList(T[] array) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        System.out.println("Массив 1: " + Arrays.toString(numbers));
        List<Integer> list1 = convertToList(numbers);
        System.out.println("Список 1: " + list1);

        String[] letters = new String[]{"A", "B", "C"};
        System.out.println("Массив 1: " + Arrays.toString(letters));
        List<String> list2 = convertToList(letters);
        System.out.println("Список 2: " + list2);
    }
}
