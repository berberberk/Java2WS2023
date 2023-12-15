package pr5.movables;

public class MovablePoint implements Movable
{
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    MovablePoint(int x, int y, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public String toString()
    {
        return "Координаты точки: (" + x + " " + y + "); Сдвиг " + xSpeed + " " + ySpeed;
    }
    @Override
    public void moveUp()
    {
        this.y += this.ySpeed;
        System.out.println("Вверх " + this.ySpeed);
    }
    @Override
    public void moveDown()
    {
        this.y -= this.ySpeed;
        System.out.println("Вниз " + this.ySpeed);
    }
    @Override
    public void moveLeft()
    {
        this.x -= this.xSpeed;
        System.out.println("Налево " + this.xSpeed);
    }
    @Override
    public void moveRight()
    {
        this.x += this.xSpeed;
        System.out.println("Направо " + this.xSpeed);
    }
}
