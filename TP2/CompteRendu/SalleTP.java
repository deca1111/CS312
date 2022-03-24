
public class SalleTP extends Salle{
	
	private Discipline type;
	
	public SalleTP(int capacite, String nom, Discipline d){
		super(capacite, nom);
		type = d;
	}
	
	public Discipline getType() {
		return type;
	}

	public String toString(){
		return "Salle TP "+ type + " " + super.toString();
	}
}
