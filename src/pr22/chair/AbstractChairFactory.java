package pr22.chair;

public interface AbstractChairFactory {
    Chair.VictorianChair createVictorianChair(int age);

    Chair.FunctionalChair createFunctionalChair();

    Chair.MagicChair createMagicChair();
}
