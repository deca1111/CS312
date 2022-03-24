package Restaurant;

import java.util.ArrayList;

public class Menu {
	ArrayList<Consommable> items;
  int prix; // en cents


  public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b){
		this.prix = prix;
		items = new ArrayList<Consommable>();
		items.add(e);
		items.add(p);
		items.add(d);
		items.add(b);
		if(!verifPrixMenu()){
			throw new Exception("Menu trop cher");
		}
  }

  public ArrayList<Consommable> getItems(){
		return this.items;
	}

  public int getPrix(){
		return this.prix;
  }

  public String toString(){

		String message = "Menu compose de ";
		for(Consommable c : items){
			message += c.getNom() +", ";
		}
		message += "au prix de " + prix + "€.";
		return message;
  }

  private boolean verifPrixMenu(){
		int prix_cumul = 0;
		for(Consommable c : items){
			prix_cumul += c.getPrix();
		}
		return (prix_cumul >= prix);
	}
}
