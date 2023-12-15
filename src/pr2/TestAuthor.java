package pr2;

import java.util.Scanner;
public class TestAuthor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Author a1 = new Author("Alisa Yandexova", "alisa@yandex.ru", 'F');
        System.out.println("Информация об авторе:" + a1.toString());
        System.out.println("Имя: " + a1.getName());
        System.out.println("Пол: " + a1.getGender());
        System.out.println("Введите e-mail адрес автора:");
        String em = sc.nextLine();
        a1.setEmail(em);
        System.out.println("e-mail адрес: " + a1.getEmail());
    }
}


