import java.util.ArrayList;

public class CrudController {
    private VistaCrud vistaCrud;
    

    public boolean configurarEscenario(Festival festival, int posicion, Escenario escenario){
        Escenario[] escenarios = festival.getEscenarios();
        if(posicion <0||posicion >= escenarios.length+1){
            System.out.println("Escenario excede la lista");
            return false; 
        }
        if(escenarios[posicion] != null){
            System.out.println("La posicion" + posicion + "Eta ocupada");
            return false; 
        }
        escenarios[posicion] = escenario;
        System.out.println("Escenario configurado con exito en la posicion " + posicion + ".");
        return true;

    }

    public void consultarEscenarios(Festival festival) {
        Escenario[] escenarios = festival.getEscenarios();
        boolean hayEscenarios = false;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                System.out.println("\n Posicion " + i );
                vistaCrud.mostrarEscenario(escenarios[i]);
                hayEscenarios = true;
            }
        }

        if (!hayEscenarios) {
            System.out.println("No hay sistemas");
        }
    }

    public void consultarUnEscenario(Festival festival, int posicion){
        Escenario[] escenarios = festival.getEscenarios();
        if (posicion <0||posicion >= escenarios.length+1){
            System.out.println("La posicion no existe");
            return;
        }

        if (escenarios[posicion] == null){
            System.out.println("La posicion esta vacia ");
        }else{
            System.out.println("Escenario "+posicion);
            vistaCrud.mostrarEscenario(escenarios[posicion]);
        }
    }

    public boolean modificarEscenario(Festival festival, int posicion, int nuevaCapacidad, String nuevoEstado) {
        Escenario[] escenarios = festival.getEscenarios();

        if (posicion < 0 || posicion >= escenarios.length) {
            System.out.println("posicion fuera de rango ");
            return false;
        }

        if (escenarios[posicion] == null) {
            System.out.println("posicion vacia.");
            return false;
        }

        try {
            escenarios[posicion].setCapacidad(nuevaCapacidad); // Valida capacidad > 0
            escenarios[posicion].setEstado(nuevoEstado);
            System.out.println("Escenao modificado.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Esta mal en algo" + e.getMessage()+"En algo ");
            return false;
        }
    }

    public boolean retirarEscenario(Festival festival, int posicion){
        Escenario[] escenarios = festival.getEscenarios();

        if (posicion < 0 || posicion >= escenarios.length) {
            System.out.println("posicion inexistente.");
            return false;
        }

        if (escenarios[posicion] == null) {
            System.out.println("posicion vacia");
            return false;
        }

        escenarios[posicion] = null;
        System.out.println("La posicion " + posicion + " ha sido retirada con exito ");
        return true;
    }

    public boolean registrarArtista(Festival festival, Artista artista) {
        ArrayList<Artista> artistas = festival.getArtistas();

        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(artista.getCodigo())) {
                System.out.println("Ya existe un artista con ese codigo " + artista.getCodigo());
                return false;
            }
        }

        artistas.add(artista);
        System.out.println("Artista registrado");
        return true;
    }

    public void consultarArtistas(Festival festival) {
        ArrayList<Artista> artistas = festival.getArtistas();

        if (artistas.isEmpty()) {
            System.out.println("Sin artistas");
            return;
        }

        for (int i = 0; i < artistas.size(); i++) {
            System.out.println("\n Artista " + (i + 1));
            vistaCrud.mostrarArtista(artistas.get(i));
        }
    }

    public Artista buscarArtista (Festival festival, String codigo){
        ArrayList<Artista> artistas = festival.getArtistas();
        for (int i =0; i < artistas.size(); i++){
            Artista a = artistas.get(i);
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }

    public boolean modificarArtista(Festival festival, String codigo, String nuevoNombre, String nuevoGenero, int nuevaDuracion, int nuevosAsistentes) {
        Artista artista = buscarArtista(festival, codigo);

        if (artista == null) {
            System.out.println("COdigo inexistente: " + codigo);
            return false;
        }

        try {
            artista.setNombre(nuevoNombre);
            artista.setGeneroMusical(nuevoGenero);
            artista.setDuracion(nuevaDuracion);
            artista.setAsistentes(nuevosAsistentes);
            System.out.println("Actualizacion realizada");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Esta mal en algo " + e.getMessage()+"En algo ");
            return false;
        }
    }

    public boolean cancelarParticipacion(Festival festival, String codigo){
        ArrayList<Artista> artistas = festival.getArtistas();
        for (int i = 0; i < artistas.size(); i++){
            artistas.remove(i);
            System.out.println("Participacion cancelada");
            return true; 
        }
        System.out.println("El artista no existe");
        return false; 
    }
    public VistaCrud getVistaCrud(){
        return vistaCrud;
    }

    

}
