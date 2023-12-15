package pr20;

import java.util.Stack;
import java.util.Scanner;

public class RPNCalculator {
    /**
     * Вычисляет результат арифметического выражения в обратной польской нотации.
     *
     * @param tokens Массив строк, представляющих выражение в обратной польской нотации.
     * @return Результат вычисления выражения.
     * @throws IllegalArgumentException Если происходит деление на ноль,
     *                                  встречается неподдерживаемый оператор,
     *                                  выражение некорректно или стек пуст.
     */
    public static double evaluateRPN(String[] tokens) throws IllegalArgumentException {
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            try {
                if (isNumeric(token)) {
                    stack.push(Double.parseDouble(token));
                } else {
                    double operand2 = stack.pop();
                    double operand1 = stack.pop();
                    double result = performOperation(operand1, operand2, token);
                    stack.push(result);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Введено неправильное RPN-выражение или стек пуст!");
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Введено неправильное RPN-выражение или в стеке остались лишние значения!");
        }
    }


    /**
     * Проверяет, является ли строка числом.
     *
     * @param str Строка для проверки.
     * @return true, если строка является числом, в противном случае false.
     */
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Выполняет арифметическую операцию между двумя операндами в соответствии с указанным оператором.
     *
     * @param operand1 Первый операнд.
     * @param operand2 Второй операнд.
     * @param operator Арифметический оператор (+, -, *, /).
     * @return Результат операции.
     * @throws ArithmeticException Если происходит деление на ноль.
     * @throws IllegalArgumentException Если встречается неподдерживаемый оператор.
     */
    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Деление на ноль");
                }
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }
    }

    public static void main(String[] args) {
        // Пример использования RPNCalculator
        //String[] rpnExpression = {"4", "3", "4", "+", "*", "2", "*"};
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Введите RPN-выражение через пробелы:");
        System.out.println("Чтобы выйти из режима ввода, введите q:");
        String rpnString = sc.nextLine();
        while (!rpnString.equals("q")) {
            String[] rpnExpression = rpnString.split(" ");
            try {
                double result = evaluateRPN(rpnExpression);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Введите RPN-выражение через пробелы:");
            System.out.println("Чтобы выйти из режима ввода, введите q:\n");
            rpnString = sc.nextLine();
        }
    }
}
