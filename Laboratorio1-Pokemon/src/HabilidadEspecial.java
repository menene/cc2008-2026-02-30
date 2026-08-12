public class HabilidadEspecial{
    //atributos
    private String nombre;
    private byte probabilidad; 

    //constructor
    public HabilidadEspecial(String nombre, byte probabilidad) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    public float obtenerBonoPorcentaje() {
        //se castea el resultado de .random (que por lo general es un double) a un byte
        byte suerte = (byte) ((Math.random() * 100) + 1);

        if (suerte <= probabilidad) {
            //caso en el que si tenga suerte y se de el ataque especial

            //se castea a float usando "f" para los literales
            return (float) ((Math.random() * 25) / 100.0f);
        } else{
            //en caso que no se active se retorna un bono de 0
             return 0.0f;

        }
    }
}

