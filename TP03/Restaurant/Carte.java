package Restaurant;

import java.util.ArrayList;
import java.util.*;

public class Carte{
    private ArrayList<Consommable> entrees;
    private ArrayList<Consommable> platsPrincipaux;
    private ArrayList<Consommable> desserts;
    private ArrayList<Consommable> boissons;

    private ArrayList<Menu> menus;

    public Carte() {
	entrees = new ArrayList<Consommable>();
	platsPrincipaux = new ArrayList<Consommable>();
	desserts = new ArrayList<Consommable>();
	boissons = new ArrayList<Consommable>();
	menus = new ArrayList<Menu>();
    }

    public void addEntree(Entree e){
	if (verifCarte(e)) this.entrees.add(e);
    }

    public void addPlatPrincipal(PlatPrincipal p){
	if (verifCarte(p)) this.platsPrincipaux.add(p);
    }

    public void addDessert(Dessert d){
	if (verifCarte(d)) this.desserts.add(d);
    }

    public void addBoisson(Boisson b){
	if (verifCarte(b)) this.boissons.add(b);
    }

    public void addMenu(Menu m){
	//TODO call to verifMenu
	this.menus.add(m);
    }

    public ArrayList<Consommable> getEntrees(){
	return this.entrees;
    }

    public ArrayList<Consommable> getPlatsPrincipaux(){
	return this.platsPrincipaux;
    }

    public ArrayList<Consommable> getDesserts(){
	return this.desserts;
    }

    public ArrayList<Consommable> getBoissons(){
	return this.boissons;
    }


  	private boolean verifCarte(Consommable c){
			//on creer un iterateur de type Consommable
			Iterator<Consommable> iter;
			//on iter d'abbord sur les entrees
			iter = entrees.iterator();
			//on fait notre boucle tant que l'iterateur a un suivant
			while(iter.hasNext()){
				//on recupere le nom du Consommable pointe par l'iterateur
				//et on test sa valeur avec la valeur de notre Consommable avec la methode
				//equals
				if(iter.next().getNom().equals(c.getNom())){
					System.out.println("Element deja dans la carte");
					return false;
				}
			}
			//puis sur les desserts
			iter = desserts.iterator();
			while(iter.hasNext()){
				if(iter.next().getNom().equals(c.getNom())){
					System.out.println("Element deja dans la carte");
					return false;
				}
			}
			//les plats principaux
			iter = platsPrincipaux.iterator();
			while(iter.hasNext()){
				if(iter.next().getNom().equals(c.getNom())){
					System.out.println("Element deja dans la carte");
					return false;
				}
			}
			//et enfin les boissons
			iter = boissons.iterator();
			while(iter.hasNext()){
				if(iter.next().getNom().equals(c.getNom())){
					System.out.println("Element deja dans la carte");
					return false;
				}
			}

      return true;
    }

    // Vérifie que les plats et boissons du menu sont bien dans la carte
    // TODO Question 7 : réaliser verifMenu


    /* Calcule le prix de la commande. A priori, ce prix est la somme des prix des items
     * SAUF si une partie de ces items constituent un menu; dans ce cas, le tarif menu s'applique pour ces items.
     */
    // TODO Question 8 - calculerPrixCommande
    public int caclulerPrixCommade(Commande c) {
    	int prix = 0;
			//stock si c'est la fin des menus
    	boolean fin = false;
			//stock si il y a eu des menus durant la derniere boucle
    	boolean is_there_menu;
			//commande temporaire pour ne pas detruire celle en entree
    	Commande commande = new Commande();
			//methode addList permet d'ajouter une liste d'items a une commande
    	commande.addList(c.getItemsCommands());
			/*tant qu'on a des menus on verifie pour chaque menu si il est dans la
			commande*/
    	while(!fin) {
    		is_there_menu = false;
    		for(Menu m : menus) {
					/*on a implemente une methode isThereMenu dans la classe commande
					pour savoir si une commande contient un menu passe en parametre*/
    			if(commande.isThereMenu(m)) {
						/*on a implemente une methode removeMenu dans la classe commande
						pour supprimer de la commande une fois chque item d'un menu*/
    				commande.removeMenu(m);
    				prix += m.getPrix();
    				is_there_menu = true;
    			}
    		}
				/*on fait la boucle tant qu'on a eu au moins un menu dans la boucle
				si on a pas eu de menus, c'est la fin.*/
				/*on fait cela pour le cas ou il y aurait plusieurs fois le meme menu
				dans la commande*/
    		if(!is_there_menu) {
    			fin = true;
    		}
    	}
			/*une fois qu'on a verifie tous les menus, on peut additionner le prix de
			chaque item restant*/
    	for(Consommable a : commande.getItemsCommands()) {
    		prix += a.getPrix();
    	}
    	return prix;
    }
    public void imprimerCommande(Commande c) {
			/*on reutilise la methode caclulerPrixCommade en rajoutant des sorties
			consoles pour afficher la commande*/
    	int prix = 0;
    	boolean fin = false;
    	boolean is_there_menu;
    	Commande commande = new Commande();
    	commande.addList(c.getItemsCommands());
    	System.out.println("__________________");
    	System.out.println("_____Commande_____");
    	while(!fin) {
    		is_there_menu = false;
    		for(Menu m : menus) {
    			if(commande.isThereMenu(m)) {
    				commande.removeMenu(m);
    				System.out.println(m);
    				prix += m.getPrix();
    				is_there_menu = true;
    			}
    		}
    		if(!is_there_menu) {
    			fin = true;
    		}
    	}
    	for(Consommable a : commande.getItemsCommands()) {
    		prix += a.getPrix();
    		System.out.println("Consommable : " + a.getNom() + "\tPrix : " + a.getPrix());
    	}

    	System.out.println("\n\n\nPrix total : " + prix);
    	System.out.println("__________________");


    }
    public boolean verifMenu(Menu m) {
			//on verifie que chaque item du menu est dans la carte
    	for(Consommable c : m.getItems()) {
    		if(verifCarte(c)) {
    			return false;
    		}
    	}
    	return true;
    }
    public void proposerMenu(int Kc, int epsilon) {
    	int kcal;
			//on regarde la valeur nutritionnelle de chaque menu
    	for(Menu menu : menus) {
    		kcal = menu.getKcal();
				//si il correspond, on l'affiche
    		if(kcal<Kc+epsilon && kcal>Kc-epsilon) {
    			System.out.println("Un menu adéquat est : ");
    			System.out.println(menu);
    		}
    	}
    }




    public void afficherMenu(){
	System.out.println("Liste des entrees:" + entrees);
	System.out.println("Liste des plats principaux:" + platsPrincipaux);
	System.out.println("Liste des desserts:" + desserts);
	System.out.println("Liste des boissons:" + boissons);
    }
}
