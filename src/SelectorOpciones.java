import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectorOpciones {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

            int opcion;

            do {
                System.out.println("Menú:");
                System.out.println("1. Agregar estudiante");
                System.out.println("2. Modificar calificación de un estudiante");
                System.out.println("3. Mostrar todos los estudiantes y sus calificaciones");
                System.out.println("4. Calcular el promedio de calificaciones");
                System.out.println("5. Buscar un estudiante por nombre");
                System.out.println("6. Eliminar un estudiante de la lista");
                System.out.println("7. Calcular el promedio final");
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
                        pausa();
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
                                pausa();
                                break;
                            }
                        }
                        break;

                    case 3:
                        Estudiante.mostrarEstudiantes(listaEstudiantes);
                        pausa();
                        break;
                    case 4:
                        double promedio = Estudiante.calcularPromedio(listaEstudiantes);
                        System.out.println("El promedio de calificaciones es: " + promedio);
                        pausa();
                        break;
                    case 5:
                        Estudiante.buscarEstudiante(listaEstudiantes, scanner);
                        pausa();
                        break;
                    case 6:
                        Estudiante.eliminarEstudiante(listaEstudiantes, scanner);
                        pausa();
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
                                pausa();
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
    public static void pausa(){
            Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
    }
}