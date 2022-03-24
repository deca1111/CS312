package Restaurant;

public class Plat implements Consommable{
	private String nom;
	private int prix;

  public Plat(String nom, int prix){
		this.nom = nom;
		this.prix = prix;
  }

	public String getNom(){
		return nom;
	}

	public int getPrix(){
		return prix;
	}

}
