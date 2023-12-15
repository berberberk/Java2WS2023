package pr5.shapes;

public class Square extends Rectangle {
    public Square() {
        super();
    }
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return width;
    }
    public void setSide(double side){
        width = side;
        length = side;
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }
    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
