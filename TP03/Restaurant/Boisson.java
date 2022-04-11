package Restaurant;


public class Boisson implements Consommable, Nutrition{

    private int volume; // en centilitres
    private String nom;
    private int prix;
    private int kcal;
    private float glucides;

    public Boisson(String nom, int prix, int volume, int kcal, float glucides) {
    	this.nom = nom;
    	this.prix = prix;
    	this.volume = volume;
    	this.kcal = kcal;
    	this.glucides = glucides;
    }

    public Boisson(String nom, int volume){
	     this(nom, 0, volume, 0, 0);
    }

    public int getVolume(){
	     return volume;
    }
    public int getPrix(){
      return prix;
    }
    public String getNom(){
      return nom;
    }
    public float getGlucides() {
    	return this.glucides;
    }
    public int getKcal() {
    	return this.kcal;
    }
}
