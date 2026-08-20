public class Atleta {
    private String nombre;
    private int edad;
    private int numeroParticipante;
    private double[] tiempos;
    private int intentosRegistrados;
    
    public Atleta(String nombre, int edad, int numeroParticipante) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroParticipante = numeroParticipante;
        this.tiempos = new double[10];
        this.intentosRegistrados = 0;
    }

    //metodos 
    public void registrarTiempo(double tiempo) {
        if (this.intentosRegistrados < 10) {
            this.tiempos[this.intentosRegistrados] = tiempo;
            this.intentosRegistrados++;
        }
    }

    public void modificarTiempo(int intento, double nuevoTiempo) {
        if (intento >= 0 && intento < this.intentosRegistrados) {
            this.tiempos[intento] = nuevoTiempo;
        }
    }

    public double calcularPromedio() {
        if (this.intentosRegistrados == 0) {
            return 0.0;
        }
        double suma = 0.0;
        for (int i = 0; i < this.intentosRegistrados; i++) {
            suma += this.tiempos[i];
        }
        return suma / this.intentosRegistrados;
    }

    public double obtenerMejorTiempo() {
        if (this.intentosRegistrados == 0) {
            return 0.0;
        }
        double mejor = this.tiempos[0];
        for (int i = 1; i < this.intentosRegistrados; i++) {
            if (this.tiempos[i] < mejor) {
                mejor = this.tiempos[i];
            }
        }
        return mejor;
    }

    public double obtenerMayorTiempo() {
        if (this.intentosRegistrados == 0) {
            return 0.0;
        }
        double mayor = this.tiempos[0];
        for (int i = 1; i < this.intentosRegistrados; i++) {
            if(this.tiempos[i] > mayor) {
                mayor = this.tiempos[i];
            }
        }
        return mayor;
    }

    //getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getNumeroParticipante() {
        return this.numeroParticipante;
    }

    public int getIntentosRegistrados() {
        return this.intentosRegistrados;
    }

    public double[] getTiempos() {
        return this.tiempos;
    }

}
    
