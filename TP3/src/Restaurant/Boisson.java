package Restaurant;

    public class Boisson extends Consommable{

    private int volume; // en centilitres

    public Boisson(String nom, int prix, int volume){
	super(nom,  prix);
	this.volume = volume;
    }
	
    public Boisson(String nom, int volume){
	this(nom, 0, volume);
    }
	
    public int getVolume(){
	return volume;
    }
}
