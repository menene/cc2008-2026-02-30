package Model;

import java.util.Random;

public class Pokedex {

    private Pokemon[] pokemonesDisponibles;

    public Pokedex() {

        pokemonesDisponibles = new Pokemon[50];

        HabilidadEspecial llamaFinal =
                new HabilidadEspecial("Llama Final", 30);

        HabilidadEspecial escudoNatural =
                new HabilidadEspecial("Escudo Natural", 40);

        HabilidadEspecial impactoRelampago =
                new HabilidadEspecial("Impacto Relampago", 20);

        pokemonesDisponibles[0] =
                new Pokemon("Charmander", "Fuego", 52, 43, llamaFinal);

        pokemonesDisponibles[1] =
                new Pokemon("Charmeleon", "Fuego", 64, 58, llamaFinal);

        pokemonesDisponibles[2] =
                new Pokemon("Charizard", "Fuego", 84, 78, llamaFinal);

        pokemonesDisponibles[3] =
                new Pokemon("Vulpix", "Fuego", 41, 40, llamaFinal);

        pokemonesDisponibles[4] =
                new Pokemon("Ninetales", "Fuego", 76, 75, llamaFinal);

        pokemonesDisponibles[5] =
                new Pokemon("Growlithe", "Fuego", 70, 45, llamaFinal);

        pokemonesDisponibles[6] =
                new Pokemon("Arcanine", "Fuego", 90, 80, llamaFinal);

        pokemonesDisponibles[7] =
                new Pokemon("Ponyta", "Fuego", 85, 55, llamaFinal);

        pokemonesDisponibles[8] =
                new Pokemon("Rapidash", "Fuego", 90, 70, llamaFinal);

        pokemonesDisponibles[9] =
                new Pokemon("Magmar", "Fuego", 75, 57, llamaFinal);

        pokemonesDisponibles[10] =
                new Pokemon("Flareon", "Fuego", 95, 60, llamaFinal);

        pokemonesDisponibles[11] =
                new Pokemon("Cyndaquil", "Fuego", 52, 43, llamaFinal);

        pokemonesDisponibles[12] =
                new Pokemon("Torchic", "Fuego", 60, 40, llamaFinal);


        pokemonesDisponibles[13] =
                new Pokemon("Squirtle", "Agua", 48, 65, escudoNatural);

        pokemonesDisponibles[14] =
                new Pokemon("Wartortle", "Agua", 63, 80, escudoNatural);

        pokemonesDisponibles[15] =
                new Pokemon("Blastoise", "Agua", 83, 90, escudoNatural);

        pokemonesDisponibles[16] =
                new Pokemon("Psyduck", "Agua", 52, 48, escudoNatural);

        pokemonesDisponibles[17] =
                new Pokemon("Golduck", "Agua", 82, 78, escudoNatural);

        pokemonesDisponibles[18] =
                new Pokemon("Poliwag", "Agua", 50, 40, escudoNatural);

        pokemonesDisponibles[19] =
                new Pokemon("Poliwhirl", "Agua", 65, 65, escudoNatural);

        pokemonesDisponibles[20] =
                new Pokemon("Tentacool", "Agua", 40, 55, escudoNatural);

        pokemonesDisponibles[21] =
                new Pokemon("Tentacruel", "Agua", 70, 65, escudoNatural);

        pokemonesDisponibles[22] =
                new Pokemon("Seel", "Agua", 45, 55, escudoNatural);

        pokemonesDisponibles[23] =
                new Pokemon("Krabby", "Agua", 85, 90, escudoNatural);

        pokemonesDisponibles[24] =
                new Pokemon("Horsea", "Agua", 40, 70, escudoNatural);

        pokemonesDisponibles[25] =
                new Pokemon("Totodile", "Agua", 65, 64, escudoNatural);


        pokemonesDisponibles[26] =
                new Pokemon("Bulbasaur", "Planta", 49, 49, escudoNatural);

        pokemonesDisponibles[27] =
                new Pokemon("Ivysaur", "Planta", 62, 63, escudoNatural);

        pokemonesDisponibles[28] =
                new Pokemon("Venusaur", "Planta", 82, 83, escudoNatural);

        pokemonesDisponibles[29] =
                new Pokemon("Oddish", "Planta", 50, 55, escudoNatural);

        pokemonesDisponibles[30] =
                new Pokemon("Gloom", "Planta", 65, 70, escudoNatural);

        pokemonesDisponibles[31] =
                new Pokemon("Vileplume", "Planta", 80, 85, escudoNatural);

        pokemonesDisponibles[32] =
                new Pokemon("Bellsprout", "Planta", 75, 35, escudoNatural);

        pokemonesDisponibles[33] =
                new Pokemon("Weepinbell", "Planta", 90, 50, escudoNatural);

        pokemonesDisponibles[34] =
                new Pokemon("Exeggcute", "Planta", 40, 80, escudoNatural);

        pokemonesDisponibles[35] =
                new Pokemon("Tangela", "Planta", 55, 90, escudoNatural);

        pokemonesDisponibles[36] =
                new Pokemon("Chikorita", "Planta", 49, 65, escudoNatural);

        pokemonesDisponibles[37] =
                new Pokemon("Treecko", "Planta", 45, 35, escudoNatural);


        pokemonesDisponibles[38] =
                new Pokemon("Pikachu", "Electrico", 55, 40, impactoRelampago);

        pokemonesDisponibles[39] =
                new Pokemon("Raichu", "Electrico", 90, 55, impactoRelampago);

        pokemonesDisponibles[40] =
                new Pokemon("Magnemite", "Electrico", 35, 70, impactoRelampago);

        pokemonesDisponibles[41] =
                new Pokemon("Magneton", "Electrico", 60, 95, impactoRelampago);

        pokemonesDisponibles[42] =
                new Pokemon("Voltorb", "Electrico", 30, 50, impactoRelampago);

        pokemonesDisponibles[43] =
                new Pokemon("Electrode", "Electrico", 50, 70, impactoRelampago);

        pokemonesDisponibles[44] =
                new Pokemon("Electabuzz", "Electrico", 83, 57, impactoRelampago);

        pokemonesDisponibles[45] =
                new Pokemon("Jolteon", "Electrico", 65, 60, impactoRelampago);

        pokemonesDisponibles[46] =
                new Pokemon("Mareep", "Electrico", 40, 40, impactoRelampago);

        pokemonesDisponibles[47] =
                new Pokemon("Flaaffy", "Electrico", 55, 55, impactoRelampago);

        pokemonesDisponibles[48] =
                new Pokemon("Ampharos", "Electrico", 75, 85, impactoRelampago);

        pokemonesDisponibles[49] =
                new Pokemon("Shinx", "Electrico", 65, 34, impactoRelampago);
    }

    public Pokemon[] seleccionarPokemonesAleatorios(int cantidad) {

        Random random = new Random();
        Pokemon[] seleccionados = new Pokemon[cantidad];

        int encontrados = 0;

        while (encontrados < cantidad) {

            int indice =
                    random.nextInt(pokemonesDisponibles.length);

            Pokemon candidato =
                    pokemonesDisponibles[indice];

            boolean repetido = false;

            for (int i = 0; i < encontrados; i++) {
                if (seleccionados[i] == candidato) {
                    repetido = true;
                }
            }

            if (!repetido) {
                seleccionados[encontrados] = candidato;
                encontrados++;
            }
        }

        return seleccionados;
    }

    public Pokemon[] getPokemonesDisponibles() {
        return pokemonesDisponibles;
    }
}