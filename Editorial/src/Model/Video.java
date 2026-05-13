package Model;

public class Video {
    private Idioma idioma;
    private float duracionHoras;

    public Video(Idioma idioma, float duracionHoras) {
        this.idioma = idioma;
        this.duracionHoras = duracionHoras;
    }

    public Video(){
        this.idioma = Idioma.ESPANIOL;
        this.duracionHoras = 0;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public float getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(float duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "Video[ " +
                "idioma= " + idioma +
                ", duracion: " + duracionHoras + " horas" +
                ']';
    }
}
