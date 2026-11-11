package arenagt.dominio;

public final class Equipo implements Comparable<Equipo> {
    private final String codigo;
    private final String nombre;
    private final String empresa;
    private int puntosTabla;

    Equipo(String codigo, String nombre, String empresa) {
        this.codigo = Texto.requerido(codigo, "código");
        this.nombre = Texto.requerido(nombre, "nombre");
        this.empresa = Texto.requerido(empresa, "empresa");
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getEmpresa() { return empresa; }
    public int getPuntosTabla() { return puntosTabla; }
    void acumular(int puntos) { puntosTabla += puntos; }

    @Override
    public int compareTo(Equipo otro) {
        int orden = Integer.compare(otro.puntosTabla, puntosTabla);
        return orden == 0 ? nombre.compareTo(otro.nombre) : orden;
    }
}
