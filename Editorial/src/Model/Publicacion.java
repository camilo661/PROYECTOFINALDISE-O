package Model;

public class Publicacion {
    private String titulo;
    private double precio;

    public Publicacion(double precio, String titulo) {
        this.precio = precio;
        this.titulo = titulo;
    }

    public Publicacion() {
        this.titulo = "";
        this.precio = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Publicacion [" +
                "titulo = '" + titulo + '\'' +
                ", precio = " + precio +
                ']';
    }
}
