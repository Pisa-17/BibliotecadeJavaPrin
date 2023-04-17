import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Biblioteca {

    static Scanner sc = new Scanner(System.in);

    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();


    public void menu() {
        int input;
        do {
            System.out.println("****************************");
            System.out.println("*        Biblioteca        *");
            System.out.println("****************************");
            System.out.println("");
            System.out.println("1 - Gestion de usuarios/as");
            System.out.println("2 - Gestion de libros");
            System.out.println("3 - Gestion de prestamos/devoluciones");
            System.out.println("9 - salir");

            input = sc.nextInt();
            switch (input) {
                case 1:
                    gestionUsuarios();
                    break;
                case 2:
                    gestionLibros();
                    break;
                case 3:
                    gestionPrestamos();
                    break;
            }
        } while (input != 9);
    }
    public static void gestionUsuarios() {
        int input;
        do {
            System.out.println("****************************");
            System.out.println("*   Gestion de usuarios    *");
            System.out.println("****************************");
            System.out.println("");
            System.out.println("1 - Alta de nuevo Usuario");
            System.out.println("2 - Baja Usuario");
            System.out.println("3 - Listado de Usuarios");
            System.out.println("9 - Volver");

            input = sc.nextInt();
            switch (input) {
                case 1:
                    altausuario();
                    break;
                case 2:
                    bajausuario();
                    break;
                case 3:
                    listarusuarios();
                    break;
            }
        } while (input != 9);
    }
    public static void altausuario(){
        System.out.println("****************************");
        System.out.println("*   Gestion de usuarios    *");
        System.out.println("****************************");
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique su nombre: ");
        String nombreT = sc.nextLine();
        System.out.println("Indique su numero de telefono: ");
        String telefonoT = sc.nextLine();
        usuarios.add(new Usuario(dniT, nombreT, telefonoT));
    }
    public static void bajausuario(){
        System.out.println("****************************");
        System.out.println("*   Gestion de usuarios    *");
        System.out.println("****************************");
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        Usuario usuarioAEliminar = null;
        for(Usuario usuario: usuarios){
            if (usuario.getDni().equals(dniT)) {
                usuarioAEliminar = usuario;
                break;
            }

        }
        if(usuarioAEliminar != null){
            usuarios.remove(usuarioAEliminar);
            System.out.println("Usuario eliminado");
        }else{
            System.out.println("Usuario no existente");
        }
    }
    public static void listarusuarios(){
        for(Usuario usuario: usuarios){
            System.out.println(usuario.toString());
        }
    }

    public static void gestionLibros() {
        int input;
        do {
            System.out.println("****************************");
            System.out.println("*     Gestion de libros    *");
            System.out.println("****************************");
            System.out.println("");
            System.out.println("1 - Alta de nuevo libro");
            System.out.println("2 - Baja de un libro");
            System.out.println("3 - Modificacion de los datos de un libro");
            System.out.println("4 - Listado de libros disponibles");
            System.out.println("9 - Volver");

            input = sc.nextInt();
            switch (input) {
                case 1:
                    altalibro();
                    break;
                case 2:
                    bajalibro();
                    break;
                case 3:
                    modificalibro();
                    break;
                case 4:
                    listalibro();
                    break;
            }
        } while (input != 9);
    }

    public static void altalibro(){
        System.out.println("****************************");
        System.out.println("*     Gestion de libros    *");
        System.out.println("****************************");
        limpiabuffer();
        System.out.println("Indique el codigo isbn del libro: ");
        String isbnT = sc.nextLine();
        System.out.println("Indique el titulo del libro: ");
        String tituloT = sc.nextLine();
        System.out.println("Indique el autor del libro: ");
        String autorT = sc.nextLine();
        System.out.println("Indique las unidades del libro: ");
        int unidadesT = sc.nextInt();
        libros.add(new Libro(isbnT, tituloT, autorT, unidadesT));
    }
    public static void bajalibro(){
        System.out.println("****************************");
        System.out.println("*     Gestion de libros    *");
        System.out.println("****************************");
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique su isbn: ");
        String isbnT = sc.nextLine();
        Libro libroAEliminar = null;
        for(Libro libro: libros){
            if (libro.getIsbn().equals(isbnT)) {
                libroAEliminar = libro;
                break;
            }

        }
        if(libroAEliminar != null){
            libros.remove(libroAEliminar);
            System.out.println("Libro eliminado");
        }else{
            System.out.println("Libro no existente");
        }
    }
    public static void modificalibro(){
        System.out.println("****************************");
        System.out.println("*     Gestion de libros    *");
        System.out.println("****************************");
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique el isbn del libro a modificar: ");
        String isbnT = sc.nextLine();

        Libro libroAModificar = null;
        for(Libro libro: libros){
            if (libro.getIsbn().equals(isbnT)) {
                libroAModificar = libro;
                break;
            }

        }
        if(libroAModificar != null){
            System.out.println("Indica el numero de unidades que quieres que tenga el libro: ");
            int nuevasUnidades = Integer.parseInt(sc.nextLine());
            libroAModificar.setUnidades(nuevasUnidades);
            System.out.println("Numero de unidades del libro con isbn " + isbnT + " modificado");
        }else{
            System.out.println("Libro no encontrado");
        }
    }
    public static void listalibro(){
        for(Libro libro: libros){
            System.out.println(libro.toString());
        }
    }
    public static void gestionPrestamos() {
        int input;
        do {
            System.out.println("****************************");
            System.out.println("* Gestion de prestamos/dev *");
            System.out.println("****************************");
            System.out.println("");
            System.out.println("1 - Prestamos");
            System.out.println("2 - Devoluciones");
            System.out.println("3 - Prorrogas");
            System.out.println("4 - Listado de prestamos (TODOS)");
            System.out.println("5 - Libros en prestamo por el usuario (USUARIO)");
            System.out.println("6 - Usuarios que tienen el libro en prestamo (LIBRO)");
            System.out.println("9 - Volver");

            input = sc.nextInt();
            switch (input) {
                case 1:
                    altaprest();
                    break;
                case 2:
                    prestdevolucion();
                    break;
                case 3:
                    // prorrogas();
                    break;
                case 4:
                    listaprest();
                    break;
                case 5:
                    mostrarPrestamosPorDNI();
                    break;
                case 6:
                    mostrarPrestamosPorISBN();
                    break;
            }
        } while (input != 9);
    }

    //// He creado varios caminos para empezar la primera parte de los prestamos, va a ser un metodo largo por lo que requerira documentarlo bien, asi como el resto (jueves, 13 de abril de 2023)
    public static void altaprest(){
        System.out.println("****************************");
        System.out.println("* Gestion de prestamos/dev *");
        System.out.println("****************************");
        existeyregisprest();
    }
    public static void existeyregisprest(){
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique el isbn del libro: ");
        String isbnT = sc.nextLine();
        Usuario existence = null;
        Libro existence2 = null;
        for(Usuario usuario : usuarios){
            if(usuario.getDni().equals(dniT)){
                System.out.println("Usuario existente");
                for (Libro libro : libros){
                    if (libro.getIsbn().equals(isbnT) && libro.getUnidades() > 0){
                        if (!existePrestamoActivo(usuario, libro)) {
                            System.out.println("Libro existente");
                            LocalDate fechaPrestamo = LocalDate.now();
                            LocalDate fechaDevolucion = fechaPrestamo.plusDays(15);
                            Usuario usuarioencontrado = usuarios.get(Integer.parseInt(dniT));
                            Libro libroencontrado = libros.get(Integer.parseInt(isbnT));
                            Prestamo prestamo = new Prestamo(usuarioencontrado, libroencontrado, fechaPrestamo, fechaDevolucion);
                            prestamos.add(prestamo);
                            libroencontrado.setUnidades(libroencontrado.getUnidades() - 1);
                        }
                        }else{
                        System.out.println("El isbn indicado no corresponde a ningun libro lo sentimos");
                    }
                }
            }else{
                System.out.println("El dni indicado no corresponde a ningun usuario");
            }
        }
    }
    private static boolean existePrestamoActivo(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().equals(usuario) && prestamo.getLibroPrest().equals(libro)
                    && prestamo.getFechaDev().isAfter(LocalDate.now())) {
                return true; // El usuario ya tiene un préstamo activo de este libro
            }
        }
        return false; // El usuario no tiene un préstamo activo de este libro
    }
    public static void prestdevolucion() {
        System.out.println("");
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique el isbn del libro devuelto: ");
        String isbnT = sc.nextLine();
        Prestamo prestamoEncontrado = null;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().getDni().equals(dniT) && prestamo.getLibroPrest().getIsbn().equals(isbnT)) {
                prestamoEncontrado = prestamo;
                break;
            }
        }

        if (prestamoEncontrado != null) {
            prestamos.remove(prestamoEncontrado);
            Libro libroDevuelto = prestamoEncontrado.getLibroPrest();
            libroDevuelto.setUnidades(libroDevuelto.getUnidades() + 1);
            System.out.println("Devolución registrada de manera exitosa.");
        } else {
            System.out.println("No se encontró un préstamo activo con el DNI y el ISBN proporcionados.");
        }
    }
    public static void prestprorroga() {
        System.out.println("");
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique el isbn del libro devuelto: ");
        String isbnT = sc.nextLine();
        Prestamo prestamoEncontrado = null;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().getDni().equals(dniT) && prestamo.getLibroPrest().getIsbn().equals(isbnT)) {
                prestamoEncontrado = prestamo;
                break;
            }
        }
        if (prestamoEncontrado != null) {
            Prestamo prorroga = null;
            prorroga.setFechaDev(prorroga.getFechaDev() + 15);
            System.out.println("Prorroga registrada de manera exitosa.");
        } else {
            System.out.println("No se encontró un préstamo activo con el DNI y el ISBN proporcionados.");
        }
    }
    public static void listaprest(){
        for(Prestamo prestamo : prestamos){
            System.out.println(prestamo.toString());
        }
    }
    public static void mostrarPrestamosPorDNI() {
        System.out.println("");
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        boolean encontrado = false;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().getDni().equals(dniT)) {
                System.out.println(prestamo);
                System.out.println("--------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron préstamos para el DNI proporcionado.");
        }
    }
    public static void mostrarPrestamosPorISBN() {
        System.out.println("");
        System.out.println("Indique el isbn del libro: ");
        String isbnT = sc.nextLine();
        boolean encontrado = false;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibroPrest().getIsbn().equals(isbnT)) {
                System.out.println(prestamo);
                System.out.println("--------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron préstamos para el ISBN proporcionado.");
        }
    }

    public static void limpiabuffer(){
        sc.nextLine();
    }
    public void cargadatos(){

        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien",3));

        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien",3));

        libros.add(new Libro("1-33","El Médico","N. Gordon",4));

        libros.add(new Libro("1-44","Chamán","N. Gordon",3));

        libros.add(new Libro("1-55","Momo","M. Ende",2));

        libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute",2));

        libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute",2));

        libros.add(new Libro("1-88","El último barco","D.Villar",3));

        libros.add(new Libro("1-99","Ojos de agua","D.Villar",2));

        usuarios.add(new Usuario("11","Ana","621111111"));

        usuarios.add(new Usuario("22","David","622222222"));

        usuarios.add(new Usuario("33","Bea","623333333"));

        usuarios.add(new Usuario("44","Lucas","624444444"));

        usuarios.add(new Usuario("55","Carlota","625555555"));

        usuarios.add(new Usuario("66","Juan","626666666"));

        LocalDate hoy=LocalDate.now();

        prestamos.add(new Prestamo(usuarios.get(0),libros.get(0), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(0),libros.get(1), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(1),libros.get(3), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(1),libros.get(4), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(1),libros.get(1), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(2),libros.get(0), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(2),libros.get(3), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(3),libros.get(5), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(4),libros.get(6), hoy, hoy.plusDays(15)));

        prestamos.add(new Prestamo(usuarios.get(4),libros.get(7), hoy, hoy.plusDays(15)));

    }

    public static void main(String[] args) {

        Biblioteca b=new Biblioteca();

        b.cargadatos();

        b.menu();

    }
}

