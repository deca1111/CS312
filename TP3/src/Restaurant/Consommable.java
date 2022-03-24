package Restaurant;

public class Consommable {

    private String nom;
    private int prix; // en cents d'euros
	
    public Consommable(String nom, int prix){
	this.nom = nom;
	this.prix = prix;
    }

    public String getNom(){
	return this.nom;
    }
	
    public int getPrix(){
	return this.prix;
    }
}
