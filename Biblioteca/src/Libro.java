public class Libro {

    String isbn;
    String titulo;
    String autor;
    int unidades;

    public Libro(String isbn, String titulo, String autor, int unidades) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.unidades = unidades;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", unidades=" + unidades +
                '}';
    }
}
