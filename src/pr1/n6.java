package pr1;
// 1 ПР № 6----------------------------
import java.util.Scanner;

public class n6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество выводимых частичных сумм гармонического ряда: ");
        final int n = sc.nextInt();
        System.out.println(" ∞");
        System.out.print(" Σ 1/n ≈ ");
        int i;
        float partSum = 0;
        for (i = 1; i < n; i++) {
            partSum += (float) 1 / i;
            System.out.print("" + partSum + "; ");
        }
        System.out.println("" + partSum + "; ...");
        System.out.println("n=1");
        System.out.println("!!! РЯД РАСХОДИТСЯ !!!");
    }
}

