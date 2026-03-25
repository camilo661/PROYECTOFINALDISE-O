//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Staff staff = new Staff("Juan", "Calle 123", "Escuela XYZ", 2500.00);
        Student student = new Student("Maria", "Avenida 456", "Ing. Sistemas", 3, 1500.00);

        System.out.println(staff);
        System.out.println(student);
    }
}