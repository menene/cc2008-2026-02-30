import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner teclado;
    private Controlador control;

    public Vista() {
        teclado = new Scanner(System.in);
        control = new Controlador();
    }

    public void iniciarSistema() {
        int seleccion = 0;
        do {
            desplegarOpciones();
            seleccion = capturarEntero();
            ejecutarAccion(seleccion);
        } while (seleccion != 10);
    }

    private void desplegarOpciones() {
        System.out.println("\n--- Taller Principal ---");
        System.out.println("1. Nueva ficha");
        System.out.println("2. Ver historial completo");
        System.out.println("3. Buscar ficha por ID");
        System.out.println("4. Actualizar ficha");
        System.out.println("5. Borrar ficha");
        System.out.println("6. Ver historial de placa");
        System.out.println("7. Balance general");
        System.out.println("8. Servicio mas costoso");
        System.out.println("9. Total de clientes");
        System.out.println("10. Salir");
        System.out.print("Elige una opcion: ");
    }

    private void ejecutarAccion(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    FichaReparacion nueva = pedirInformacion();
                    if (nueva != null) {
                        control.ingresarFicha(nueva);
                        System.out.println("Guardado correctamente.");
                    }
                    break;
                case 2:
                    List<FichaReparacion> todas = control.obtenerTodas();
                    if (todas.isEmpty()) {
                        System.out.println("No hay datos guardados.");
                    } else {
                        for (FichaReparacion f : todas) {
                            System.out.println(f.toString());
                        }
                    }
                    break;
                case 3:
                    procesoBusqueda();
                    break;
                case 4:
                    System.out.print("ID a modificar: ");
                    int idEdit = capturarEntero();
                    System.out.print("Nuevo detalle: ");
                    String textoEdit = teclado.nextLine();
                    System.out.print("Nuevo precio: ");
                    double precioEdit = capturarDecimal();
                    control.editarFicha(idEdit, textoEdit, precioEdit);
                    System.out.println("Actualizado.");
                    break;
                case 5:
                    System.out.print("ID a borrar: ");
                    int idBorrar = capturarEntero();
                    control.eliminarFicha(idBorrar);
                    System.out.println("Registro borrado.");
                    break;
                case 6:
                    System.out.print("Placa a consultar: ");
                    String placa = teclado.nextLine();
                    List<FichaReparacion> autos = control.filtrarPorMatricula(placa);
                    if (autos.isEmpty()) {
                        System.out.println("Sin coincidencias.");
                    } else {
                        for (FichaReparacion f : autos) {
                            System.out.println(f.toString());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Ingresos totales: Q" + control.sumarIngresos());
                    System.out.println("Promedio: Q" + control.promediarPrecios());
                    break;
                case 8:
                    FichaReparacion top = control.encontrarMasCara();
                    System.out.println("Trabajo mas caro:\n" + top.toString());
                    break;
                case 9:
                    System.out.println("Fichas activas: " + control.contarFichas());
                    break;
                case 10:
                    System.out.println("Apagando sistema...");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private FichaReparacion pedirInformacion() {
        System.out.print("ID de orden: ");
        int id = capturarEntero();
        
        System.out.print("Propietario: ");
        String cliente = teclado.nextLine();
        
        System.out.print("Placa: ");
        String matricula = teclado.nextLine();
        
        System.out.print("Detalle del trabajo: ");
        String detalle = teclado.nextLine();
        
        System.out.print("Precio estimado: ");
        double precio = capturarDecimal();

        if (cliente.trim().isEmpty() || matricula.trim().isEmpty() || detalle.trim().isEmpty()) {
            System.out.println("Error: Textos incompletos.");
            return null;
        }
        if (precio <= 0) {
            System.out.println("Error: El precio no es valido.");
            return null;
        }

        return new FichaReparacion(id, cliente, matricula, detalle, precio);
    }

    private void procesoBusqueda() {
        try {
            System.out.print("ID a buscar: ");
            int id = capturarEntero();
            FichaReparacion hallada = control.localizarFicha(id);
            System.out.println(hallada.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int capturarEntero() {
        int num = 0;
        boolean ok = false;
        while (!ok) {
            try {
                num = Integer.parseInt(teclado.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un numero entero valido: ");
            } finally {
                purgarEntrada();
            }
        }
        return num;
    }

    private double capturarDecimal() {
        double num = 0;
        boolean ok = false;
        while (!ok) {
            try {
                num = Double.parseDouble(teclado.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un monto numerico: ");
            } finally {
                purgarEntrada();
            }
        }
        return num;
    }

    private void purgarEntrada() {
    }
}