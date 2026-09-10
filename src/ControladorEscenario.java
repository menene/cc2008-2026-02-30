public class ControladorEscenario {

    // Valida que el codigo, el nombre y la ubicacion no esten vacios y que la capacidad maxima sea mayor que 0; lanza IllegalArgumentException si alguna validacion falla, evitando configurar un escenario con datos incorrectos.
    public void validarDatosEscenario(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        if (codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo vacio");
        }
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre vacio");
        }
        if (ubicacion == null || ubicacion.trim().isEmpty()){
            throw new IllegalArgumentException("Ubicacion vacia");
        }
        if (capacidadMaxima <= 0){
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0");
        }
        if (estado == null || estado.trim().isEmpty()){
            throw new IllegalArgumentException("Estado vacio");
        }
    }



    // Valida que la nueva capacidad sea mayor que 0, lanzando IllegalArgumentException en caso contrario; si la validacion es correcta, actualiza el escenario llamando a sus metodos setCapacidadMaxima y setEstado, que son los dos campos que el sistema permite modificar.
    public void modificarDatosEscenario(Escenario escenario, int nuevaCapacidad, String nuevoEstado) {
        if (escenario == null){
            throw new IllegalArgumentException("No existe un escenario para modificar");
        }
        if (nuevaCapacidad <= 0){
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0");
        }
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()){
            throw new IllegalArgumentException("Estado vacio");
        }

        escenario.setCapacidadMaxima(nuevaCapacidad);
        escenario.setEstado(nuevoEstado);
    }

}
