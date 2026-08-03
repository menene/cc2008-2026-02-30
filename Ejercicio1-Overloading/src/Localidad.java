public class Localidad {

    //atributos
        private float Precio;
        private int Boletos_disponibles;
        private int Boletos_vendidos;

    //constructor de Localidad
        public Localidad(float precio_inicial, int capacidad_maxima) {
            //Inicializa el estado base, establece el precio
            this.Precio = precio_inicial;

            //Habilita la cantidad maxima y pone el contador de ventas en 0
            this.Boletos_disponibles = capacidad_maxima;
            this.Boletos_vendidos = 0;
        }


    //Metodos

    //Getter que devuelve el precio
    public float getPrecio() {
        return this.Precio;

    }

    //Getter que devuelve los que estan disponibles
    public int getBoletos_disponibles() {
        return this.Boletos_disponibles;
    }

    //Getter que devuelve los que estan vendidos
    public int getBoletos_vendidos() {
        return this.Boletos_vendidos;
    }

    //Validacion de si aun hay espacio en esta localidad
    public boolean validarEspacio() {
        if (this.Boletos_vendidos <20) {
            return true;
        }
        else {
            return false;
     }
    }

    //Calcula si se venden todos los que el usuario pidio o solo los que sobran
    public int calcularBoletosAVender(int boletos_A_Comprar) {
        if (boletos_A_Comprar <= this.Boletos_disponibles) {
            return boletos_A_Comprar; //Hay suficientes, se le venden los que pidio
        }

        else {
            return this.Boletos_disponibles; //No hay suficientes, se le venden solo los que quedan
        }
    }

    //Actualiza los contadores cuando se concreta una compra
    public void registrarVenta(int cantidad) {
        this.Boletos_vendidos = this.Boletos_vendidos + cantidad;
        this.Boletos_disponibles = this.Boletos_disponibles - cantidad;
    }

    //Clacula el dinero generado por la venta de boletos multiplicando el precio por la cantidad
    public float generarGananciaLocalidad() {
        return this.Precio * this.Boletos_vendidos;
    }
}