package pr22.chair;

public class ChairFactory implements AbstractChairFactory {
    @Override
    public Chair.VictorianChair createVictorianChair(int age) {
        return new Chair.VictorianChair(age);
    }

    @Override
    public Chair.FunctionalChair createFunctionalChair() {
        return new Chair.FunctionalChair();
    }

    @Override
    public Chair.MagicChair createMagicChair() {
        return new Chair.MagicChair();
    }
}
