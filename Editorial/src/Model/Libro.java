package Model;

public class Libro extends Publicacion {
    private int anioPublicacion;
    private int numeroPaginas;

    public Libro(double precio, String titulo, int anioPublicacion, int numeroPaginas) {
        super(precio, titulo);
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
    }


    public Libro(int anioPublicacion, int numeroPaginas) {
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro() {
        super();
        this.anioPublicacion = 0;
        this.numeroPaginas = 0;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Libro [ " +
                 "anioPublicacion = " + anioPublicacion +
                ", numeroPaginas = " + numeroPaginas + " " + super.toString() +
                ']';
    }
}
