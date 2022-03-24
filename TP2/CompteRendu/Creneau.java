import java.util.*;

public class Creneau {
    private int annee;
    private int mois; // 1 à 12
    private int jour; // 1 à 31
    private int heure; // 0 à 23
    private int minute; // 0 à 59
    private int duree; // en minutes, maximum 210
	
    private Salle salle;
    private Activite activite;
	
    public Creneau(int a, int m, int j, int h, int min, int d, Salle s, Activite ac) {
		
	annee = a; mois = m; jour = j;
	heure = h; minute = min; duree = d;
	salle = s;
	activite = ac;
	
	if(!verifCapacite()){
	    System.exit(1); // On pourrait utiliser un mécanisme d'exception, aussi. 
	}
	if(!verifDuree()){
	    System.exit(1);
	}
	if(!verifSalle()){
	    System.exit(1);
	}
    }
    
    // Verifie l'adéquation de la salle : la salle affectée doit être une des salles appropriées de l'activité. Indication: utiliser une methode de liste.
    private boolean verifSalle(){
		boolean estDedans = false;
		boolean bonneDiscipline = true;
		
		if(activite instanceof TP) {
			if(salle instanceof SalleTP) {
				bonneDiscipline = ( ((SalleTP) salle).getType() == ((TP) activite).getType() );
			}
		}
		for(Salle salle_ : activite.getSalles()) {
			if(salle_ == salle ) {
				estDedans = true;
			}
		}
		return estDedans && bonneDiscipline;
    }
    
    // Verifie que la taille de la salle convient à la promo
    private boolean verifCapacite(){
    	int nbEleve = 0;
    	for(Groupe gr : activite.getGroupes() ) {
			nbEleve += gr.getEffectif();
		}
    	return nbEleve <= salle.getCapacite();
    }
    
    // Verifie que le début et la fin du créneau sont dans la même journée, entre 8h et 19h
    private boolean verifDuree(){
    	return (((heure*60+minute)>=(8*60)) && ((heure*60+minute+duree)<=(19*60)));
    }
    
    public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	public int getJour() {
		return jour;
	}

	public int getHeure() {
		return heure;
	}

	public int getMinute() {
		return minute;
	}

	public Salle getSalle(){
	return salle;
    }
    
    public Activite  getActivite(){
	return activite;
    }
    
    public int  getDuree(){
	return duree;
    }
    
    public String toString(){
	return jour + "/" + mois + "/" + annee + " " + heure + ":" + minute +" (" + duree +") : " + 
	    activite + " " + salle;
    }

    
    // Intersection
    public boolean intersection(Creneau c){
    	boolean result = false;
    	//on verifie que les 2 crenaux sont le même jour
    	if((annee == c.getAnnee()) && (mois == c.getMois()) && (jour == c.getJour())) {
    		
    		//Si les 2 crenaux ont un groupe en commun ou la même salle...
    		if(groupeEnCommun(activite.getGroupes(),c.getActivite().getGroupes()) || (salle == c.getSalle())) {
    			
    			//...on verifie que leurs horaires ne se chevauchent pas
    			if((heure*60+minute) >= (c.getHeure()*60+c.getMinute())) {
    				result = (c.getHeure()*60+c.getMinute()+c.getDuree() >= heure*60+minute);
    			}else {
    				result = (c.getHeure()*60+c.getMinute() <= heure*60+minute+duree);
    			}
    		}
    	}
    	return result;
    }    
    
    public boolean groupeEnCommun(ArrayList<Groupe> groupes1, ArrayList<Groupe> groupes2) {
		for(Groupe g: groupes1) {
			if(groupes2.contains(g)) {
				return true;
			}
		}
		return false;
    }

}
