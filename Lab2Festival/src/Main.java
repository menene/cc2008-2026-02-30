public class Main {

    public static void main(String[] args) {

        Vista vista = new Vista();
        Festival festival = null;

        int opcion = 0;

        while (opcion != 13) {

            vista.mostrarMenu();
            opcion = vista.pedirOpcion();

            switch (opcion) {

                case 1:
                    // NUEVO FESTIVAL

                    String[] datosFestival = vista.pedirDatosFestival();

                    String nombre = datosFestival[0];
                    int codigo = Integer.parseInt(datosFestival[1]);
                    String coordinador = datosFestival[2];

                    festival = new Festival(
                        nombre,
                        codigo,
                        coordinador
                    );

                    vista.mostrarMensaje("Festival creado.");
                    break;


                case 2:
                    // CONFIGURAR ESCENARIO

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    String[] datosEscenario =
                        vista.pedirDatosEscenario();

                    int codigoEscenario =
                        Integer.parseInt(datosEscenario[0]);

                    String nombreEscenario =
                        datosEscenario[1];

                    String ubicacion =
                        datosEscenario[2];

                    int capacidad =
                        Integer.parseInt(datosEscenario[3]);

                    boolean estado =
                        Boolean.parseBoolean(datosEscenario[4]);

                    Escenario escenario = new Escenario(
                        codigoEscenario,
                        nombreEscenario,
                        ubicacion,
                        capacidad,
                        estado
                    );

                    vista.mostrarMensaje(
                        "Ingrese la posicion del escenario:"
                    );

                    int posicion = vista.pedirOpcion();

                    festival.configurarEscenario(
                        posicion,
                        escenario
                    );

                    vista.mostrarMensaje(
                        "Escenario configurado."
                    );

                    break;


                case 3:
                    // CONSULTAR TODOS LOS ESCENARIOS

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    Escenario[] escenarios =
                        festival.obtenerEscenarios();

                    for (int i = 0; i < escenarios.length; i++) {

                        if (escenarios[i] != null) {

                            vista.mostrarMensaje(
                                "\nPosicion: " + i
                            );

                            vista.mostrarEscenario(
                                escenarios[i]
                            );
                        }
                    }

                    break;


                case 4:
                    // CONSULTAR UN ESCENARIO

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese la posicion:"
                    );

                    int posicionConsulta =
                        vista.pedirOpcion();

                    Escenario encontrado =
                        festival.consultarEscenario(
                            posicionConsulta
                        );

                    vista.mostrarEscenario(encontrado);

                    break;


                case 5:
                    // MODIFICAR ESCENARIO

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese la posicion:"
                    );

                    int posicionModificar =
                        vista.pedirOpcion();

                    vista.mostrarMensaje(
                        "Ingrese la nueva capacidad:"
                    );

                    int nuevaCapacidad =
                        vista.pedirOpcion();

                    // Por ahora lo dejamos activo
                    boolean nuevoEstado = true;

                    festival.modificarEscenario(
                        posicionModificar,
                        nuevaCapacidad,
                        nuevoEstado
                    );

                    vista.mostrarMensaje(
                        "Escenario modificado."
                    );

                    break;


                case 6:
                    // RETIRAR ESCENARIO

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese la posicion:"
                    );

                    int posicionRetirar =
                        vista.pedirOpcion();

                    festival.retirarEscenario(
                        posicionRetirar
                    );

                    vista.mostrarMensaje(
                        "Escenario retirado."
                    );

                    break;


                case 7:
                    // REGISTRAR ARTISTA

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    String[] datosArtista =
                        vista.pedirDatosArtista();

                    int codigoArtista =
                        Integer.parseInt(datosArtista[0]);

                    String nombreArtista =
                        datosArtista[1];

                    String genero =
                        datosArtista[2];

                    int duracion =
                        Integer.parseInt(datosArtista[3]);

                    int asistentes =
                        Integer.parseInt(datosArtista[4]);

                    Artista artista = new Artista(
                        codigoArtista,
                        nombreArtista,
                        genero,
                        duracion,
                        asistentes
                    );

                    festival.registrarArtista(artista);

                    vista.mostrarMensaje(
                        "Artista registrado."
                    );

                    break;


                case 8:
                    // CONSULTAR ARTISTAS

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    for (Artista artistaActual :
                            festival.obtenerArtistas()) {

                        vista.mostrarArtista(
                            artistaActual
                        );
                    }

                    break;


                case 9:
                    // BUSCAR ARTISTA

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese el codigo del artista:"
                    );

                    int codigoBuscar =
                        vista.pedirOpcion();

                    Artista artistaEncontrado =
                        festival.buscarArtista(
                            codigoBuscar
                        );

                    vista.mostrarArtista(
                        artistaEncontrado
                    );

                    break;


                case 10:
                    // MODIFICAR ARTISTA

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese el codigo del artista:"
                    );

                    int codigoModificar =
                        vista.pedirOpcion();

                    Artista artistaModificar =
                        festival.buscarArtista(
                            codigoModificar
                        );

                    if (artistaModificar == null) {

                        vista.mostrarMensaje(
                            "Artista no encontrado."
                        );

                        break;
                    }

                    String[] nuevosDatos =
                        vista.pedirDatosArtista();

                    artistaModificar.setNombreArtistico(
                        nuevosDatos[1]
                    );

                    artistaModificar.setGeneroMusical(
                        nuevosDatos[2]
                    );

                    artistaModificar.setDuracion(
                        Integer.parseInt(nuevosDatos[3])
                    );

                    artistaModificar.setCantidadAsistentes(
                        Integer.parseInt(nuevosDatos[4])
                    );

                    vista.mostrarMensaje(
                        "Artista modificado."
                    );

                    break;


                case 11:
                    // CANCELAR PARTICIPACION

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    vista.mostrarMensaje(
                        "Ingrese el codigo del artista:"
                    );

                    int codigoCancelar =
                        vista.pedirOpcion();

                    festival.cancelarArtista(
                        codigoCancelar
                    );

                    vista.mostrarMensaje(
                        "Participacion cancelada."
                    );

                    break;


                case 12:
                    // REPORTE

                    if (festival == null) {
                        vista.mostrarMensaje(
                            "Primero debe crear un festival."
                        );
                        break;
                    }

                    String reporte =
                        "Escenarios configurados: "
                        + festival.cantidadEscenarios()
                        + "\nEspacios disponibles: "
                        + festival.cantidadEspaciosDisponibles()
                        + "\nArtistas registrados: "
                        + festival.cantidadArtistas()
                        + "\nPromedio de duracion: "
                        + festival.promedioDuracion();

                    vista.mostrarReporte(reporte);

                    break;


                case 13:
                    vista.mostrarMensaje(
                        "Saliendo del programa..."
                    );
                    break;


                default:
                    vista.mostrarMensaje(
                        "Opcion no valida."
                    );
            }
        }

        vista.cerrarScanner();
    }
}