import java.util.Random;
public class EA{
    private String name;
    private double prob;
    public EA(){
        this.name = setName();
        this.prob = setProb();
    }
    private double setProb(){
        Random r = new Random();
        return (r.nextInt(36)+15);
    }
    private String setName(){
        String[] first = {
            "Tormenta",
            "Impacto",
            "Tormenta",
            "Golpe",
            "Escudo",
            "Furia",
            "Pulso",
            "Aura",
            "Rayo",
            "Carga",
            "Explosión",
            "Onda",
            "Poder",
            "Ataque",
            "Energía",
            "Fuerza"
        };

        String[] second = {
            "Final",
            "Natural",
            "Elemental",
            "Supremo",
            "Salvaje",
            "Místico",
            "Brutal",
            "Celestial",
            "Arcano",
            "Ancestral",
            "Devastador",
            "Eterno",
            "Radiante",
            "Veloz",
            "Imparable"
        };
        Random r = new Random();
        return first[r.nextInt(first.length)]+" "+second[r.nextInt(second.length)]; 
    }
    public String getName(){ return this.name; }
    public double getProb(){ return this.prob; }
}