import java.util.InputMismatchException;
import java.util.Scanner;

/* Clase de la vista. Es la unica que imprime y lee los datos del usuario. */
public class Vista {

    private Festival festival;
    private Scanner scanner;

    /* Constructor. Prepara el lector de la consola. El festival todavia no existe */
    public Vista() {
        festival = null;
        scanner = new Scanner(System.in);
    }

    /* Muestra las 13 opciones, lee la que elija el usuario y repite hasta que escoja salir */
    public void mostrarMenu() {
        System.out.println("FESTIVAL UNIVERSITARIO DE MUSICA");
        System.out.println("Primero se necesitan los datos del festival");
        nuevoFestival();

        int opcion = 0;

        while (opcion != 13) {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("1. Nuevo festival");
            System.out.println("2. Configurar escenario");
            System.out.println("3. Consultar escenarios");
            System.out.println("4. Consultar un escenario");
            System.out.println("5. Modificar escenario");
            System.out.println("6. Retirar escenario");
            System.out.println("7. Registrar artista");
            System.out.println("8. Consultar artistas");
            System.out.println("9. Buscar artista");
            System.out.println("10. Modificar artista");
            System.out.println("11. Cancelar participacion");
            System.out.println("12. Mostrar reporte del festival");
            System.out.println("13. Salir");

            opcion = leerEntero("Opcion: ");

            if (opcion == 1) {
                nuevoFestival();
            } else if (opcion == 2) {
                configurarEscenario();
            } else if (opcion == 3) {
                consultarEscenarios();
            } else if (opcion == 4) {
                consultarUnEscenario();
            } else if (opcion == 5) {
                modificarEscenario();
            } else if (opcion == 6) {
                retirarEscenario();
            } else if (opcion == 7) {
                registrarArtista();
            } else if (opcion == 8) {
                consultarArtistas();
            } else if (opcion == 9) {
                buscarArtista();
            } else if (opcion == 10) {
                modificarArtista();
            } else if (opcion == 11) {
                cancelarParticipacion();
            } else if (opcion == 12) {
                mostrarReporte();
            } else if (opcion == 13) {
                System.out.println("Adios");
            } else {
                System.out.println("La opcion debe estar entre 1 y 13");
            }
        }

        scanner.close();
    }

    /* 1. Pide los datos y crea un festival nuevo, que reemplaza al anterior */
    public void nuevoFestival() {
        String nombre = leerTexto("Nombre del festival: ");
        String codigoIdentificacion = leerTexto("Codigo de identificacion: ");
        String nombreCoordinador = leerTexto("Nombre del coordinador: ");

        festival = new Festival(nombre, codigoIdentificacion, nombreCoordinador);

        System.out.println("Festival creado. Empieza sin escenarios configurados y sin artistas registrados");
    }

    /* 2. Pide la posicion y los datos del escenario, y lo guarda en el arreglo */
    public void configurarEscenario() {
        if (hayFestival() == false) {
            return;
        }

        try {
            int posicion = leerEntero("Posicion del arreglo (0 a 4): ");

            if (festival.posicionOcupada(posicion) == true) {
                System.out.println("La posicion " + posicion + " ya tiene un escenario configurado");
                return;
            }

            String codigo = leerTexto("Codigo del escenario: ");
            String nombre = leerTexto("Nombre del escenario: ");
            String ubicacion = leerTexto("Ubicacion: ");
            int capacidadMaxima = leerEntero("Capacidad maxima de asistentes: ");
            String estado = leerEstado("Estado (disponible, ocupado o mantenimiento): ");

            Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidadMaxima, estado);
            festival.configurarEscenario(posicion, escenario);

            System.out.println("Escenario configurado en la posicion " + posicion);

        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 3. Muestra todos los escenarios configurados con la posicion que ocupan */
    public void consultarEscenarios() {
        if (hayFestival() == false) {
            return;
        }

        System.out.println(festival.listarEscenarios());
    }

    /* 4. Pide una posicion y muestra el escenario que esta guardado ahi */
    public void consultarUnEscenario() {
        if (hayFestival() == false) {
            return;
        }

        try {
            int posicion = leerEntero("Posicion del escenario (0 a 4): ");
            Escenario escenario = festival.getEscenario(posicion);

            if (escenario == null) {
                System.out.println("La posicion " + posicion + " todavia esta vacia");
                return;
            }

            System.out.println("Posicion " + posicion + ": " + escenario.toString());

        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 5. Pide la posicion y cambia la capacidad y el estado de ese escenario */
    public void modificarEscenario() {
        if (hayFestival() == false) {
            return;
        }

        try {
            int posicion = leerEntero("Posicion del escenario a modificar (0 a 4): ");

            if (festival.posicionOcupada(posicion) == false) {
                System.out.println("La posicion " + posicion + " esta vacia, no hay escenario que modificar");
                return;
            }

            System.out.println("Escenario actual: " + festival.getEscenario(posicion).toString());

            int nuevaCapacidad = leerEntero("Nueva capacidad maxima: ");
            String nuevoEstado = leerEstado("Nuevo estado (disponible, ocupado o mantenimiento): ");

            festival.modificarEscenario(posicion, nuevaCapacidad, nuevoEstado);

            System.out.println("Escenario modificado: " + festival.getEscenario(posicion).toString());

        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 6. Pide la posicion y deja esa posicion del arreglo otra vez en null */
    public void retirarEscenario() {
        if (hayFestival() == false) {
            return;
        }

        try {
            int posicion = leerEntero("Posicion del escenario a retirar (0 a 4): ");
            festival.retirarEscenario(posicion);

            System.out.println("Escenario retirado, la posicion " + posicion + " quedo disponible otra vez");

        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Error: " + error.getMessage());
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 7. Pide los datos del artista y lo agrega al ArrayList */
    public void registrarArtista() {
        if (hayFestival() == false) {
            return;
        }

        try {
            String codigo = leerTexto("Codigo del artista: ");
            String nombreArtistico = leerTexto("Nombre artistico: ");
            String generoMusical = leerTexto("Genero musical: ");
            int duracionMinutos = leerEntero("Duracion de la presentacion en minutos: ");
            int asistentesEstimados = leerEntero("Cantidad estimada de asistentes: ");

            Artista artista = new Artista(codigo, nombreArtistico, generoMusical, duracionMinutos, asistentesEstimados);
            festival.registrarArtista(artista);

            System.out.println("Artista registrado. Ahora hay " + festival.contarArtistas() + " artistas");

        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 8. Muestra todos los artistas registrados en el ArrayList */
    public void consultarArtistas() {
        if (hayFestival() == false) {
            return;
        }

        System.out.println(festival.listarArtistas());
    }

    /* 9. Pide un codigo y muestra la informacion de ese artista */
    public void buscarArtista() {
        if (hayFestival() == false) {
            return;
        }

        String codigo = leerTexto("Codigo del artista a buscar: ");
        Artista artista = festival.buscarArtista(codigo);

        if (artista == null) {
            System.out.println("No hay ningun artista registrado con el codigo " + codigo);
            return;
        }

        System.out.println(artista.toString());
    }

    /* 10. Pide el codigo del artista y cambia sus datos, con las mismas validaciones */
    public void modificarArtista() {
        if (hayFestival() == false) {
            return;
        }

        try {
            String codigo = leerTexto("Codigo del artista a modificar: ");
            Artista artista = festival.buscarArtista(codigo);

            if (artista == null) {
                System.out.println("No hay ningun artista registrado con el codigo " + codigo);
                return;
            }

            System.out.println("Artista actual: " + artista.toString());

            String nombreArtistico = leerTexto("Nuevo nombre artistico: ");
            String generoMusical = leerTexto("Nuevo genero musical: ");
            int duracionMinutos = leerEntero("Nueva duracion en minutos: ");
            int asistentesEstimados = leerEntero("Nueva cantidad estimada de asistentes: ");

            artista.setDuracionMinutos(duracionMinutos);
            artista.setAsistentesEstimados(asistentesEstimados);
            artista.setNombreArtistico(nombreArtistico);
            artista.setGeneroMusical(generoMusical);

            System.out.println("Artista modificado: " + artista.toString());

        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }

    /* 11. Pide el codigo del artista y lo saca del ArrayList */
    public void cancelarParticipacion() {
        if (hayFestival() == false) {
            return;
        }

        String codigo = leerTexto("Codigo del artista que cancela: ");
        boolean cancelado = festival.cancelarParticipacion(codigo);

        if (cancelado == false) {
            System.out.println("No hay ningun artista registrado con el codigo " + codigo);
            return;
        }

        System.out.println("Participacion cancelada. Quedan " + festival.contarArtistas() + " artistas");
    }

    /* 12. Muestra el reporte completo del festival */
    public void mostrarReporte() {
        if (hayFestival() == false) {
            return;
        }

        System.out.println(festival.generarReporte());
    }

    /* Lee un texto y no lo acepta vacio, se lo vuelve a pedir al usuario */
    private String leerTexto(String mensaje) {
        String texto = "";

        while (texto.length() == 0) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.length() == 0) {
                System.out.println("Este dato no puede quedar vacio, intente de nuevo");
            }
        }

        return texto;
    }

    /* Lee el estado del escenario y solo acepta los tres valores permitidos */
    private String leerEstado(String mensaje) {
        String estado = "";
        boolean valido = false;

        while (valido == false) {
            estado = leerTexto(mensaje);

            if (estado.equalsIgnoreCase("disponible") == true
                    || estado.equalsIgnoreCase("ocupado") == true
                    || estado.equalsIgnoreCase("mantenimiento") == true) {
                valido = true;
            } else {
                System.out.println("El estado solo puede ser disponible, ocupado o mantenimiento");
            }
        }

        return estado;
    }

    /* Lee un numero entero. Si el usuario escribe letras se lo vuelve a pedir */
    private int leerEntero(String mensaje) {
        int numero = 0;
        boolean leido = false;

        while (leido == false) {
            System.out.print(mensaje);

            try {
                numero = scanner.nextInt();
                leido = true;
            } catch (InputMismatchException error) {
                System.out.println("Eso no es un numero entero, intente de nuevo");
            } finally {
                /* Pase lo que pase, limpia lo que quedo escrito en la linea */
                scanner.nextLine();
            }
        }

        return numero;
    }

    /* Revisa si ya existe un festival creado antes de usar cualquier opcion del menu */
    private boolean hayFestival() {
        if (festival == null) {
            System.out.println("Todavia no hay un festival creado, use la opcion 1");
            return false;
        }

        return true;
    }
}
