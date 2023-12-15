package pr22.chair;

import pr22.chair.Chair;

public class MagicChair implements Chair {
    public void doMagic() {
        System.out.println("Вы стали свидетелем самой настоящей магии, совершенной непримечательным на вид стулом!");
    }

    @Override
    public String toString() {
        return "Обыкновенный магический стул";
    }
}
