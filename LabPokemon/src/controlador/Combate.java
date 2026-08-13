package controlador;

import modelo.Entrenador;
import modelo.Pokemon;

import java.util.Random;

// Controla el combate de 4 rondas entre los dos entrenadores.
public class Combate {

    private Entrenador jugador1;
    private Entrenador jugador2;
    private int numeroRondas;
    private Random aleatorio;

    public Combate(Entrenador jugador1, Entrenador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.numeroRondas = 4;
        this.aleatorio = new Random();
    }

    // Empieza las 4 rondas. Ataca el jugador 1 en las impares y el jugador 2 en las pares.
    public void iniciarCombate() {
        System.out.println("");
        System.out.println("=============================================");
        System.out.println("           EMPIEZA EL COMBATE                ");
        System.out.println("=============================================");
        System.out.println(jugador1.getNombre() + "  VS  " + jugador2.getNombre());

        boolean atacaJugador1 = true;
        int ronda = 1;

        while (ronda <= numeroRondas) {

            if (atacaJugador1) {
                jugarRonda(ronda, jugador1, jugador2);
            } else {
                jugarRonda(ronda, jugador2, jugador1);
            }

            
            atacaJugador1 = !atacaJugador1;
            ronda = ronda + 1;
        }

        mostrarResultadoFinal();
    }

    // Juega una ronda y le suma el punto al que gane.
    private void jugarRonda(int numeroRonda, Entrenador atacante, Entrenador defensor) {
        // Cada entrenador saca al azar un Pokemon que no haya peleado.
        Pokemon pokemonAtacante = atacante.seleccionarPokemonAleatorio(aleatorio);
        Pokemon pokemonDefensor = defensor.seleccionarPokemonAleatorio(aleatorio);

        System.out.println("");
        System.out.println("---------------- RONDA " + numeroRonda + " ----------------");
        System.out.println("Ataca:   " + atacante.getNombre() + " con " + pokemonAtacante.getNombre()
                + " (" + pokemonAtacante.getTipo() + ", ataque " + pokemonAtacante.getAtaque() + ")");
        System.out.println("Defiende: " + defensor.getNombre() + " con " + pokemonDefensor.getNombre()
                + " (" + pokemonDefensor.getTipo() + ", defensa " + pokemonDefensor.getDefensa() + ")");

        // El atacante intenta activar su habilidad para subir su ataque.
        int porcentajeAtacante = 0;
        if (pokemonAtacante.getHabilidad().intentarActivar(aleatorio)) {
            porcentajeAtacante = pokemonAtacante.getHabilidad().calcularPotenciador(aleatorio);
            System.out.println("  Se activo " + pokemonAtacante.getHabilidad().getNombre()
                    + " del atacante: +" + porcentajeAtacante + "% de ataque");
        } else {
            System.out.println("  La habilidad del atacante no se activo");
        }

        // El defensor hace su propio intento para subir su defensa.
        int porcentajeDefensor = 0;
        if (pokemonDefensor.getHabilidad().intentarActivar(aleatorio)) {
            porcentajeDefensor = pokemonDefensor.getHabilidad().calcularPotenciador(aleatorio);
            System.out.println("  Se activo " + pokemonDefensor.getHabilidad().getNombre()
                    + " del defensor: +" + porcentajeDefensor + "% de defensa");
        } else {
            System.out.println("  La habilidad del defensor no se activo");
        }

        int ataqueEfectivo = pokemonAtacante.calcularAtaqueEfectivo(porcentajeAtacante);
        int defensaEfectiva = pokemonDefensor.calcularDefensaEfectiva(porcentajeDefensor);
        int bonoTipo = calcularBonoTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());
        int ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        System.out.println("  Ataque efectivo: " + ataqueEfectivo);
        System.out.println("  Bono de tipo:    " + bonoTipo);
        System.out.println("  Defensa efectiva: " + defensaEfectiva);
        System.out.println("  Ataque total: " + ataqueEfectivo + " + (" + bonoTipo + ") - "
                + defensaEfectiva + " = " + ataqueTotal);

        // Si el ataque quedo arriba de cero gana el atacante, si no gana el defensor.
        if (ataqueTotal > 0) {
            atacante.sumarRondaGanada();
            System.out.println("  Gana la ronda " + atacante.getNombre() + " (el ataque paso la defensa)");
        } else if (ataqueTotal < 0) {
            defensor.sumarRondaGanada();
            System.out.println("  Gana la ronda " + defensor.getNombre() + " (resistio el ataque)");
        } else {
            System.out.println("  La ronda queda empatada");
        }
    }

    // Da +20 si el tipo tiene ventaja, -10 si tiene desventaja y 0 si es neutral.
    private int calcularBonoTipo(String tipoAtacante, String tipoDefensor) {
        int bono = 0;

        if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Planta")) {
                bono = 20;
            } else if (tipoDefensor.equals("Agua")) {
                bono = -10;
            }
        } else if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) {
                bono = 20;
            } else if (tipoDefensor.equals("Planta")) {
                bono = -10;
            }
        } else if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Agua")) {
                bono = 20;
            } else if (tipoDefensor.equals("Fuego")) {
                bono = -10;
            }
        } else if (tipoAtacante.equals("Electrico")) {
            if (tipoDefensor.equals("Agua")) {
                bono = 20;
            }
        }

        return bono;
    }

    // Muestra el marcador y dice quien es el campeon.
    private void mostrarResultadoFinal() {
        System.out.println("");
        System.out.println("=============================================");
        System.out.println("             RESULTADO FINAL                 ");
        System.out.println("=============================================");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getRondasGanadas() + " rondas ganadas");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getRondasGanadas() + " rondas ganadas");

        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {
            System.out.println("CAMPEON DE LA LIGA ELEMENTAL: " + jugador1.getNombre());
        } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {
            System.out.println("CAMPEON DE LA LIGA ELEMENTAL: " + jugador2.getNombre());
        } else {
            // Si quedaron 2 a 2 no hay campeon.
            System.out.println("La batalla termina EMPATADA, no hay campeon");
        }
        System.out.println("=============================================");
    }
}
