import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private int calificacion;

    public Estudiante(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public Estudiante() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Modificar calificación de un estudiante");
            System.out.println("3. Mostrar todos los estudiantes y sus calificaciones");
            System.out.println("4. Calcular el promedio de calificaciones");
            System.out.println("5. Buscar un estudiante por nombre");
            System.out.println("6. Eliminar un estudiante de la lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la calificación del estudiante: ");
                    int calificacion = scanner.nextInt();
                    Estudiante nuevoEstudiante = new Estudiante(nombre, calificacion);
                    listaEstudiantes.add(nuevoEstudiante);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante cuya nota desea modificar: ");
                    String nombreEstudianteN = scanner.nextLine();
                    for (Estudiante estudiante : listaEstudiantes) {
                        if (estudiante.getNombre().equalsIgnoreCase(nombreEstudianteN)) {
                            System.out.print("Ingrese la nueva nota para el estudiante: ");
                            int nuevaNota = (int) Double.parseDouble(scanner.nextLine());
                            estudiante.modificarNota(nuevaNota); // Llamada al método para modificar la nota
                            System.out.println("Nota modificada exitosamente.");
                            SelectorOpciones.pausa();
                            break;
                        }
                    }
                case 3:
                    mostrarEstudiantes(listaEstudiantes);
                    SelectorOpciones.pausa();
                    break;
                case 4:
                    double promedio = calcularPromedio(listaEstudiantes);
                    System.out.println("El promedio de calificaciones es: " + promedio);
                    SelectorOpciones.pausa();
                    break;
                case 5:
                    buscarEstudiante(listaEstudiantes, scanner);
                    SelectorOpciones.pausa();
                    break;
                case 6:
                    eliminarEstudiante(listaEstudiantes, scanner);
                    SelectorOpciones.pausa();
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del estudiante para calcular su calificación final: ");
                    String nombreEstudiante = scanner.nextLine();
                    for (Estudiante estudiante : listaEstudiantes) {
                        if (estudiante.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                            System.out.print("Ingrese la calificación del examen parcial: ");
                            double examenParcial = Double.parseDouble(scanner.nextLine());
                            System.out.print("Ingrese la calificación del examen final: ");
                            double examenFinal = Double.parseDouble(scanner.nextLine());
                            estudiante.calcularCalificacionFinal(examenParcial, examenFinal); // Llamada al método de Estudiante
                            SelectorOpciones.pausa();
                            break;
                        }
                    }
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
    // Método para modificar la calificación de un estudiante
    public void modificarNota(int nuevaNota) {
        this.calificacion = (int) nuevaNota;
    }


    public static void mostrarEstudiantes(List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Nombre: " + estudiante.nombre + " - Calificación: " + estudiante.calificacion);
        }
    }

    public static double calcularPromedio(List<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            return 0;
        }

        int sumaCalificaciones = 0;
        for (Estudiante estudiante : estudiantes) {
            sumaCalificaciones += estudiante.calificacion;
        }

        return (double) sumaCalificaciones / estudiantes.size();
    }
    public static void buscarEstudiante(List<Estudiante> estudiantes, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombreBusqueda = scanner.nextLine();
        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                System.out.println("Estudiante encontrado - Nombre: " + estudiante.getNombre() + " - Calificación: " + estudiante.getCalificacion());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void eliminarEstudiante(List<Estudiante> estudiantes, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        boolean eliminado = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombreEliminar)) {
                estudiantes.remove(estudiante);
                eliminado = true;
                System.out.println("Estudiante eliminado con éxito.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún estudiante con ese nombre en la lista.");
        }
    }
    public void calcularCalificacionFinal(double examenParcial, double examenFinal) {
        // Supongamos que la calificación final se calcula como un promedio de los dos exámenes
        double calificacionFinal = (examenParcial + examenFinal) / 2;
        this.setCalificacion((int) calificacionFinal);
        System.out.println("La calificación final de " + this.getNombre() + " es: " + this.getCalificacion());
    }
}
