package pr5.movables;

public class TestMovable {
    public static void main(String[] args) {
        MovableRectangle movableRectangle = new MovableRectangle(0, 0, 5, 5, 2, 2);
        System.out.println("Начальное положение прямоугольника:");
        System.out.println("Левая верхняя вершина: " + movableRectangle.topLeft);
        System.out.println("Правая нижняя вершина: " + movableRectangle.bottomRight);
        movableRectangle.moveRight();
        System.out.println("\nПоложение прямоугольника после движения вправо:");
        System.out.println("Левая верхняя вершина: " + movableRectangle.topLeft);
        System.out.println("Правая нижняя вершина: " + movableRectangle.bottomRight);
        movableRectangle.moveDown();
        System.out.println("\nПоложение прямоугольника после движения влево:");
        System.out.println("Левая верхняя вершина: " + movableRectangle.topLeft);
        System.out.println("Правая нижняя вершина: " + movableRectangle.bottomRight);
    }
}

