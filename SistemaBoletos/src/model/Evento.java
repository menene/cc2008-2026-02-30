package model;

import java.text.DecimalFormat;

public class Evento {
    private String nombre;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

    public Evento(String nombre, Localidad loc1, Localidad loc5, Localidad loc10) {
        this.nombre = nombre;
        this.localidad1 = loc1;
        this.localidad5 = loc5;
        this.localidad10 = loc10;
    }

    public String disponibilidad() {
        int total = localidad1.getBoletosDisponibles() + localidad5.getBoletosDisponibles() + localidad10.getBoletosDisponibles(); 
        int totalVendidos = vendidos();
        return String.format(
                "-------------------------------------%n"
              + "Disponibilidad General :)%n"
              + "-------------------------------------%n"
              + "Total Boletos disponibles: %d%n"
              + "Total Boletos vendidos: %d%n",
              total, totalVendidos
        );
    }

    public int vendidos() {
        return localidad1.getBoletosVendidos() + localidad5.getBoletosVendidos() + localidad10.getBoletosVendidos();
    }

    public String disponibilidadPorLocalidad(int localidad) {
        int disponibilidad;
        int vendidos;
        switch (localidad) {
            case 1:
                disponibilidad = localidad1.getBoletosDisponibles();
                vendidos = localidad1.getBoletosVendidos();
                break;
            case 5:
                disponibilidad = localidad5.getBoletosDisponibles();
                vendidos = localidad5.getBoletosVendidos();
                break;
            case 10:
                disponibilidad = localidad10.getBoletosDisponibles();
                vendidos = localidad10.getBoletosVendidos();
                break;
            default:
                return String.format("No existe la localidad %d :(. Ingrese una localidad válida", localidad);
        }

        return String.format(
                "-------------------------------------%n"
              + "Disponibilidad en la Localidad: %d :)%n"
              + "-------------------------------------%n"
              + "Boletos disponibles: %d%n"
              + "Boletos vendidos: %d%n",
              localidad, disponibilidad, vendidos
        );
    }


   public String reporteCaja() {
        DecimalFormat df = new DecimalFormat("$ #,##0.00");

        float totalGanancia = localidad1.getGanancia()
                            + localidad5.getGanancia()
                            + localidad10.getGanancia();

        return String.format(
                "Detalle de ganancias:%n"
                + "%s: %s%n"
                + "%s: %s%n"
                + "%s: %s%n"
                + "----------------------------%n"
                + "Ganancia total: %s%n"
                + "----------------------------%n",
                localidad1.getNombre(),
                df.format(localidad1.getGanancia()),
                localidad5.getNombre(),
                df.format(localidad5.getGanancia()),
                localidad10.getNombre(),
                df.format(localidad10.getGanancia()),
                df.format(totalGanancia)
        );
    }

    public String nombreLocalidades() {
        return String.format(
                "- %s%n" +
                "- %s%n" +
                "- %s%n",
             localidad1.getNombre(),
             localidad5.getNombre(),
             localidad10.getNombre()
            );
    }

    public String getNombre() {
        return this.nombre;
    }

    public Localidad getLocalidad(int opcion) {
        switch (opcion) {
            case 1:
                return localidad1;

            case 2:
                return localidad5;

            case 3:
                return localidad10;
            default:
                return null;
        }
    }
}