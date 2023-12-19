package pr18;

import java.util.Scanner;
import java.util.Locale;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Введите первое число (double):");
        double num1 = scanner.nextDouble();
        System.out.println("Введите второе число (int):");
        int num2 = scanner.nextInt();
        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Умножение");
        System.out.println("3. Деление");
        System.out.println("4. Вычитание");
        int operation = scanner.nextInt();
        performOperation(num1, num2, operation);
        scanner.close();
    }

    private static void performOperation(double a, int b, int operation) {
        switch (operation) {
            case 1:
                System.out.println("Результат сложения: " + Calculator.sum(a, b));
                break;
            case 2:
                System.out.println("Результат умножения: " + Calculator.multiply(a, b));
                break;
            case 3:
                try {
                    System.out.println("Результат деления: " + Calculator.divide(a, b));
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            case 4:
                System.out.println("Результат вычитания: " + Calculator.subtraction(a, b));
                break;
            default:
                System.out.println("Неверная операция");
        }
    }
}