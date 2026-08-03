public class Contabilida{
    private float Localidad1=0;
    private float Localidad2=0;
    private float Localidad3=0;

    public void registrarVenta(Localidad localidad, int cantidad){
        if(localidad.getNombre().equals("Localidad 1")){
            Localidad1 = Localidad1+localidad.calcularCosto(cantidad);
        }else {
            if(localidad.getNombre().equals("Localidad 2")){
                Localidad2 = Localidad2+localidad.calcularCosto(cantidad);
            }else {
                if(localidad.getNombre().equals("Localidad 3")){
                    Localidad3 = Localidad3+localidad.calcularCosto(cantidad);
                }
            }
        }
    }

    public float obtenerCajaTotal(String Nombre){
        float caja_total=0;
        caja_total += Localidad1;
        caja_total+= Localidad2;
        caja_total += Localidad3;
        return caja_total;

    }

    public float obtenerCajaLocal(String nombre){
        if(nombre.equals("Localidad 1")) return Localidad1;
        if(nombre.equals("Localidad 2")) return Localidad2;
        if(nombre.equals("Localidad 3")) return Localidad3;
        return 0;
    }
}