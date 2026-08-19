import java.util.Random;

public class SistemaVenta {

    private Localidad[] localidades;
    private String codigoAutorizacion;

    public SistemaVenta(){

        localidades = new Localidad[3];

        localidades[0] = new Localidad (1, 100, 20);
        localidades[1] = new Localidad (5, 500, 20);
        localidades[2] = new Localidad (10,1000, 20);

        this.codigoAutorizacion = "rog27";

    }

    public Localidad[] getLocalidades(){
        return  localidades;
    
    }

    public Localidad buscarLocalidad(int numero){
        
        for (int i =0; i < localidades.length; i++){

            if(localidades[i].getNumero() == numero) {

                return localidades[i];
            }
        }
        return null;
        
    }

    public boolean validarCodigo(String codigo) {

        return codigo.equals(codigoAutorizacion);
    
    }

    public double calcularCaja(){

        double total = 0;

        for(int i =0; i < localidades.length; i++){
            total += localidades[i].getIngreso();
    }

        return total;

    }

    public void procesarCompra(Comprador comprador) {

        Ticket ticket = new Ticket();
        ticket.generarTicket();

        if(!ticket.esApto()) {

            return;
        }

        Random random = new Random();

        Localidad localidad = localidades[random.nextInt(localidades.length)];

        if (!localidad.hayEspacio()) {
            return;
        }

        if (comprador.getCantidadBoletos() > localidad.getDisponibles()) {
            return;
        }

        double costo = comprador.getCantidadBoletos() * localidad.getPrecio();
        
        if (costo > comprador.getPresupuesto()){
            return;
        }

        localidad.venderBoletos(comprador.getCantidadBoletos());
        System.out.println("Compra realizada con exito");
        System.out.println("Localidad asignada: " + localidad.getNumero());
        System.out.println("Boletos comprados: " + comprador.getCantidadBoletos());
    

    
    }
}