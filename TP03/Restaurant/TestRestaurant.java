package Restaurant;

public class TestRestaurant {

    public TestRestaurant() {
    }

    public static void main(String args[]){
  	   System.out.println("Lancement de l'application v1");
       //Creation des plats principaux:
       PlatPrincipal steak = new PlatPrincipal("steak", 15, 300, 10);
			 PlatPrincipal frites = new PlatPrincipal("frites", 8, 350, 100);
			 PlatPrincipal pates = new PlatPrincipal("pates", 12, 400, 200);
			 //creation des boissons:
			 Boisson cola = new Boisson("cola", 2, 75, 200, 100);
			 Boisson biere = new Boisson("biere", 2, 75, 150, 75);
			 Boisson eau_petillante = new Boisson("eau_petillante", 2, 75, 0, 0);
			 Boisson grenadine = new Boisson("grenadine", 2, 75, 200, 10);
			 //creation des entrees
			 Entree saumon = new Entree("saumon", 10, 150, 0);
			 Entree salade = new Entree("salade", 8, 150, 0);
			 //creation des desserts
			 Dessert tiramisu = new Dessert("tiramisu", 5, 350, 40);
			 Dessert mousse_au_chocolat = new Dessert("mousse_au_chocolat", 4, 350, 40);
			 //creation des menus:
			 Menu menu1 = null;
			 Menu menu2 = null;
			 Menu menu3 = null;
			 try{
         menu1 = new Menu(50, salade, steak, mousse_au_chocolat, cola);

       }catch(Exception e){
			 		System.out.println("Test de la methode verifPrixMenu");
         System.out.println("erreur: "+ e.getMessage());
       }

			 try{
				 menu1 = new Menu(15, salade, steak, mousse_au_chocolat, cola);
				 menu2 = new Menu(25, saumon, pates, tiramisu, eau_petillante);
				 menu3 = new Menu(20, salade, frites, mousse_au_chocolat, grenadine);
			 }catch(Exception e){
			 		System.out.println("Test de la methode verifPrixMenu");
				 	System.out.println("erreur: "+ e.getMessage());
			 }

			 //affichage des menus
       System.out.println(menu1.toString());
			 System.out.println(menu2.toString());
			 System.out.println(menu3.toString());

       //Creation de la carte
       Carte carte1 = new Carte();
			 //test verifMenu
       System.out.println("verifMenu() : " + carte1.verifMenu(menu1));
			 //ajout des elements dans la carte:
			 carte1.addDessert(mousse_au_chocolat);
			 carte1.addDessert(tiramisu);
			 carte1.addPlatPrincipal(steak);
			 carte1.addPlatPrincipal(frites);
			 carte1.addPlatPrincipal(pates);
			 carte1.addEntree(saumon);
			 carte1.addEntree(salade);
			 carte1.addBoisson(eau_petillante);
			 carte1.addBoisson(cola);
			 carte1.addBoisson(grenadine);
			 carte1.addBoisson(biere);

			 //test de la fonction verifCarte
			  carte1.addDessert(tiramisu);

       //ajout des menus dans la carte
       carte1.addMenu(menu1);
			 carte1.addMenu(menu2);
			 carte1.addMenu(menu3);

			 //creation de la commande
       Commande c = new Commande();
			 c.addItem(saumon);
			 c.addItem(salade);
			 c.addItem(frites);
			 c.addItem(steak);
			 c.addItem(mousse_au_chocolat);
			 c.addItem(cola);
			 //test imprimer commande
       carte1.imprimerCommande(c);
			 //test proposerMenu
       carte1.proposerMenu(900, 150);
    }



}
