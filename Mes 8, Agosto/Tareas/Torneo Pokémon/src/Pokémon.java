import java.util.Random;
public class Pokémon{
    private String name;
    private String type;
    private int ATK;
    private int DEF;
    private EA especialAbility;
    public Pokémon (String name){ 
        this.name = name; 
        this.type = setType();
        this.especialAbility=new EA();
        setAttributes();
    }
    private String setType(){
        String[] types = new String[]{"Agua", "Fuego", "Planta", "Eléctrico"};
        Random r = new Random();
        return types[r.nextInt(types.length)];
    }
    private void setAttributes(){
        Random r = new Random();
        this.ATK = r.nextInt(41)+30;
        this.DEF = r.nextInt(41)+30;
    }
    public String getName(){ return this.name; }
    public String getType(){ return this.type; }
    public int getATK(){ return this.ATK; }
    public int getDEF(){ return this.DEF; }
    public EA getEspecialAbility(){ return this.especialAbility; }
}