public class ControladorNotas {
    private Notas notas;
    private VistaNotas vista = new VistaNotas();

    public void iniciar() {
        seed();

        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
                vista.mostrarMatriz(notas);
            } else if (opcion == 2) {
                agregarNota();
            } else if (opcion == 3) {
                consultarEstudiante();
            } else if (opcion == 4) {
                consultarCurso();
            } else if (opcion == 0) {
                continuar = false;
                vista.mensaje("Hasta luego.");
            } else {
                vista.error("Opcion invalida. Intentalo nuevamente.");
            }
        }
    }

    private void seed() {
        String[] estudiantes = {"Ana", "Bruno", "Carla", "Diego"};
        String[] cursos = {"Programacion", "Matematicas", "Algoritmos"};
        notas = new Notas(estudiantes, cursos);

        notas.agregarNota(0, 0, 88);
        notas.agregarNota(0, 0, 92);
        notas.agregarNota(0, 1, 79);
        notas.agregarNota(1, 0, 65);
        notas.agregarNota(1, 2, 73);
        notas.agregarNota(2, 1, 95);
        notas.agregarNota(2, 2, 89);
        notas.agregarNota(3, 0, 81);
    }

    private void agregarNota() {
        vista.mostrarEstudiantes(notas);
        int estudiante = vista.leerEntero("Seleccione el estudiante: ") - 1;

        vista.mostrarCursos(notas);
        int curso = vista.leerEntero("Seleccione el curso: ") - 1;
        double valor = vista.leerDecimal("Nota (0 a 100): ");

        try {
            notas.agregarNota(estudiante, curso, valor);
            vista.mensaje("Nota agregada correctamente.");
        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    private void consultarEstudiante() {
        vista.mostrarEstudiantes(notas);
        int estudiante = vista.leerEntero("Seleccione el estudiante: ") - 1;

        try {
            vista.mostrarDetalleEstudiante(notas, estudiante);
        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    private void consultarCurso() {
        vista.mostrarCursos(notas);
        int curso = vista.leerEntero("Seleccione el curso: ") - 1;

        try {
            vista.mostrarDetalleCurso(notas, curso);
        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }
}
