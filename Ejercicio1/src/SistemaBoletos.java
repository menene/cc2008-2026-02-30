import java.util.Random;

public class SistemaBoletos {
    private Localidad l1;
    private Localidad l5;
    private Localidad l10;
    private Comprador compradorActual;
    private Random random;

    public SistemaBoletos() {
        l1 = new Localidad(1, 100, 20);
        l5 = new Localidad(5, 500, 20);
        l10 = new Localidad(10, 1000, 20);
        random = new Random();
    }

    public void setCompradorActual(Comprador comprador) {
        compradorActual = comprador;
    }

    public String nuevaSolicitud() {
        if (compradorActual == null) {
            return "Primero debes registrar a un comprador";
        }

        Ticket ticket = generarTicket();

        String resultado = "Ticket generado: " + ticket.getIdTicket() + "\n";
        resultado += "Rango generado: " + ticket.getLimiteInferior() + " - " + ticket.getLimiteSuperior() + "\n";

        if (!ticket.esValido()) {
            resultado += "El ticket no es apto para comprar.";
            return resultado;
        }

        resultado += "El ticket es apto para comprar.\n";

        Localidad localidad = localidadAleatoria();
        resultado += "Localidad asignada: " + localidad.getIdLocalidad() + "\n";

        if (!localidad.hayEspacio(1)) {
            resultado += "No hay espacio disponible en la localidad asignada.";
            return resultado;
        }

        int boletosVendibles = localidad.boletosVendibles(compradorActual.getCantidadBoletos());

        if (boletosVendibles == 0) {
            resultado += "No hay boletos disponibles en la localidad asignada.";
            return resultado;
        }

        double totalCompra = boletosVendibles * localidad.getPrecio();

        if (totalCompra > compradorActual.getPresupuestoMaximo()) {
            resultado += "El presupuesto máximo no es suficiente para comprar los boletos en la localidad asignada.";
            return resultado;
        }

        localidad.venderBoletos(boletosVendibles);
        resultado += "Compra realizada con éxito.\n";
        resultado += "Boletos comprados: " + boletosVendibles + "\n";
        resultado += "Total a pagar: $" + totalCompra;

        return resultado;
    }

    public String disponibilidadTotal() {
        String mensaje = "=== Disponibilidad Total de Boletos ===\n";
        mensaje += "Localidad 1: vendidos " + l1.getVendidos() + ", disponibles " + l1.getDisponibles() + "\n";
        mensaje += "Localidad 5: vendidos " + l5.getVendidos() + ", disponibles " + l5.getDisponibles() + "\n";
        mensaje += "Localidad 10: vendidos " + l10.getVendidos() + ", disponibles " + l10.getDisponibles();
        return mensaje;
    }

    public String disponibilidadIndividual(int idLocalidad) {
        if (idLocalidad == 1) {
            return "Localidad 1 - Disponibles: " + l1.getDisponibles();
        } else if (idLocalidad == 5) {
            return "Localidad 5 - Disponibles: " + l5.getDisponibles();
        } else if (idLocalidad == 10) {
            return "Localidad 10 - Disponibles: " + l10.getDisponibles();
        } else {
            return "Localidad inválida. Por favor, ingrese una localidad válida (1, 5 o 10).";
        }
    }

    public double cajaTotal() {
        return l1.reporteCaja() + l5.reporteCaja() + l10.reporteCaja();
    }

    private Ticket generarTicket() {
        int idTicket = random.nextInt(15000) + 1;
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        return new Ticket(idTicket, a, b);
    }

    private Localidad localidadAleatoria() {
        int opcion =  random.nextInt(3) + 1;

        if (opcion == 1) {
            return l1;
        } else if (opcion == 2) {
            return l5;
        } else {
            return l10;
        }
    }
}
