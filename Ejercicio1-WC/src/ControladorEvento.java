import java.util.Random;
public class ControladorEvento {
    private Localidad localidad1;
    private Localidad localidad2;
    private Localidad localidad3;
    private Cliente cliente1;
    private VistaEvento vista = new VistaEvento();

    public ControladorEvento() {
        this.localidad1 = new Localidad("1", 20, 100);
        this.localidad2 = new Localidad("2", 20, 500);
        this.localidad3 = new Localidad("3", 20, 1000);
        vista = new VistaEvento();
    }

    public void Iniciar() {
        RegistrarCliente();

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.MostrarMenu();

            switch (opcion) {
                case 1:
                    RegistrarCliente();
                    break;

                case 2:
                    Proceso();
                    break;

                case 3:
                    DisponibilidadTotal();
                    break;

                case 4:
                    DisponibilidadIndividual();
                    break;

                case 5:
                    ReporteCaja();
                    break;
                    
                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    public void RegistrarCliente() {
        cliente1 = vista.LeerDatosCliente();
    }

    public void ReporteCaja() {
        vista.ReporteCaja(localidad1, localidad2, localidad3);
    }

    public void DisponibilidadTotal() {
        vista.DisponibilidadTotal(localidad1, localidad2, localidad3);
    }

    public void DisponibilidadIndividual() {
        int opcion = vista.EscogerLocalidad();
        switch (opcion) {
            case 1:
                vista.DisponibilidadIndividual(localidad1);
                break;
            case 2:
                vista.DisponibilidadIndividual(localidad2);
                break;
            case 3:
                vista.DisponibilidadIndividual(localidad3);
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public void Proceso() {
        if (Solicitud()) {
            vista.mostrarMensaje("Ticket seleccionado");
            Localidad localidad = AsignarLocalidad();
            vista.mostrarMensaje("Localidad asignada: " + localidad.GetNumLocalidad());
            if (ValidarEspacio(localidad)) {
                int cantidad = ValidarDisponibilidad(localidad, cliente1);
                if (ValidarPrecio(localidad, cliente1)) {
                    VenderBoleto(localidad, cliente1);
                    vista.mostrarMensaje("Venta realizada con exito");
                } else {
                    vista.mostrarMensaje("El presupuesto no es suficiente");
                }
            } else {
              vista.mostrarMensaje("La localidad ya no tiene espacio");  
            }
        } else {
            vista.mostrarMensaje("Ticket no seleccionado");
        }
    }

    public boolean Solicitud() {
        Random aleatorio = new Random();
        int ticket = aleatorio.nextInt(15000) + 1;
        int n1 = aleatorio.nextInt(15000) + 1;
        int n2 = aleatorio.nextInt(15000) + 1;

        if (n1 < n2) {
            if (n1 < ticket && ticket < n2){
                return true;
            } else {
                return false;
            }
        } else if (n1 > n2) {
            if (n2 < ticket && ticket < n1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Localidad AsignarLocalidad() {
        Random aleatorio = new Random();
        int opcion = aleatorio.nextInt(3) + 1;
        switch (opcion) {
            case 1:
                return localidad1;
            
            case 2:
                return localidad2;
                
            case 3:
                return localidad3;

            default:
                return localidad3;
        }
    }

    public boolean ValidarEspacio(Localidad localidad) {
        if (localidad.GetBoletosDisponibles() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int ValidarDisponibilidad(Localidad localidad, Cliente cliente) {
        if (cliente.GetBoletosComprar() <= localidad.GetBoletosDisponibles()) {
            return cliente.GetBoletosComprar();
        } else {
            cliente.SetBoletosComprar(localidad.GetBoletosDisponibles());
            return cliente.GetBoletosComprar();
        }
    }

    public boolean ValidarPrecio(Localidad localidad, Cliente cliente) {
        if (cliente.GetPresupuesto() >= (localidad.GetPrecio() * cliente.GetBoletosComprar())) {
            return true;
        } else {
            return false;
        }
    }

    public void VenderBoleto(Localidad localidad, Cliente cliente) {
        localidad.SetBoletosDisponibles(localidad.GetBoletosDisponibles() - cliente.GetBoletosComprar());
        cliente.SetPresupuesto(cliente.GetPresupuesto() - (localidad.GetPrecio() * cliente.GetBoletosComprar()));
    }
}