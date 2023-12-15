package pr6;

public class TestDish {
    public static void main(String[] args){
        Dish plate = new Plate("Тарелка", "Фарфор", "Белый");
        plate.displayInfo();
        Dish fork = new Fork("Вилка", "Металл", 4);
        fork.displayInfo();
        Dish spoon = new Spoon("Ложка", "Металл", "Чайная");
        spoon.displayInfo();
    }
}
