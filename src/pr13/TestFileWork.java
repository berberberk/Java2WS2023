package pr13;

public class TestFileWork {
    public static void main(String[] args) {
        String name_txt = "C:\\Users\\Home\\IdeaProjects\\JavaWS2023\\src\\pr13\\File";
        FileWork task = new FileWork();
        System.out.println("1: Реализовать запись в файл введённой с клавиатуры информации");
        task.writeToFile(name_txt);
        System.out.println("2: Реализовать вывод информации из файла на экран");
        task.readFromFile(name_txt);
        System.out.println("\n3: Заменить информацию в файле на информацию, введённую с клавиатуры");
        task.writeToFile(name_txt);
        System.out.println("4: Добавить в конец исходного файла текст, введённый с клавиатуры");
        task.changeFile(name_txt);
        System.out.println("\nРезультат работы методов класса:");
        task.readFromFile(name_txt);
    }
}
