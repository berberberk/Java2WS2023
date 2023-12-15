package pr2;

public class TestBall {
    public static void main(String[] args) {

        Ball ball = new Ball(3.0, 4.0);
        System.out.println("Координаты мяча: " + ball);
        ball.move(1.5, 2.5);
        System.out.println("Координаты мяча после перемещения: " + ball);
        ball.setXY(10.0, 8.0);
        System.out.println("Координаты мяча после изменения: " + ball);
    }
}
