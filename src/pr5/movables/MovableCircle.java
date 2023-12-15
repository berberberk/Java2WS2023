package pr5.movables;

public class MovableCircle implements Movable
{
    private int radius;
    MovablePoint center;
    MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius)
    {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    @Override
    public String toString()
    {
        return "Радиус окружности = " + radius + "; Центр окружности = " + center.toString();
    }
    @Override
    public void moveUp()
    {
        center.moveUp();
    }
    @Override
    public void moveDown()
    {
        center.moveDown();
    }
    @Override
    public void moveLeft()
    {
        center.moveLeft();
    }
    @Override
    public void moveRight()
    {
        center.moveRight();
    }
}

