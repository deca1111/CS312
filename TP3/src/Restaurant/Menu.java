package Restaurant;

import java.util.ArrayList;

public class Menu {
    ArrayList<Consommable> items;
    int prix; // en cents

    
    public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b){ 
	//TODO : completer (question3 + question 5)
    }
	
    public ArrayList<Consommable> getItems(){
	return this.items;
    }
	
    public int getPrix(){
	return this.prix;
    }

    public String toString(){
	String message = "Menu compose de ";
	//TODO implem (Question 4)
	return message;
    }

    //TODO IMPLEM verifPrixMenu (Question5)
}
