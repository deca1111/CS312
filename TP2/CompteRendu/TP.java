
public class TP extends Activite{
	private Discipline type;
	
	public TP(String nom, Discipline d){
		super(nom);
		type = d;
	}
	
	
	public Discipline getType() {
		return type;
	}


	public void addSalle(SalleTP s){
		super.addSalle(s);
	}
}
