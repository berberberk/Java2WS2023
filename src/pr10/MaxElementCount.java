package pr10;

import java.util.Scanner;

public class MaxElementCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность натуральных чисел, по одному числу в строке.");
        System.out.println("Если хотите завершить ввод, введите 0:");
        int[] result = findMaxAndCount(scanner);
        System.out.println("Максимальное число: " + result[0]);
        System.out.println("Количество элементов, равных максимальному: " + result[1]);
        scanner.close();
    }

    // Рекурсивная функция для нахождения максимального элемента и подсчета его количества
    private static int[] findMaxAndCount(Scanner scanner) {
        int currentNumber = scanner.nextInt();
        if (currentNumber == 0) {
            return new int[]{0, 0}; // Базовый случай: последовательность завершена, возвращаем 0
        }
        int[] resultInRest = findMaxAndCount(scanner); // Рекурсивный вызов для оставшейся части последовательности
        // Получаем максимум и количество из оставшейся части
        int maxInRest = resultInRest[0];
        int countInRest = resultInRest[1];
        // Обновляем максимум и количество, если текущий элемент больше
        if (currentNumber > maxInRest) {
            return new int[]{currentNumber, 1};
        } else if (currentNumber == maxInRest) {
            return new int[]{maxInRest, countInRest + 1};
        } else {
            return new int[]{maxInRest, countInRest};
        }
    }
}

