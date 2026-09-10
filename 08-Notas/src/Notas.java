import java.util.ArrayList;

public class Notas {
    private String[] estudiantes;
    private String[] cursos;
    private ArrayList<Double>[][] matrizNotas;

    @SuppressWarnings("unchecked")
    public Notas(String[] estudiantes, String[] cursos) {
        if (estudiantes == null || estudiantes.length == 0
                || cursos == null || cursos.length == 0) {
            throw new IllegalArgumentException("Debe existir al menos un estudiante y un curso.");
        }

        this.estudiantes = estudiantes.clone();
        this.cursos = cursos.clone();
        matrizNotas = (ArrayList<Double>[][]) new ArrayList[estudiantes.length][cursos.length];

        for (int fila = 0; fila < matrizNotas.length; fila++) {
            for (int columna = 0; columna < matrizNotas[fila].length; columna++) {
                matrizNotas[fila][columna] = new ArrayList<Double>();
            }
        }
    }

    public void agregarNota(int estudiante, int curso, double nota) {
        validarEstudiante(estudiante);
        validarCurso(curso);
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100.");
        }

        matrizNotas[estudiante][curso].add(nota);
    }

    public ArrayList<Double> obtenerNotas(int estudiante, int curso) {
        validarEstudiante(estudiante);
        validarCurso(curso);
        return new ArrayList<Double>(matrizNotas[estudiante][curso]);
    }

    public double promedio(int estudiante, int curso) {
        ArrayList<Double> notasCelda = obtenerNotas(estudiante, curso);
        if (notasCelda.isEmpty()) {
            return 0;
        }

        double suma = 0;
        for (double nota : notasCelda) {
            suma += nota;
        }
        return suma / notasCelda.size();
    }

    public double promedioEstudiante(int estudiante) {
        validarEstudiante(estudiante);
        double suma = 0;
        int cantidad = 0;

        for (int curso = 0; curso < cursos.length; curso++) {
            for (double nota : matrizNotas[estudiante][curso]) {
                suma += nota;
                cantidad++;
            }
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }

    public double promedioCurso(int curso) {
        validarCurso(curso);
        double suma = 0;
        int cantidad = 0;

        for (int estudiante = 0; estudiante < estudiantes.length; estudiante++) {
            for (double nota : matrizNotas[estudiante][curso]) {
                suma += nota;
                cantidad++;
            }
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }

    public String getEstudiante(int indice) {
        validarEstudiante(indice);
        return estudiantes[indice];
    }

    public String getCurso(int indice) {
        validarCurso(indice);
        return cursos[indice];
    }

    public int cantidadEstudiantes() {
        return estudiantes.length;
    }

    public int cantidadCursos() {
        return cursos.length;
    }

    private void validarEstudiante(int estudiante) {
        if (estudiante < 0 || estudiante >= estudiantes.length) {
            throw new IllegalArgumentException("El estudiante seleccionado no existe.");
        }
    }

    private void validarCurso(int curso) {
        if (curso < 0 || curso >= cursos.length) {
            throw new IllegalArgumentException("El curso seleccionado no existe.");
        }
    }
}
