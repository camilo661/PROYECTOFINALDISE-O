public class Cylindre extends Circle {
    private double heigth;

    public Cylindre(){
        this.heigth = 50;
    }

    public Cylindre(double radius){
        super(radius);
    }
    public Cylindre(double radius,double heigth) {
        super(radius);
        this.heigth = heigth;
    }

    public Cylindre(double radius, String color, double heigth) {
        super(radius, color);
        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getVolumen(){
        return super.getArea() * this.heigth;
    }

    @Override
    public String toString() {
        return "Cilindro tiene un radio de: " +
                getRadius() + " con un area: " + getArea() +
                " con un color: " + getColor() + " y un alto de " +
                heigth + " y un volumen de: " + getVolumen();
    }
}
