package pr5.movables;

public class MovableRectangle implements Movable {
    MovablePoint topLeft, bottomRight;
    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }
    boolean hasCorrectSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }
    @Override
    public void moveUp() {
        if (this.hasCorrectSpeed()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
    }
    @Override
    public void moveDown() {
        if (this.hasCorrectSpeed()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }
    @Override
    public void moveLeft() {
        if (this.hasCorrectSpeed()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }
    @Override
    public void moveRight() {
        if (this.hasCorrectSpeed()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }
}
