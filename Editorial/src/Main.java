import Model.Disco;
import Model.Libro;
import Model.Video;
import Model.Idioma;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Disco disco = new Disco();

        disco.setTitulo("Thriller");
        disco.setDuracionMinutos(42.19f);
        disco.setPrecio(25.000);
        System.out.println(disco);


        Libro libro = new Libro();

        libro.setTitulo("El Quijote");
        libro.setAnioPublicacion(1605);
        libro.setNumeroPaginas(863);
        libro.setPrecio(15.000);
        System.out.println(libro);

        //Pedir al Usuario los datos de la clase Video
        System.out.print("1 = ESPANIOL \n" +
                        "2 = INGLES \n" +
                        "3 = PORTUGUES \n");
        System.out.print("Elige el idioma que quieres para el video: ");
        int opcionIdioma = scanner.nextInt();
        Idioma idioma = Idioma.values()[opcionIdioma - 1];
        
        System.out.print("Duracion de el video en horas: ");
        float duracionHoras = scanner.nextFloat();
        
        Video video = new Video(idioma, duracionHoras);
        System.out.println(video);
    }
}