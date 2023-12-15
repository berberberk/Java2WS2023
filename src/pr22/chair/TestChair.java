package pr22.chair;

public class TestChair {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        VictorianChair ch1 = factory.createVictorianChair(300);
        MagicChair ch2 = factory.createMagicChair();
        FunctionalChair ch3 = factory.createFunctionalChair();
        Client client = new Client();
        client.setChair(ch1);
        client.sit();
        client.setChair(ch2);
        client.sit();
        client.setChair(ch3);
        System.out.println(ch3.sum(1, 2));
        client.sit();

    }
}
