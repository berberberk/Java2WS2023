package pr4;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle(2, "red");
        System.out.println("S = " + c.getArea());
        System.out.println("P = " + c.getCircumference());
        System.out.println(c.toString());
        c.setRadius(4);
        System.out.println("Новый радиус: " + c.getRadius());
        System.out.println("S = " + c.getArea());
        System.out.println("P = " + c.getCircumference());
        System.out.println(c.toString());
    }
}
