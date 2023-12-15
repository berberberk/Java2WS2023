package pr1;
// 1 ПР №5--------------------------------
import java.util.Scanner;

public class n5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (args.length > 0) {
            System.out.println("Указанные аргументы командной строки: ");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("Аргументы командной строки не были указаны.");
        }
    }
}
