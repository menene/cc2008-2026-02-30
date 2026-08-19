public class Entrenador {
    private boolean rol;
    private Pokemon p1, p2, p3, p4;

    public void cambiarRol() {
        this.rol = !this.rol;
    }

    public Pokemon obtenerPokemonAleatorio() {
        int aleatorio;
        while(true) {
            // Verificación para no caer en un bucle infinito
            if ((p1 == null || p1.isYaPeleo()) && (p2 == null || p2.isYaPeleo()) && 
                (p3 == null || p3.isYaPeleo()) && (p4 == null || p4.isYaPeleo())) {
                return null;
            }

            aleatorio = (int)(Math.random() * 4) + 1; // Número del 1 al 4
            if(aleatorio == 1 && p1 != null && !p1.isYaPeleo()) return p1;
            if(aleatorio == 2 && p2 != null && !p2.isYaPeleo()) return p2;
            if(aleatorio == 3 && p3 != null && !p3.isYaPeleo()) return p3;
            if(aleatorio == 4 && p4 != null && !p4.isYaPeleo()) return p4;
        }
    }

    public boolean getRol() { return rol; }
    public void setRol(boolean rol) { this.rol = rol; }
    public Pokemon getP1() { return p1; }
    public void setP1(Pokemon p1) { this.p1 = p1; }
    public Pokemon getP2() { return p2; }
    public void setP2(Pokemon p2) { this.p2 = p2; }
    public Pokemon getP3() { return p3; }
    public void setP3(Pokemon p3) { this.p3 = p3; }
    public Pokemon getP4() { return p4; }
    public void setP4(Pokemon p4) { this.p4 = p4; }
}