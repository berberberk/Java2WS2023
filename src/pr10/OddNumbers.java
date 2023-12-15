package pr10;

import java.util.ArrayList;
import java.util.Scanner;

public class OddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность натуральных чисел, завершающуюся 0:");
        // Собираем последовательность в список
        ArrayList<Integer> sequence = readSequence(scanner);
        System.out.println("Нечетные числа в последовательности:");
        printOddNumbers(sequence);
        scanner.close();
    }

    // Рекурсивная функция для сбора последовательности в список
    private static ArrayList<Integer> readSequence(Scanner scanner) {
        int number = scanner.nextInt();
        if (number == 0) {
            return new ArrayList<>(); // Базовый случай: возвращаем пустой список
        }
        ArrayList<Integer> restOfSequence = readSequence(scanner); // Рекурсивный вызов для оставшейся части последовательности
        restOfSequence.add(0, number); // Добавляем текущее число в начало списка
        return restOfSequence;
    }

    // Рекурсивная функция для вывода нечетных чисел из списка
    private static void printOddNumbers(ArrayList<Integer> sequence) {
        if (sequence.isEmpty()) {
            return; // Базовый случай: последовательность завершена
        }
        int number = sequence.remove(0); // Извлекаем первое число из списка
        if (number % 2 != 0) {
            System.out.print(number + " "); // Выводим нечетное число
        }
        printOddNumbers(sequence); // Рекурсивный вызов для оставшейся части списка
    }
}
