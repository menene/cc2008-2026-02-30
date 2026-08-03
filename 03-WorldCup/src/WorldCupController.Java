public class WorldCupController{
    private Evento Evento;
    private Comprador Comprador;
    private Contabilidad Contabilidad;
    private WorldCupView WorldCupView;
    private int localidadTemporal;

    public void inicializarEvento(){
        Evento = new Evento("Mundial Femenino"); 
        Contabilidad = new Contabilidad();
        WorldCupView = new WorldCupView();
        
        Localidad loc1 = new Localidad("Localidad 1", 100, 1500.50f);
        Localidad loc2 = new Localidad("Localidad 2", 50, 300.50f);
        Localidad loc3 = new Localidad("Localidad 3", 20, 1000.50f);
    
        Evento.agregarLocalidad(loc1);
        Evento.agregarLocalidad(loc2);
        Evento.agregarLocalidad(loc3);
    
    }

    public void iniciar (){
        boolean salir_del_while = false; 
        while ( salir_del_while == false){
            int opc = WorldCupView.MostrarMenu();
            if(opc==1){
                nuevoComprador();
            }else if(opc==2){
                nuevaSolicitud();
            }else if(opc==3){
                disponibilidadTotal();
            }else if(opc==4){
                disponibilidadIndividual();
            }else if(opc==5){
                reporteCaja();
            }else if(opc==6){
                salir_del_while=true;
                WorldCupView.mensaje("Adios");
            }else {
                WorldCupView.mensaje("Aqui no hayu nada");
            }
        }
    }

    public void nuevoComprador(){
        this.Comprador = WorldCupView.datosComprador();
        this.Comprador.generarTicket();

        WorldCupView.mensaje("Comprador creado! Tu ticket es: " + this.Comprador.getTicket().NumeroTicket);
    }

    public void nuevaSolicitud(){
        if(this.Comprador == null) {
            WorldCupView.mensaje("muere, haz la opcion 1 muejejej");
            return;
        }

        localidadTemporal = WorldCupView.datosLocalidad();
        ProcesarCompra();
    }


    public boolean ProcesarCompra(){
        boolean sePudo= false; 
        if(Comprador.getTicket().isTrue() == true){
            Localidad locDestino = null;
            if (localidadTemporal == 1) locDestino= Evento.obtenerLocalidad("Localidad 1");
            if (localidadTemporal == 2) locDestino= Evento.obtenerLocalidad("Localidad 2");
            if (localidadTemporal == 3) locDestino= Evento.obtenerLocalidad("Localidad 3");
             
            if(locDestino != null) {
                if(locDestino.getBoletosDisponibles() >= Comprador.getCantidadBoletos()) {
                    float costo = locDestino.calcularCosto(Comprador.getCantidadBoletos());
                    if(Comprador.getPresupuesto() >= costo) {
                        locDestino.ventas(Comprador.getCantidadBoletos());
                        Contabilidad.registrarVenta(locDestino, Comprador.getCantidadBoletos());
                        WorldCupView.mensaje("Exito! Compraste tus boletos. Te sobro dinero.");
                        sePudo = true;
                    } else {
                        WorldCupView.mensaje("Pobre. No tienes dinero suficiente.");
                    }
                } else {
                    WorldCupView.mensaje("No hay suficientes boletos.");
                }
            } else {
                WorldCupView.mensaje("Localidad no existe.");
            }
        } else {
            WorldCupView.mensaje("Tu ticket no es ganador, mala suerte.");
        }
        return sePudo;
        }
    }

    public void disponibilidadTotal(){
        WorldCupView.Dsiponibilidad(Evento.obtenerLocalidad());

    }

    public void disponibilidadIndividual(){
        int l= WorldCupView.datosLocalidad();
        if(l==1) WorldCupView.mensaje("Disponibles en Localidad 1" + Evento.obtenerLocalidad("Localidad 1").getBoletosDisponibles());
        if(l==2) WorldCupView.mensaje("Disponibles en Localidad 2" + Evento.obtenerLocalidad("Localidad 2").getBoletosDisponibles());
        if(l==3) WorldCupView.mensaje("Disponibles en Localidad 3" + Evento.obtenerLocalidad("Localidad 3").getBoletosDisponibles());

    }

    public void reporteCaja(){
     WorldCupView.MostrarCaja(Contabilidad.obtenerCajaTotal(""));
      WorldCupView.mostrarCajaLocalidad(Contabilidad);
    }








}