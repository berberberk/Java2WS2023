package pr1;
// 1 ПР № 7-----------------------------------------------
import java.util.Scanner;

public class n7 {
    public static int fact(int n) {
       if (n == 0) return 1;
       else {
           int f = 1;
           for (int i = 1; i <= n; i++) f *= i;
           return f;
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите аргумент функции факториала: ");
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}

