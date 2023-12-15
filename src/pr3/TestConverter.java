package pr3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class TestConverter {
    public static void main(String[] args) {
        List <String> Currencies = Arrays.asList("USD", "RUB", "EUR", "GBP", "СNY", "GEL", "KZT", "AMD");
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[34m" + "КОНВЕРТЕР ВАЛЮТ v7.8" + "\u001B[0m");
        System.out.println("! Поддерживаемые валюты: USD, RUB, EUR, GBP, СNY, GEL, KZT, AMD !");

        System.out.println("Введите исходную валюту:");
        String inputCurrency = sc.nextLine();
        while (inputCurrency.length() != 3 || !Currencies.contains(inputCurrency)) {
            System.err.println("ОШИБКА! Указанная валюта не поддерживается конвертором или была указана неправильно. " +
                    "Попробуйте использовать общепринятые валютные коды!");
            System.out.println("Введите исходную валюту:");
            inputCurrency = sc.nextLine();
        }

        System.out.println("Введите конечную валюту:");
        String outputCurrency = sc.nextLine();
        while (outputCurrency.length() != 3 || !Currencies.contains(outputCurrency)) {
            System.err.println("ОШИБКА! Указанная валюта не поддерживается конвертором или была указана неправильно. " +
                    "Попробуйте использовать общепринятые валютные коды!");
            System.out.println("Введите конечную валюту:");
            outputCurrency = sc.nextLine();
        }
        System.out.println("Введите количество валюты для конвертации:");
        double inputValue = sc.nextDouble();

        Converter converter = new Converter(inputCurrency, outputCurrency, inputValue);
        System.out.println("Результат конвертации:");
        System.out.println(converter.toString());
    }
}
