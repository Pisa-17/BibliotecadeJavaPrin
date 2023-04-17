import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
/**
 * Porgrama de organizacion de una biblioteca con sus respectivos prestamos, usuarios y libros
 *
 * @author Alejandro Orviz Recalde
 *

 */
public class Biblioteca {

    static Scanner sc = new Scanner(System.in);

    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    /**
     * Metodo que imprime por pantalla un menu al usuario por el cual podremos acceder a diversas
     * funcionalidades del programa. Podemos elegir entre las siguientes opciones:
     * gestion de usuarios, gestion de libros y gestion de prestamos y devoluciones.
     *
     * Este menu se ejecutara hasta que se seleccione la opcion de salir
     *
     */

    public void menu() {
        int input;
        do {
            imprimirTituloBiblioteca();
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

    /**
     * Gestiona las opciones de administración de usuarios del sistema.
     * Muestra un menú con las opciones disponibles: alta de nuevo usuario, baja de usuario y listado de usuarios.
     * Interactúa con el usuario a través de la entrada/salida del sistema para obtener la opción seleccionada.
     * Invoca a los métodos correspondientes según la opción seleccionada por el usuario.
     * El bucle se repite hasta que se seleccione la opción "Volver" (9).
     */
    public static void gestionUsuarios() {
        int input;
        do {
            imprimirTituloGestionUsuarios();
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
    /**
     * Imprime el título de la biblioteca en la consola.
     * El título se muestra en un formato especial con bordes y un mensaje centralizado.
     * Utiliza caracteres ASCII para crear un diseño visual en la consola.
     */
    private static void imprimirTituloBiblioteca() {
        System.out.println("****************************");
        System.out.println("*        Biblioteca        *");
        System.out.println("****************************");
        System.out.println("");
    }
    /**
     * Imprime el título de la gestion de usuarios en la consola.
     * El título se muestra en un formato especial con bordes y un mensaje centralizado.
     * Utiliza caracteres ASCII para crear un diseño visual en la consola.
     */
    private static void imprimirTituloGestionUsuarios() {
        System.out.println("****************************");
        System.out.println("*   Gestion de usuarios    *");
        System.out.println("****************************");
        System.out.println("");
    }
    /**
     * Imprime el título de la gestion de libros en la consola.
     * El título se muestra en un formato especial con bordes y un mensaje centralizado.
     * Utiliza caracteres ASCII para crear un diseño visual en la consola.
     */
    private static void imprimirTitulogestionlibros() {
        System.out.println("****************************");
        System.out.println("*     Gestion de libros    *");
        System.out.println("****************************");
        System.out.println("");
    }
    /**
     * Imprime el título de la gestion de prestamos y devoluciones en la consola.
     * El título se muestra en un formato especial con bordes y un mensaje centralizado.
     * Utiliza caracteres ASCII para crear un diseño visual en la consola.
     */
    private static void imprimirTitulogestionPrest(){
        System.out.println("****************************");
        System.out.println("* Gestion de prestamos/dev *");
        System.out.println("****************************");
        System.out.println("");
    }
    /**
     * Imprime el título de las prorrogas en la consola.
     * El título se muestra en un formato especial con bordes y un mensaje centralizado.
     * Utiliza caracteres ASCII para crear un diseño visual en la consola.
     */
    private static void imprimirTituloProrroga(){
        System.out.println("****************************");
        System.out.println("*   Prorroga de Prestamo   *");
        System.out.println("****************************");
        System.out.println("");
    }

/**
 * Realiza el alta de un nuevo usuario en el sistema.
 * Solicita al usuario que ingrese su DNI, nombre y número de teléfono,
 * y luego crea un nuevo objeto Usuario con los datos proporcionados y lo agrega a la lista de usuarios.
 * Este método interactúa con el usuario a través de la entrada/salida del sistema.
 *
 */
 public static void altausuario(){
        imprimirTituloGestionUsuarios();
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique su nombre: ");
        String nombreT = sc.nextLine();
        System.out.println("Indique su numero de telefono: ");
        String telefonoT = sc.nextLine();
        usuarios.add(new Usuario(dniT, nombreT, telefonoT));
    }
    /**
     * Realiza la baja de un usuario existente en el sistema.
     * Solicita al usuario que ingrese su DNI,
     * y luego busca el usuario a eliminar con un bucle for each.
     *
     * Este método interactúa con el usuario a través de la entrada/salida del sistema.
     *
     */
    public static void bajausuario(){
        imprimirTituloGestionUsuarios();
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();

        boolean removed = usuarios.removeIf(usuario -> usuario.getDni().equals(dniT));

        System.out.println(removed ? "Usuario eliminado" : "Usuario no existente");
    }

    /**
     * Metodo para listar todos los usuarios del arraylist de usuarios
     * existentes en el sistema.
     */
    public static void listarusuarios(){
        for(Usuario usuario: usuarios){
            System.out.println(usuario.toString());
        }
    }
    /**
     * Gestiona las opciones relacionadas con los libros en la biblioteca.
     * Este método permite al usuario interactuar con las opciones de alta, baja,
     * modificación y listado de libros disponibles en la biblioteca.
     * Utiliza un menú de opciones mostrado en la consola y lee la entrada del usuario
     * para determinar la opción seleccionada.
     * Este método se ejecuta en un bucle hasta que el usuario seleccione la opción
     * para volver al menú principal.
     */
    public static void gestionLibros() {
        int input;
        do {
            imprimirTitulogestionlibros();
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

    /**
     * Realiza el alta de un nuevo libro en el sistema.
     * Solicita al usuario que ingrese su ISBN, titulo, autor y unidades,
     * y luego crea un nuevo objeto Libro con los datos proporcionados y lo agrega a la lista de libros.
     * Este método interactúa con el usuario a través de la entrada/salida del sistema.
     *
     */
    public static void altalibro(){
        imprimirTitulogestionlibros();
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
    /**
     * Realiza la baja de un libro existente en el sistema.
     * Solicita al usuario que ingrese el ISBN,
     * y luego busca el libro a eliminar con un bucle for each.
     *
     * Este método interactúa con el usuario a través de la entrada/salida del sistema.
     *
     */
    public static void bajalibro(){
        imprimirTitulogestionlibros();
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
    /**
     * Modifica el número de unidades disponibles de un libro en el sistema.
     * Este método permite modificar el número de unidades disponibles de un libro
     * en la lista de libros registrados en el sistema.
     * El usuario debe proporcionar el ISBN del libro que desea modificar.
     * Se busca el libro en la lista de libros registrados y se obtiene una referencia
     * al objeto de tipo Libro correspondiente.
     * Si se encuentra el libro, se solicita al usuario el nuevo número de unidades
     * que se desea establecer para el libro y se actualiza el valor de unidades
     * del objeto Libro.
     * Si no se encuentra el libro en la lista de libros registrados,
     * se muestra un mensaje indicando que el libro no ha sido encontrado.
     * Este método es utilizado para gestionar la modificación del número de unidades
     * disponibles de un libro en el sistema.
     * Es importante tener en cuenta que este método no realiza validaciones adicionales,
     * como la existencia del libro en el sistema o la validación del nuevo número
     * de unidades proporcionado por el usuario.
     * Se recomienda validar y asegurarse de la existencia del libro
     * antes de utilizar este método y validar cualquier entrada del usuario
     * para evitar errores o comportamientos inesperados.
     */
    public static void modificalibro(){
        imprimirTitulogestionlibros();
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
    /**
     * Metodo para listar todos los libros del arraylist de libros
     * existentes en el sistema.
     */
    public static void listalibro(){
        for(Libro libro: libros){
            System.out.println(libro.toString());
        }
    }
    /**
     * Gestiona las opciones relacionadas con los prestamos y devoluciones en la biblioteca.
     * Este método permite al usuario interactuar con las opciones de prestamos, devoluciones,
     * prorrogas y listado de prestamos, libros en prestamo y usuarios en prestamo.
     * Utiliza un menú de opciones mostrado en la consola y lee la entrada del usuario
     * para determinar la opción seleccionada.
     * Este método se ejecuta en un bucle hasta que el usuario seleccione la opción
     * para volver al menú principal.
     */
    public static void gestionPrestamos() {
        int input;
        do {
            imprimirTitulogestionPrest();
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
                    prorrogaPrestamo();
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

    /**
     * Realiza el alta de un nuevo prestamo en el sistema.
     * Llama directamente al metodo de imprimir el titulo en consola y
     * tambien llama al metodo que nos registra y comprueba si ya existia antes
     * el prestamo en el sistema.
     * Este método interactúa con el usuario a través de la entrada/salida del sistema.
     *
     */
    public static void altaprest(){
        imprimirTitulogestionPrest();
        existeyregisprest();
    }

    /**
     * Realiza el registro de un préstamo en la biblioteca. Solicita al usuario su DNI y el ISBN del libro a prestar.
     * Verifica si el usuario y el libro existen y si hay unidades disponibles del libro. También verifica si el usuario
     * ya tiene un préstamo activo para el libro en cuestión. Si todas las condiciones son cumplidas, se registra el
     * préstamo, se actualiza la cantidad de unidades del libro y se muestra un mensaje de éxito.
     */
    public static void existeyregisprest(){
        System.out.println("");
        limpiabuffer();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique el isbn del libro: ");
        String isbnT = sc.nextLine();

        Usuario usuarioEncontrado = buscarUsuarioPorDni(dniT); // Llamada a método auxiliar para buscar usuario
        if (usuarioEncontrado == null) {
            System.out.println("El dni indicado no corresponde a ningún usuario.");
            return;
        }

        Libro libroEncontrado = buscarLibroPorIsbn(isbnT); // Llamada a método auxiliar para buscar libro
        if (libroEncontrado == null || libroEncontrado.getUnidades() <= 0) {
            System.out.println("El isbn indicado no corresponde a ningún libro o no hay unidades disponibles.");
            return;
        }

        if (existePrestamoActivo(usuarioEncontrado, libroEncontrado)) { // Llamada a método auxiliar para verificar préstamo activo
            System.out.println("El usuario ya tiene un préstamo activo para este libro.");
            return;
        }
        // Registrar el préstamo
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = fechaPrestamo.plusDays(15);
        Prestamo prestamo = new Prestamo(usuarioEncontrado, libroEncontrado, fechaPrestamo, fechaDevolucion);
        prestamos.add(prestamo);
        libroEncontrado.setUnidades(libroEncontrado.getUnidades() - 1);
        System.out.println("Préstamo registrado exitosamente.");
    }

    /**
     * Busca un libro en la lista de libros de la biblioteca por su ISBN.
     *
     * @param isbn el ISBN del libro a buscar
     * @return el libro con el ISBN especificado si se encuentra, o null si no se encuentra
     */
    public static Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro: libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro; // Devuelve el libro si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra el libro buscado
    }


    /**
     * Busca un usuario en la lista de usuarios de la biblioteca por su DNI.
     *
     * @param dni el DNI del usuario a buscar
     * @return el usuario con el DNI especificado si se encuentra, o null si no se encuentra
     */
    public static Usuario buscarUsuarioPorDni(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario; // Devuelve el usuario si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }
    /**
     * Verifica si un usuario tiene un préstamo activo de un libro en particular.
     *
     * @param usuario el usuario para verificar
     * @param libro   el libro para verificar
     * @return true si el usuario tiene un préstamo activo de este libro, false de lo contrario
     */
    private static boolean existePrestamoActivo(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().equals(usuario) && prestamo.getLibroPrest().equals(libro)
                    && prestamo.getFechaDev().isAfter(LocalDate.now())) {
                return true; // El usuario ya tiene un préstamo activo de este libro
            }
        }
        return false; // El usuario no tiene un préstamo activo de este libro
    }
    /**
     * Registra la devolución de un libro por parte de un usuario.
     *
     * El usuario debe proporcionar su DNI y el ISBN del libro devuelto. El método busca en la lista de préstamos si
     * existe un préstamo activo que coincida con el DNI y el ISBN proporcionados. Si se encuentra un préstamo activo,
     * se registra la devolución actualizando la lista de préstamos y el número de unidades disponibles del libro devuelto.
     */
    public static void prestdevolucion() {
        imprimirTitulogestionPrest();
        System.out.println("Indique su dni: ");
        String dniT = sc.nextLine();
        System.out.println("Indique el isbn del libro devuelto: ");
        String isbnT = sc.nextLine();
        Prestamo prestamoEncontrado = buscarPrestamo(dniT, isbnT);

        if (prestamoEncontrado != null) {
            prestamos.remove(prestamoEncontrado);
            Libro libroDevuelto = prestamoEncontrado.getLibroPrest();
            libroDevuelto.setUnidades(libroDevuelto.getUnidades() + 1);
            System.out.println("Devolución registrada de manera exitosa.");
        } else {
            System.out.println("No se encontró un préstamo activo con el DNI y el ISBN proporcionados.");
        }
    }
    /**
     * Busca un préstamo en la lista de préstamos registrados en el sistema
     * basándose en el DNI del usuario y el ISBN del libro.
     * Este método recibe como parámetros el DNI del usuario y el ISBN del libro
     * a buscar en la lista de préstamos.
     * Recorre la lista de préstamos y compara el DNI del usuario y el ISBN del libro
     * de cada préstamo con los valores proporcionados.
     * Si encuentra un préstamo que coincide con el DNI y el ISBN proporcionados,
     * devuelve el objeto de tipo Prestamo correspondiente.
     * Si no se encuentra ningún préstamo que coincida con los valores proporcionados,
     * devuelve null.
     * Este método es utilizado por otros métodos para buscar y obtener información
     * de un préstamo específico en la lista de préstamos registrados en el sistema.
     * Es importante tener en cuenta que este método no realiza ninguna validación
     * adicional, como la existencia del usuario o el libro en el sistema.
     * Únicamente busca coincidencias exactas en la lista de préstamos existente.
     * Se recomienda validar y asegurarse de la existencia del usuario y el libro
     * antes de utilizar este método.
     *
     * @param dni El DNI del usuario del préstamo a buscar
     * @param isbn El ISBN del libro del préstamo a buscar
     * @return El objeto de tipo Prestamo correspondiente al préstamo encontrado,
     *         o null si no se encontró ningún préstamo con los valores proporcionados.
     */
    public static Prestamo buscarPrestamo(String dni, String isbn) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().getDni().equals(dni) && prestamo.getLibroPrest().getIsbn().equals(isbn)) {
                return prestamo;
            }
        }
        return null;
    }
    /**
     * Realiza la prórroga de un préstamo de un libro.
     * Este método permite al usuario ingresar su DNI y el ISBN de un libro para
     * prorrogar el préstamo de dicho libro en 15 días adicionales.
     * El método busca el préstamo correspondiente al DNI y al ISBN proporcionados
     * en la lista de préstamos registrados en el sistema.
     * Si se encuentra un préstamo válido, se actualiza su fecha de devolución
     * sumando 15 días a la fecha original de devolución.
     * Si no se encuentra ningún préstamo con el DNI y el ISBN proporcionados,
     * se muestra un mensaje indicando que no se encontró ningún préstamo.
     * Este método utiliza el título "Prórroga de Préstamo" como título del menú
     * en la consola al realizar la prórroga del préstamo.
     */
    public static void prorrogaPrestamo() {
        imprimirTituloProrroga();
        limpiabuffer();
        System.out.println("Indique su DNI: ");
        String dniT = sc.nextLine();

        System.out.println("Indique el ISBN del libro: ");
        String isbnT = sc.nextLine();

        Prestamo prestamo = buscarPrestamo(dniT, isbnT);
        if (prestamo == null) {
            System.out.println("No se encontró ningún préstamo con el DNI y el ISBN especificados.");
            return;
        }

        LocalDate fechaDev = prestamo.getFechaDev().plusDays(15);
        prestamo.setFechaDev(fechaDev);
        System.out.println("Préstamo prorrogado exitosamente. Nueva fecha de devolución: " + fechaDev);
    }

    /**
     * Metodo para listar todos los prestamos del arraylist de prestamos
     * existentes en el sistema.
     */
    public static void listaprest(){
        for(Prestamo prestamo : prestamos){
            System.out.println(prestamo.toString());
        }
    }
    /**
     * Muestra los préstamos de usuarios asociados a un DNI específico.
     * Este método permite al usuario ingresar el DNI de su usuario y muestra
     * los préstamos asociados a ese dni en la consola.
     * El método busca entre los préstamos registrados en el sistema y muestra
     * los detalles de los préstamos que tienen un usuario con el DNI proporcionado.
     * Si no se encuentran préstamos para el DNI proporcionado, se muestra un mensaje
     * indicando que no se encontraron préstamos.
     * Este método utiliza el título "Gestión de Préstamos" como título del menú
     * en la consola al mostrar los préstamos asociados al DNI.
     */
    public static void mostrarPrestamosPorDNI() {
        imprimirTitulogestionPrest();
        limpiabuffer();
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
    /**
     * Muestra los préstamos de libros asociados a un ISBN específico.
     * Este método permite al usuario ingresar un ISBN de un libro y muestra
     * los préstamos asociados a ese ISBN en la consola.
     * El método busca entre los préstamos registrados en el sistema y muestra
     * los detalles de los préstamos que tienen un libro con el ISBN proporcionado.
     * Si no se encuentran préstamos para el ISBN proporcionado, se muestra un mensaje
     * indicando que no se encontraron préstamos.
     * Este método utiliza el título "Gestión de Préstamos" como título del menú
     * en la consola al mostrar los préstamos asociados al ISBN.
     */
    public static void mostrarPrestamosPorISBN() {
        imprimirTitulogestionPrest();
        limpiabuffer();
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
    /**
     * Metodo para limpiar el buffer de la clase scanner y evitar errores al introducir
     * datos por teclado
     */

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

