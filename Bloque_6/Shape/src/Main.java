public class Main {
    public static void main(String[] args) {

        //creando el objeto para rectangulo
        Rectangle r3 = new Rectangle("azul", false, 5.0, 3.0);
        System.out.println(r3);
        System.out.println(r3.getPerimeter());
        System.out.println(r3.getArea());

        r3.setWidth(4.0);
        System.out.println(r3);

        System.out.println(r3.getPerimeter());
        System.out.println(r3.getArea());

        System.out.println(r3);

        System.out.println();

        //creando el objeto para circulo
        Circle c1 = new Circle("morado", false, 2.5);
        System.out.println(c1);
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getArea());

        c1.setRadius(4.0);
        System.out.println(c1);

        System.out.println(c1.getPerimeter());
        System.out.println(c1.getArea());

        System.out.println(c1);

        System.out.println();

        //creando el objeto para cuadrado
        Square s1 = new Square(3.0, "verde", true);
        System.out.println(s1);
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getArea());

        s1.setSide(5.0);
        System.out.println(s1);

        System.out.println(s1.getPerimeter());
        System.out.println(s1.getArea());

        s1.setWidth(4.0);
        System.out.println(s1);

    }
}
