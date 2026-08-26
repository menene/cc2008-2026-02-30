import java.util.ArrayList;
import java.util.List;

public class ControladorOrdenes {
    private ArrayList<OrdenServicio> ordenes;
    private VistaOrdenes vista;

    public ControladorOrdenes() {
        this.ordenes = new ArrayList<>();
        this.vista = new VistaOrdenes();
    }

    public void Iniciar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.MostrarMenu();

            switch (opcion) {
                case 1:
                    RegistrarOrden();
                    break;

                case 2:
                    ConsultarOrdenes();
                    break;

                case 3:
                    ProcesoBuscarOrden();
                    break;

                case 4:
                    ModificarOrden();
                    break;

                case 5:
                    CancelarOrden();
                    break;

                case 6:
                    ConsultarPorPlaca();
                    break;

                case 7:
                    MostrarReporteCostos();
                    break;

                case 8:
                    MostrarOrdenDeCostoMayor();
                    break;

                case 9:
                    MostrarCantidadOrdenes();
                    break;

                case 10:
                    continuar = false;
                    vista.MostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.MostrarMensaje("Opción inválida.");
                    break;
            }
        }
    }

    public void RegistrarOrden() {
        OrdenServicio orden = vista.LeerOrdenServicio();

        if (orden == null) {
            return;
        }

        try {
            RegistrarOrden(orden);
            vista.MostrarMensaje("Orden registrada correctamente.");
        } catch (Exception e) {
            vista.MostrarMensaje(e.getMessage());
        }
    }

    public void RegistrarOrden(OrdenServicio orden) throws Exception {
        for (OrdenServicio ordenRegistrada : ordenes) {
            if (ordenRegistrada.GetNumOrden() == orden.GetNumOrden()) {
                throw new Exception(
                    "El número de orden ya está registrado."
                );
            }
        }

        if (orden.GetPropietario().isBlank()) {
            throw new Exception(
                "El nombre del propietario no puede estar vacío."
            );
        }

        if (orden.GetPlaca().isBlank()) {
            throw new Exception(
                "La placa no puede estar vacía."
            );
        }

        if (orden.GetDescripcion().isBlank()) {
            throw new Exception(
                "La descripción no puede estar vacía."
            );
        }

        if (orden.GetCosto() <= 0) {
            throw new Exception(
                "El costo estimado debe ser mayor que cero."
            );
        }

        ordenes.add(orden);
    }

    public List<OrdenServicio> GetOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public void ConsultarOrdenes() {
        vista.MostrarOrdenes(GetOrdenes());
    }

    public OrdenServicio BuscarOrden(int numOrden)
            throws Exception {

        if (numOrden == -1) {
            return null;
        }

        for (OrdenServicio orden : ordenes) {
            if (orden.GetNumOrden() == numOrden) {
                return orden;
            }
        }

        throw new Exception("La orden no está registrada.");
    }

    public void ProcesoBuscarOrden() {
        int numOrden = vista.LeerNumeroOrden();

        try {
            OrdenServicio orden = BuscarOrden(numOrden);

            if (orden == null) {
                return;
            }

            vista.MostrarOrdenBuscada(orden);

        } catch (Exception e) {
            vista.MostrarMensaje(e.getMessage());

        } finally {
            vista.MostrarMensaje(
                "Proceso de búsqueda finalizado."
            );
        }
    }

    public void ModificarOrden() {
        int numOrden = vista.LeerNumeroOrden();

        if (numOrden == -1) {
            return;
        }

        try {
            BuscarOrden(numOrden);

            int opcion = vista.MostrarOpcionesModificacion();

            switch (opcion) {
                case 1:
                    String nuevaDescripcion =
                            vista.LeerNuevaDescripcion();

                    modificarDescripcion(
                        numOrden,
                        nuevaDescripcion
                    );
                    break;

                case 2:
                    double nuevoCosto = vista.LeerNuevoCosto();

                    modificarCosto(numOrden, nuevoCosto);
                    break;

                default:
                    vista.MostrarMensaje(
                        "Opción de modificación inválida."
                    );
                    return;
            }

        } catch (Exception e) {
            vista.MostrarMensaje(e.getMessage());
        }
    }

    public void modificarDescripcion(
            int numOrden,
            String nuevaDescripcion) throws Exception {

        if (nuevaDescripcion.equals("INVALIDO")) {
            return;
        }

        OrdenServicio orden = BuscarOrden(numOrden);

        if (orden == null) {
            return;
        }

        orden.SetDescripcion(nuevaDescripcion);

        vista.MostrarMensaje(
            "Descripción modificada correctamente."
        );
    }

    public void modificarCosto(
            int numOrden,
            double nuevoCosto) throws Exception {

        if (nuevoCosto == -1) {
            return;
        }

        if (nuevoCosto <= 0) {
            throw new Exception(
                "El costo debe ser mayor que cero."
            );
        }

        OrdenServicio orden = BuscarOrden(numOrden);

        if (orden == null) {
            return;
        }

        orden.SetCosto(nuevoCosto);

        vista.MostrarMensaje(
            "Costo modificado correctamente."
        );
    }

    public void CancelarOrden() {
        int numOrden = vista.LeerNumeroOrden();

        if (numOrden == -1) {
            return;
        }

        try {
            CancelarOrden(numOrden);
            vista.OrdenCancelada();

        } catch (Exception e) {
            vista.MostrarMensaje(e.getMessage());
        }
    }

    public void CancelarOrden(int numOrden) throws Exception {

        OrdenServicio orden = BuscarOrden(numOrden);

        if (orden == null) {
            return;
        }

        ordenes.remove(orden);
    }

    public void ConsultarPorPlaca() {
        String placa = vista.LeerPlaca();

        if (placa.equals("INVALIDO")) {
            return;
        }

        List<OrdenServicio> resultados = ConsultarPorPlaca(placa);

        vista.MostrarOrdenConsultadaPlaca(resultados);
    }

    public List<OrdenServicio> ConsultarPorPlaca(String placa) {

        List<OrdenServicio> resultados = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {
            if (orden.GetPlaca().equalsIgnoreCase(placa)) {
                resultados.add(orden);
            }
        }

        return resultados;
    }

    public double ReporteTotal() {
        double total = 0.0;

        for (OrdenServicio orden : ordenes) {
            total += orden.GetCosto();
        }

        return total;
    }

    public double ReportePromedio() {
        if (ordenes.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (OrdenServicio orden : ordenes) {
            total += orden.GetCosto();
        }

        return total / ordenes.size();
    }

    public void MostrarReporteCostos() {
        vista.MostrarReporteCostos(ReporteTotal(),ReportePromedio());
    }

    public OrdenServicio OrdenDeCostoMayor() {
        if (ordenes.isEmpty()) {
            return null;
        }

        OrdenServicio ordenDeCostoMayor =
                ordenes.get(0);

        for (OrdenServicio orden : ordenes) {
            if (orden.GetCosto()
                    > ordenDeCostoMayor.GetCosto()) {

                ordenDeCostoMayor = orden;
            }
        }

        return ordenDeCostoMayor;
    }

    public void MostrarOrdenDeCostoMayor() {
        vista.MostrarOrdenDeCostoMayor(OrdenDeCostoMayor());
    }

    public int CantidadOrdenes() {
        int cantidadOrdenes = 0;

        for (OrdenServicio orden : ordenes) {
            cantidadOrdenes += 1;
        }

        return cantidadOrdenes;
    }

    public void MostrarCantidadOrdenes() {
        vista.MostrarCantidadOrdenes(CantidadOrdenes());
    }
}