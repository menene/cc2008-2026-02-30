package controlador;

import modelo.Entrenador;
import modelo.Pokemon;
import modelo.ServicioPokeApi;
import vista.VistaConsola;

// Programa principal: sortea los equipos en la PokeAPI y corre el combate.
public class Main {

    public static void main(String[] args) throws Exception {

        VistaConsola vista = new VistaConsola();
        ServicioPokeApi servicio = new ServicioPokeApi();

        vista.mostrarBienvenida();

        boolean seguir = true;

        // El menu se repite hasta que el usuario escoja salir.
        while (seguir) {

            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            if (opcion == 1) {

                Entrenador entrenador1 = null;
                Entrenador entrenador2 = null;
                int jugador = 1;

                // Se arma un equipo por cada uno de los dos jugadores.
                while (jugador <= 2) {

                    vista.mostrarMensaje("");
                    String nombreEntrenador = vista.leerTexto("Nombre del entrenador " + jugador + ":");

                    // Si no escribio nada se le pone un nombre por defecto.
                    if (nombreEntrenador.equals("")) {
                        nombreEntrenador = "Entrenador " + jugador;
                    }

                    vista.mostrarMensaje("Sorteando 4 Pokemon de la PokeAPI para " + nombreEntrenador + "...");

                    Pokemon pokemon1 = null;
                    Pokemon pokemon2 = null;
                    Pokemon pokemon3 = null;
                    Pokemon pokemon4 = null;
                    // Aqui se van guardando los nombres para no repetir Pokemon.
                    String nombresUsados = " ";
                    int cuenta = 1;

                    while (cuenta <= 4) {

                        Pokemon sorteado = servicio.obtenerPokemonAleatorio();

                        if (nombresUsados.contains(" " + sorteado.getNombre() + " ")) {
                            // Ya esta en el equipo, entonces se sortea otro.
                            vista.mostrarMensaje("   (" + sorteado.getNombre() + " ya estaba, se sortea otro)");

                        } else {

                            // Se guarda en el espacio que le toca del equipo.
                            if (cuenta == 1) {
                                pokemon1 = sorteado;
                            } else if (cuenta == 2) {
                                pokemon2 = sorteado;
                            } else if (cuenta == 3) {
                                pokemon3 = sorteado;
                            } else {
                                pokemon4 = sorteado;
                            }

                            nombresUsados = nombresUsados + sorteado.getNombre() + " ";

                            vista.mostrarMensaje("   " + cuenta + ". " + sorteado.getNombre()
                                    + " | tipo " + sorteado.getTipo()
                                    + " | ataque " + sorteado.getAtaque()
                                    + " | defensa " + sorteado.getDefensa()
                                    + " | habilidad " + sorteado.getHabilidad().getNombre()
                                    + " (" + sorteado.getHabilidad().getProbabilidadActivacion() + "%)");

                            cuenta = cuenta + 1;
                        }
                    }

                    if (jugador == 1) {
                        entrenador1 = new Entrenador(nombreEntrenador, pokemon1, pokemon2, pokemon3, pokemon4);
                    } else {
                        entrenador2 = new Entrenador(nombreEntrenador, pokemon1, pokemon2, pokemon3, pokemon4);
                    }

                    jugador = jugador + 1;
                }

                vista.mostrarMensaje("");
                vista.leerTexto("Los equipos estan listos. Presione Enter para empezar el combate:");

                Combate combate = new Combate(entrenador1, entrenador2);
                combate.iniciarCombate();

            } else if (opcion == 2) {

                vista.mostrarMensaje("Gracias por jugar. Hasta la proxima!");
                seguir = false;

            } else {

                vista.mostrarMensaje("Opcion invalida, intente de nuevo.");
            }
        }

        vista.cerrar();
    }
}
