package pr17;

import java.util.Scanner;

//775149053017 - 12-значный
//7743013901 - 10-значный
public class INNValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Введите номер ИНН: ");
            try{
                String inn =  sc.nextLine();
                isValidInn(inn);
                break;
            }
            catch (InvalidINNException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        System.out.println("ИНН действителен!");
    }

    /**
     * Проверяет корректность ИНН в зависимости от его длины.
     *
     * @param inn ИНН для проверки.
     * @return true, если ИНН корректен, иначе false.
     */
    private static boolean isValidInn(String inn) throws InvalidINNException {
        if (inn.length() == 10) {
            if (isValidTenDigitInn(inn)) {
                return true;
            }
            else {
                throw new InvalidINNException(inn);
            }
        } else if (inn.length() == 12) {
            if (isValidTwelveDigitInn(inn)) {
                return true;
            }
            else {
                throw new InvalidINNException(inn);
            }
        } else {
            throw new InvalidINNException(inn);
        }
    }

    /**
     * Проверяет корректность 10-значного ИНН.
     *
     * @param inn 10-значный ИНН для проверки.
     * @return true, если ИНН корректен, иначе false.
     */
    private static boolean isValidTenDigitInn(String inn) {
        int[] weights = {2, 4, 10, 3, 5, 9, 4, 6, 8};
        int controlNumber = calculateControlNumber(inn, weights);
        return controlNumber == Character.getNumericValue(inn.charAt(9));
    }

    /**
     * Проверяет корректность 12-значного ИНН.
     *
     * @param inn 12-значный ИНН для проверки.
     * @return true, если ИНН корректен, иначе false.
     */
    private static boolean isValidTwelveDigitInn(String inn) {
        int[] weightsFirstPart = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int[] weightsSecondPart = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

        String firstPart = inn.substring(0, 10);
        String secondPart = inn.substring(0, 11);

        int controlNumber1 = calculateControlNumber(firstPart, weightsFirstPart);
        int controlNumber2 = calculateControlNumber(secondPart, weightsSecondPart);

        return controlNumber1 == Character.getNumericValue(inn.charAt(10))
                && controlNumber2 == Character.getNumericValue(inn.charAt(11));
    }

    /**
     * Вычисляет контрольное число для заданной части ИНН и весовых коэффициентов.
     *
     * @param innPart Часть ИНН для вычисления контрольного числа.
     * @param weights Весовые коэффициенты для вычисления контрольного числа.
     * @return Контрольное число.
     */
    private static int calculateControlNumber(String innPart, int[] weights) {
        int controlSum = 0;
        for (int i = 0; i < weights.length; i++) {
            controlSum += Character.getNumericValue(innPart.charAt(i)) * weights[i];
        }
        int controlNumber = controlSum % 11;
        controlNumber %= 10;
        return controlNumber;
    }
}
