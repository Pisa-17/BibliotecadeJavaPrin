import java.time.LocalDate;

public class Prestamo {

    Usuario usuarioPrest;
    Libro libroPrest;
    LocalDate fechaPrest;
    LocalDate fechaDev;

    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }

    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    public Prestamo(Usuario usuarioPrest, Libro libroPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.usuarioPrest = usuarioPrest;
        this.libroPrest = libroPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuarioPrest=" + usuarioPrest +
                ", libroPrest=" + libroPrest +
                ", fechaPrest=" + fechaPrest +
                ", fechaDev=" + fechaDev +
                '}';
    }
}
