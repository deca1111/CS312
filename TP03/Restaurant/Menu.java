package Restaurant;

import java.util.ArrayList;

public class Menu {
    ArrayList<Consommable> items;
    int prix; // en cents


    public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b) throws Exception{
    	this.prix = prix;
      items = new ArrayList<Consommable>();
      items.add(e);
      items.add(p);
      items.add(d);
      items.add(b);
      if(!verifPrixMenu()){
        throw new Exception("Prix incorrect");
      }

    }

    public ArrayList<Consommable> getItems(){
	return this.items;
    }

    public int getPrix(){
	return this.prix;
    }

    public String toString(){
	     String message = "Menu composé de ";
       for(Consommable it : items){
         message += it.getNom() + ", ";
       }
			 message += "au Prix de " + this.prix + " euros";
	     return message;
    }

    private boolean verifPrixMenu(){
      int sum = 0;
			//on fait la somme des prix des items
      for(Consommable it : items){
        sum += it.getPrix();
      }
			//on renvoie vrai si le prix des items est superieur au prix du menu
			//et si le prix du menu est strictement positif
      return(prix>0 && prix<=sum);
    }
    public int getKcal() {
    	int result = 0;
    	for(Consommable a : items) {
    		result += a.getKcal();
    	}
    	return result;
    }
}
