package pr22.chair;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair(int age);

    FunctionalChair createFunctionalChair();

    MagicChair createMagicChair();
}
