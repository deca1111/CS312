package Restaurant;

import java.util.ArrayList;
import java.util.*;

public class Commande {
    private ArrayList<Consommable> itemsCommandes;
	
    public Commande() {
	this.itemsCommandes = new ArrayList<Consommable>();
    }
	
    public void addItem(Consommable c){
	this.itemsCommandes.add(c);
    }
	public void addList(ArrayList<Consommable> list) {
		for(Consommable c : list) {
			addItem(c);
			
		}
	}
	public boolean isThereMenu(Menu menu) {
		boolean result = true;
		boolean is_in_commande;
		for(Consommable a : menu.getItems()) {
			is_in_commande = false;
			for(Consommable b : itemsCommandes) {
				if(a.getNom().equals(b.getNom())) {
					is_in_commande = true;
				}
			}
			if(!is_in_commande){
				result = false;
			}
		}
		return result;
	}
	public void removeMenu(Menu menu) {
		for(Consommable a : menu.getItems()) {
			itemsCommandes.remove(a);
		}
	}
    public ArrayList<Consommable> getItemsCommands(){
	return this.itemsCommandes;
    }
    
}
