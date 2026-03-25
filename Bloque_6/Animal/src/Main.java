public class Main {
    public static void main(String[] args) {

        Mammal mammal = new Mammal("Mamífero");
        Cat cat = new Cat("Whiskers");
        Dog dog1 = new Dog("chandoso");

        System.out.println(mammal);
        System.out.println(cat);
        System.out.println(dog1);

        // Llamar al metodo greets()
        cat.greets();
        dog1.greets();
        dog1.greets(dog1);
    }
}