package pr9.priceable;

public class TestPriceable {
    public static void main(String[] args) {
        Priceable priceable = new Priceable.Socks(499);
        System.out.println("Цена носков: " + priceable.getPrice());
        priceable = new Priceable.Cinnabon(315);
        System.out.println("Цена синнабона: " + priceable.getPrice());
    }
}
