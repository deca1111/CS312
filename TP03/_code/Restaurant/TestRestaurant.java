package Restaurant;

public class TestRestaurant {

    public TestRestaurant() {
    }

    public static void main(String args[]){
			Entree entree = new Entree("Salade mexicaine", 5);
			PlatPrincipal platP = new PlatPrincipal("Pizza aux anchois",20);
			Dessert dessert = new Dessert("Mousse au chocolat", 15);
			Boisson boisson = new Boisson("Coca Zero",10,50);

			Menu menu = null;

			try{
				menu = new Menu(40,entree,platP,dessert,boisson);
			} catch (Exception e) {
				System.out.println("Ya un pb wlh");
				//e.printStackTrace();
			}

			System.out.println(menu);

    }

}
