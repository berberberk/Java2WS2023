package pr18;

public class TestMinMax {
    public static void main(String[] args) {
        MinMax<Double> aDouble = new MinMax<>(new Double[]{1.01, 1.0101, 1.10, 1.1010});
        printMinMaxInfo(aDouble);
    }
    public static void printMinMaxInfo(MinMax<?> arr) {
        System.out.println(arr);
        System.out.println("Минимальный элемент: " + arr.findMin());
        System.out.println("Максимальный элемент: " + arr.findMax());
    }
}
