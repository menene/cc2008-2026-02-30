import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Controlador {

    private List<Orden> ordenes = new ArrayList<>();
    private Vista vista = new Vista();

    public void Iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();

            try {
                int opcion = vista.leerEntero(
                        "Seleccione una opción: "
                );

                switch (opcion) {
                    case 1:
                        procesoRegistrarOrden();
                        break;

                    case 2:
                        vista.mostrarOrdenes(consultarOrdenes());
                        break;

                    case 3:
                        procesoBuscarOrden();
                        break;

                    case 4:
                        procesoModificarOrden();
                        break;

                    case 5:
                        procesoCancelarOrden();
                        break;

                    case 6:
                        procesoBuscarPorPlaca();
                        break;

                    case 7:
                        vista.mostrarCostos(
                                CostoTotal(),
                                Promedio()
                        );
                        break;

                    case 8:
                        vista.mostrarOrden(OrdenMayor());
                        break;

                    case 9:
                        vista.mostrarCantidad(
                                CantidadOrden()
                        );
                        break;

                    case 10:
                        continuar = false;
                        vista.Mensaje(
                                "Gracias por utilizar el sistema."
                        );
                        break;

                    default:
                        vista.Mensaje(
                                "La opción debe estar entre 1 y 10."
                        );
                        break;
                }

            } catch (IllegalArgumentException e) {
                vista.Mensaje(
                        "Error: " + e.getMessage()
                );

            } catch (NoSuchElementException e) {
                vista.Mensaje(
                        "Error: " + e.getMessage()
                );

            } finally {
                vista.Mensaje("Operación finalizada.");
            }
        }
    }

    private void procesoRegistrarOrden() {
        int noOrden;

        while (true) {
            noOrden = vista.leerEntero(
                    "Ingrese el número de orden: "
            );

            if (noOrden <= 0) {
                vista.Mensaje(
                        "Error: el número de orden debe ser mayor que cero."
                );
                continue;
            }

            if (ExistenciaOrden(noOrden)) {
                vista.Mensaje(
                        "Error: ese número de orden ya está registrado."
                );
                continue;
            }

            break;
        }

        String nombre = vista.leerTexto(
                "Ingrese el nombre del propietario: "
        );

        String placa = vista.leerTexto(
                "Ingrese la placa del vehículo: "
        );

        String descripcion = vista.leerTexto(
                "Ingrese la descripción del servicio: "
        );

        double costo = vista.leerDouble(
                "Ingrese el costo estimado: "
        );

        Orden nuevaOrden = new Orden(
                noOrden,
                nombre,
                placa,
                descripcion,
                costo
        );

        registrarOrden(nuevaOrden);

        vista.Mensaje(
                "La orden fue registrada correctamente."
        );
    }

    private void procesoBuscarOrden() {
        int noOrden = vista.leerEntero(
                "Ingrese el número de orden: "
        );

        Orden ordenEncontrada = buscar(noOrden);
        vista.mostrarOrden(ordenEncontrada);
    }

    private void procesoModificarOrden() {
        int noOrden = vista.leerEntero(
                "Ingrese el número de orden que desea modificar: "
        );

        // Primero verifica que la orden exista
        buscar(noOrden);

        String nuevaDescripcion = vista.leerTexto(
                "Ingrese la nueva descripción: "
        );

        double nuevoCosto = vista.leerDouble(
                "Ingrese el nuevo costo estimado: "
        );

        modificar(
                noOrden,
                nuevaDescripcion,
                nuevoCosto
        );

        vista.Mensaje(
                "La orden fue modificada correctamente."
        );
    }

    private void procesoCancelarOrden() {
        int noOrden = vista.leerEntero(
                "Ingrese el número de orden que desea cancelar: "
        );

        cancelar(noOrden);

        vista.Mensaje(
                "La orden fue cancelada correctamente."
        );
    }

    private void procesoBuscarPorPlaca() {
        String placa = vista.leerTexto(
                "Ingrese la placa del vehículo: "
        );

        List<Orden> coincidencias = BuscarPorPlaca(placa);

        if (coincidencias.isEmpty()) {
            vista.Mensaje(
                    "No existen órdenes asociadas con esa placa."
            );
        } else {
            vista.mostrarOrdenes(coincidencias);
        }
    }

    public void registrarOrden(Orden orden) {
        validarOrden(orden);

        if (ExistenciaOrden(orden.getNoOrden())) {
            throw new IllegalArgumentException(
                    "El número de orden ya está registrado."
            );
        }

        ordenes.add(orden);
    }

    public List<Orden> consultarOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public Orden buscar(int noOrden) {
        for (Orden orden : ordenes) {
            if (orden.getNoOrden() == noOrden) {
                return orden;
            }
        }

        throw new NoSuchElementException(
                "No existe una orden con el número "
                        + noOrden + "."
        );
    }

    public void modificar(
            int noOrden,
            String nuevaDescripcion,
            double nuevoCosto
    ) {
        if (nuevaDescripcion == null
                || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException(
                    "El costo debe ser mayor que cero."
            );
        }

        Orden orden = buscar(noOrden);

        orden.setDescripcion(nuevaDescripcion);
        orden.setCosto(nuevoCosto);
    }

    public void cancelar(int noOrden) {
        Orden orden = buscar(noOrden);
        ordenes.remove(orden);
    }

    public List<Orden> BuscarPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía."
            );
        }

        List<Orden> coincidencias = new ArrayList<>();

        for (Orden orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public double CostoTotal() {
        double total = 0;

        for (Orden orden : ordenes) {
            total += orden.getCosto();
        }

        return total;
    }

    public double Promedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }

        return CostoTotal() / ordenes.size();
    }

    public Orden OrdenMayor() {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException(
                    "No hay órdenes registradas."
            );
        }

        Orden ordenMayor = ordenes.get(0);

        for (Orden orden : ordenes) {
            if (orden.getCosto() > ordenMayor.getCosto()) {
                ordenMayor = orden;
            }
        }

        return ordenMayor;
    }

    public int CantidadOrden() {
        return ordenes.size();
    }

    public boolean ExistenciaOrden(int noOrden) {
        for (Orden orden : ordenes) {
            if (orden.getNoOrden() == noOrden) {
                return true;
            }
        }

        return false;
    }

    public void validarOrden(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException(
                    "La orden no puede ser nula."
            );
        }

        if (orden.getNoOrden() <= 0) {
            throw new IllegalArgumentException(
                    "El número de orden debe ser mayor que cero."
            );
        }

        if (orden.getNombre() == null
                || orden.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        if (orden.getPlaca() == null
                || orden.getPlaca().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía."
            );
        }

        if (orden.getDescripcion() == null
                || orden.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        if (orden.getCosto() <= 0) {
            throw new IllegalArgumentException(
                    "El costo debe ser mayor que cero."
            );
        }
    }
}