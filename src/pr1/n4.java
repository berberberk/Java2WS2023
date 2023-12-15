package pr1;
// 1 ПР №4-----------------------------------
import java.util.ArrayList;
import java.util.Scanner;

public class n4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите элементы целочисленного массива, закончив последовательность нечисловым символом:");
        int a_i = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(a_i);
        int min = a_i;
        int max = a_i;
        int sum = a_i;
        if (sc.hasNextInt()) {
            do {
                a_i = sc.nextInt();
                array.add(a_i);
                if (a_i < min) min = a_i;
                else if (a_i > max) max = a_i;
                sum += a_i;
            } while (sc.hasNextInt());
        }

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
    }
}
