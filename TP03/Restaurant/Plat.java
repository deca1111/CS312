package Restaurant;


public class Plat implements Consommable, Nutrition{
  public String nom;
  public int prix;
  private int kcal;
  private float glucides;

    public Plat(String nom, int prix, int kcal, float glucides){
	     this.nom = nom;
	     this.prix = prix;
	     this.kcal = kcal;
	     this.glucides = glucides;
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
