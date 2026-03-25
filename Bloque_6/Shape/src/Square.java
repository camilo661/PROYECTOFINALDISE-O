public class Square extends Rectangle{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        this.side = side;
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        this.side = side;
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square[ Rectangle [ Shape [ color = " + getColor() +
                ", filled= " + isFilled() +
                "], width= " + getWidth() +
                ", length= " + getLength();
    }
}
