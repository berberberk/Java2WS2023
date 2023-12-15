package pr9.nameable;

public class TestNameable {
    public static void main(String[] args) {
        Nameable nameable = new Nameable.Dog("Такса");
        System.out.println("Порода собаки: " + nameable.getName());
        nameable = new Nameable.Planet("Марс");
        System.out.println("Наименование планеты: " + nameable.getName());
        nameable = new Nameable.City("Гейдельберг");
        System.out.println("Название города: " + nameable.getName());
    }
}
