package modelo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

// Se conecta a la PokeAPI y con los datos que trae arma objetos Pokemon.
public class ServicioPokeApi {

    private static final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";

    private HttpClient cliente;
    private Random aleatorio;

    public ServicioPokeApi() {
        this.cliente = HttpClient.newHttpClient();
        this.aleatorio = new Random();
    }

    // Sortea Pokemon hasta que salga uno de tipo Fuego, Agua, Planta o Electrico.
    public Pokemon obtenerPokemonAleatorio() throws Exception {
        Pokemon sorteado = null;

        while (sorteado == null) {
            // Los Pokemon de la primera generacion van del numero 1 al 151.
            int numero = 1 + aleatorio.nextInt(151);
            sorteado = obtenerPokemon("" + numero);
        }

        return sorteado;
    }

    // Busca un Pokemon en la PokeAPI por nombre o por numero y lo devuelve armado.
    public Pokemon obtenerPokemon(String busqueda) throws Exception {
        String respuesta = enviarPeticion(busqueda);

        String nombre = extraerNombre(respuesta, "\"forms\"");
        String tipoIngles = extraerNombre(respuesta, "\"types\"");
        String tipo = "";

        // La PokeAPI da los tipos en ingles y hay que traducirlos.
        if (tipoIngles.equals("fire")) {
            tipo = "Fuego";
        } else if (tipoIngles.equals("water")) {
            tipo = "Agua";
        } else if (tipoIngles.equals("grass")) {
            tipo = "Planta";
        } else if (tipoIngles.equals("electric")) {
            tipo = "Electrico";
        } else {
            // La Liga Elemental solo acepta esos cuatro tipos.
            return null;
        }

        int ataque = extraerEstadistica(respuesta, "attack");
        int defensa = extraerEstadistica(respuesta, "defense");
        HabilidadEspecial habilidad = generarHabilidad();

        return new Pokemon(nombre, tipo, ataque, defensa, habilidad);
    }

    // Le pide los datos al servidor y devuelve el texto JSON que responde.
    private String enviarPeticion(String busqueda) throws Exception {
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + busqueda))
                .build();
        HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

        return respuesta.body();
    }

    // Busca una seccion del JSON y devuelve el primer nombre que aparece ahi.
    private String extraerNombre(String respuesta, String seccion) {
        int inicioSeccion = respuesta.indexOf(seccion);
        // El 8 es el largo del texto "name":" que va antes del dato.
        int inicio = respuesta.indexOf("\"name\":\"", inicioSeccion) + 8;
        int fin = respuesta.indexOf("\"", inicio);

        return respuesta.substring(inicio, fin);
    }

    // Busca en el JSON el ataque o la defensa y devuelve su numero.
    private int extraerEstadistica(String respuesta, String estadistica) {
        int posicionNombre = respuesta.indexOf("\"name\":\"" + estadistica + "\"");
        // El valor viene antes del nombre, entonces se busca hacia atras.
        int posicionValor = respuesta.lastIndexOf("\"base_stat\":", posicionNombre);
        // El 12 es el largo del texto "base_stat": que va antes del numero.
        int inicio = posicionValor + 12;
        int fin = respuesta.indexOf(",", inicio);

        return Integer.parseInt(respuesta.substring(inicio, fin));
    }

    // Le da al Pokemon una de las tres habilidades de la Liga Elemental.
    private HabilidadEspecial generarHabilidad() {
        int sorteo = aleatorio.nextInt(3);

        if (sorteo == 0) {
            return new HabilidadEspecial("Llama Final", 30);
        } else if (sorteo == 1) {
            return new HabilidadEspecial("Escudo Natural", 40);
        } else {
            return new HabilidadEspecial("Impacto Relampago", 20);
        }
    }
}
