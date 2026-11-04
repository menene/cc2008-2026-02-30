import java.util.ArrayList;

public interface Auditable {

    void registrarEvento(String evento);

    ArrayList<String> getBitacora();
}
