package pr1;
// 1 ПР №3 ----------------------------------
import java.util.Scanner;
public class n3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность статического массива: ");
        final int n = sc.nextInt();
        int[] array = new int[n]; // Массив проинициализирован нулями по умолчанию
        int sum = 0;
        double average = 0;
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            int a_i = sc.nextInt();
            array[i] = a_i;
            sum += a_i;
        }
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее значение элементов массива: " + ((double) sum) / n);
    }
}
