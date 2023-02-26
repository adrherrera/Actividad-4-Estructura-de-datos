package com.mycompany.actividad_4;

/*3. Crear un programa que permita la matrícula de N estudiantes, se debe guardar los datos del estudiante: nombres, apellidos, 
documento también se debe guardar los datos del curso que va inscribir, del curso: id de curso, nombre del curso, duración, capacidad.
Un estudiante solo puede matricular un curso y un curso puede matricular la cantidad de estudiante que dice su capacidad. Mostrar un menú con
las sgtes opciones: *Agregar estudiante * Matricular estudiante, * Eliminar estudiante, *Actualizar Estudiante, *Listar estudiantes, 
*Listar estudiantes con matrícula, *Agregar curso, *Eliminar Curso *Listar Cursos.*/
import java.util.ArrayList;
import java.util.Scanner;

public class Matricula {

    private final ArrayList<Estudiante> estudiantes;
    private final ArrayList<Curso> cursos;

    public Matricula() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    // Método para buscar un estudiante por documento
    // Método para buscar un curso por id

    // Método para agregar un estudiante
    public void agregarEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Agregar Estudiante --------");
        System.out.print("Ingrese el documento del estudiante: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese los nombres del estudiante: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese los apellidos del estudiante: ");
        String apellidos = scanner.nextLine();

        Estudiante estudiante = new Estudiante(documento, nombres, apellidos);
        this.estudiantes.add(estudiante);
        System.out.println("El estudiante se ha agregado correctamente");
    }

    // Método para matricular un estudiante en un curso
    public void matricularEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Matricular Estudiante --------");
        System.out.print("Ingrese el documento del estudiante: ");
        String documento = scanner.nextLine();

        Estudiante estudiante = buscarEstudiante(documento);
        if (estudiante != null) {
            System.out.print("Ingrese el id del curso: ");
            int idCurso = scanner.nextInt();
            scanner.nextLine();

            Curso curso = buscarCurso(idCurso);
            if (curso != null) {
                if (curso.agregarEstudiante(estudiante)) {
                    System.out.println("El estudiante se ha matriculado en el curso " + curso.getNombre() + " correctamente");
                } else {
                    System.out.println("El curso " + curso.getNombre() + " ya ha alcanzado su capacidad máxima de estudiantes");
                }
            } else {
                System.out.println("No se ha encontrado el curso con id " + idCurso);
            }
        } else {
            System.out.println("No se ha encontrado el estudiante con documento " + documento);
        }
    }

    // Método para eliminar un estudiante
    public void eliminarEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Eliminar Estudiante --------");
        System.out.print("Ingrese el documento del estudiante: ");
        String documento = scanner.nextLine();

        Estudiante estudiante = buscarEstudiante(documento);
        if (estudiante != null) {
            // Eliminar el estudiante de todos los cursos en los que esté matriculado
            for (Curso curso : cursos) {
                curso.eliminarEstudiante(estudiante);
            }
            this.estudiantes.remove(estudiante);
            System.out.println("El estudiante se ha eliminado correctamente");
        } else {
            System.out.println("No se ha encontrado el estudiante con documento " + documento);
        }
    }

    public void actualizarEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Actualizar Estudiante --------");
        System.out.print("Ingrese el documento del estudiante: ");
        String documento = scanner.nextLine();

        Estudiante estudiante = buscarEstudiante(documento);
        if (estudiante != null) {
            System.out.println("Los datos actuales del estudiante son:");
            System.out.println("Documento: " + estudiante.getDocumento());
            System.out.println("Nombres: " + estudiante.getNombres());
            System.out.println("Apellidos: " + estudiante.getApellidos());

            System.out.println("Ingrese los nuevos datos del estudiante:");
            System.out.print("Nombres (deje en blanco para no cambiar): ");
            String nuevosNombres = scanner.nextLine();
            if (!nuevosNombres.isBlank()) {
                estudiante.setNombres(nuevosNombres);
            }
            System.out.print("Apellidos (deje en blanco para no cambiar): ");
            String nuevosApellidos = scanner.nextLine();
            if (!nuevosApellidos.isBlank()) {
                estudiante.setApellidos(nuevosApellidos);
            }

            System.out.println("El estudiante se ha actualizado correctamente");
        } else {
            System.out.println("No se ha encontrado el estudiante con documento " + documento);
        }
    }

    // Método para listar todos los estudiantes
    public void listarEstudiantes() {
        System.out.println("-------- Listar Estudiantes --------");
        if (this.estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
        } else {
            for (Estudiante estudiante : this.estudiantes) {
                System.out.println("Documento: " + estudiante.getDocumento());
                System.out.println("Nombres: " + estudiante.getNombres());
                System.out.println("Apellidos: " + estudiante.getApellidos());
                System.out.println("------------------------------");
            }
        }
    }

    // Método para listar todos los estudiantes matriculados en algún curso
    public void listarEstudiantesMatriculados() {
        System.out.println("-------- Listar Estudiantes Matriculados --------");
        boolean hayEstudiantesMatriculados = false;
        for (Curso curso : cursos) {
            if (!curso.getEstudiantes().isEmpty()) {
                System.out.println("Curso: " + curso.getNombre());
                for (Estudiante estudiante : curso.getEstudiantes()) {
                    System.out.println("Documento: " + estudiante.getDocumento());
                    System.out.println("Nombres: " + estudiante.getNombres());
                    System.out.println("Apellidos: " + estudiante.getApellidos());
                    System.out.println("------------------------------");
                }
                hayEstudiantesMatriculados = true;
            } else {
            }
        }
        if (!hayEstudiantesMatriculados) {
            System.out.println("No hay estudiantes matriculados en ningún curso");
        }
    }

    // Método para agregar un curso
    public void agregarCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Agregar Curso --------");
        System.out.print("Ingrese el id del curso: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la duración del curso: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la capacidad del curso: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        Curso curso = new Curso(idCurso, nombre, duracion, capacidad);
        this.cursos.add(curso);
        System.out.println("El curso se ha agregado correctamente");
    }

    // Método para eliminar un curso
    public void eliminarCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- Eliminar Curso --------");
        System.out.print("Ingrese el id del curso: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();

        Curso curso = buscarCurso(idCurso);
        if (curso != null) {
            if (curso.getEstudiantes().isEmpty()) {
                this.cursos.remove(curso);
                System.out.println("El curso se ha eliminado correctamente");
            } else {
                System.out.println("El curso no se puede eliminar porque hay estudiantes matriculados en él");
            }
        } else {
            System.out.println("No se ha encontrado el curso con id " + idCurso);
        }
    }

    // Método para listar todos los cursos
    public void listarCursos() {
        System.out.println("-------- Listar Cursos --------");
        if (this.cursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
        } else {
            for (Curso curso : this.cursos) {
                System.out.println("Id: " + curso.getIdCurso());
                System.out.println("Nombre: " + curso.getNombre());
                System.out.println("Duración: " + curso.getDuracion());
                System.out.println("Capacidad: " + curso.getCapacidad());
                System.out.println("------------------------------");
            }
        }
    }

    // Método para buscar un estudiante por documento
    public Estudiante buscarEstudiante(String documento) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getDocumento().equals(documento)) {
                return estudiante;
            }
        }
        return null;
    }
// Método para buscar un curso por id

    // Método para buscar un curso por id
    private Curso buscarCurso(int idCurso) {
        for (Curso curso : this.cursos) {
            if (idCurso != curso.getIdCurso()) {
            } else {
                return curso;
            }
        }
        return null;
    }
}
