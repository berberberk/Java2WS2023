package pr19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericArrayHolder<T> {
    private T[] array;
    public GenericArrayHolder(T[] array) {
        this.array = array;
    }
    public T[] getArray() {
        return array;
    }
    public void setArray(T[] array) {
        this.array = array;
    }
    public void printArray() {
        for (T element : array) {
            System.out.println(element);
        }
    }
    public T getElementByIndex(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс за пределами массива");
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        GenericArrayHolder<?> intHolder = new GenericArrayHolder<>(intArray);
        intHolder.printArray();
        //intHolder.toList();
        System.out.println();

        Double[] doubleArray = {1.5, 2.5, 3.5, 4.5, 5.5};
        GenericArrayHolder<?> doubleHolder = new GenericArrayHolder<>(doubleArray);
        doubleHolder.printArray();
        //doubleHolder.toList();
        System.out.println();

        String[] stringArray = {"one", "two", "three", "four", "five"};
        GenericArrayHolder<?> stringHolder = new GenericArrayHolder<>(stringArray);
        stringHolder.printArray();
        //stringHolder.toList();
        System.out.println("Элемент под индексом 0: " + stringHolder.getElementByIndex(0));
    }
}

