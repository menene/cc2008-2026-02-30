package pokemonbattle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * EJEMPLO OPCIONAL (no forma parte del programa principal).
 *
 * Muestra cómo se podría consultar PokeAPI (https://pokeapi.co) para traer
 * datos reales de un Pokémon en vez de usar los valores fijos de
 * PokemonService. PokeAPI es gratuita y no requiere llave de acceso.
 *
 * Endpoint: https://pokeapi.co/api/v2/pokemon/{nombre-o-id}
 * Ejemplo:  https://pokeapi.co/api/v2/pokemon/pikachu
 *
 * La respuesta es un JSON grande; los campos relevantes para este lab son:
 *   - "types"  -> lista de tipos (en inglés: fire, water, grass, electric...)
 *   - "stats"  -> lista de estadísticas, entre ellas "attack" y "defense"
 *
 * Como PokeAPI usa el sistema de tipos completo de Pokémon (18 tipos) y
 * este laboratorio solo pide 4 (Fuego, Agua, Planta, Eléctrico), hay que
 * filtrar o mapear los tipos que no apliquen (ignorar ese Pokémon o
 * asignarle el tipo más parecido).
 *
 * NOTA: este archivo requiere una librería para parsear JSON (por ejemplo
 * org.json o Gson) ya que Java no trae un parser de JSON incluido. Aquí se
 * muestra solo la parte de la petición HTTP; el parseo se deja simplificado.
 */
public class PokeApiEjemplo {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    /**
     * Descarga el JSON crudo de un Pokémon por nombre (en inglés y minúsculas).
     * Ej: obtenerJsonPokemon("pikachu")
     */
    public static String obtenerJsonPokemon(String nombrePokemon) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + nombrePokemon.toLowerCase()))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Ejemplo de mapeo de tipo en inglés (PokeAPI) a TipoPokemon del lab.
    // Devuelve null si el tipo no es uno de los 4 soportados.
    public static TipoPokemon mapearTipo(String tipoIngles) {
        switch (tipoIngles.toLowerCase()) {
            case "fire": return TipoPokemon.FUEGO;
            case "water": return TipoPokemon.AGUA;
            case "grass": return TipoPokemon.PLANTA;
            case "electric": return TipoPokemon.ELECTRICO;
            default: return null; // tipo no soportado por este lab
        }
    }

    public static void main(String[] args) throws Exception {
        String json = obtenerJsonPokemon("pikachu");
        System.out.println(json.substring(0, Math.min(500, json.length())) + "...");
        // Aquí se usaría una librería JSON (org.json, Gson, Jackson) para
        // extraer "attack", "defense" y "types" y construir un objeto Pokemon.
    }
}
