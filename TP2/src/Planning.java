import java.util.*;

public class Planning {
    private List<Creneau> edt;
    
    public Planning(){
	edt = new ArrayList<Creneau>();
    }
	
    public String toString(){
	String res = new String();
	for (Creneau c : edt){
	    res = res + c + "\n";
	}
	return res;
    }
	
    public boolean verifCreneau(Creneau c){
	boolean ok = true;
	int i = 0;
	while (ok && i < edt.size()){
	    Creneau cour = edt.get(i++);
	    ok = !c.intersection(cour);
	}
	return ok;
    }
	
    public void addCreneau(Creneau c){
	if (this.verifCreneau(c)) edt.add(c);
	else System.out.println("NON INSERE : Creneau " + c);
    }
	
    public List<Creneau> planningGroupe(Groupe groupe){
		//Construisons une liste vide:
		ArrayList<Creneau>plan = new ArrayList<Creneau> ();
		Iterator<Creneau> iterateur = edt.iterator();
		while(iterateur.hasNext()) {
			Creneau temp = iterateur.next();
			if(temp.getActivite().getGroupes().contains(groupe)) {
				plan.add(temp);
			}
		}
		return plan;
    }
	
    public float totalHeuresGroupe(Groupe groupe){
		int res = 0;
		for(Creneau c : planningGroupe(groupe)) {
			res += c.getDuree();
		}
		
		return (float) res/60;
    }

	
    public static void main (String [] args){
	/*Planning p = new Planning();
		
	SalleCTD a042 = new SalleCTD(100, "A042");
	SalleCTD d030 = new SalleCTD(180, "D030");

	SalleTP b141 = new SalleTP(16, "B141", Discipline.Informatique);
	SalleCTD a048 = new SalleCTD(25, "A048");
		
	CM cs310cm = new CM("CM CS310");
	cs310cm.addSalle(a042);
	cs310cm.addSalle(d030);

	TP cs330tp1 = new TP("TP1 CS330", Discipline.Informatique);
	cs330tp1.addSalle(b141);
	cs330tp1.addSalle(a048);
		
	CM cs410cm = new CM("CM CS410");
	cs410cm.addSalle(a042);
	cs410cm.addSalle(d030);
	cs410cm.addSalle(a048);
		
	CM cs421_422cm = new CM("CM CS421 - CS422");
	cs421_422cm.addSalle(a042);
	cs421_422cm.addSalle(d030);
	cs410cm.addSalle(a048);
		
	Groupe a3tp1 = new Groupe("3ATP1", 16);
	Groupe a3tp2 = new Groupe("3ATP2", 16);
	Groupe a3tp3 = new Groupe("3ATP3", 16);
	Groupe a3tp4 = new Groupe("3ATP4", 16);
	Groupe a3tp5 = new Groupe("3ATP5", 16);

	Groupe a4ir = new Groupe("4AIR", 29);
	Groupe a4eis = new Groupe("4AEIS", 35);
		
	cs310cm.addGroupe(a3tp1);
	cs310cm.addGroupe(a3tp2);
	cs310cm.addGroupe(a3tp3);
	cs310cm.addGroupe(a3tp4);
	cs310cm.addGroupe(a3tp5);

	cs330tp1.addGroupe(a3tp1);
	cs410cm.addGroupe(a4ir);
	cs421_422cm.addGroupe(a4ir);
	cs421_422cm.addGroupe(a4eis);
		
	Creneau c1 = null, c2 = null, c3 = null, c4 = null, c5 = null;
	c1 = new Creneau(2014, 1, 17, 13, 15, 105, a042, cs310cm);
	c2 = new Creneau(2014, 1, 17, 8, 00, 210, a048, cs330tp1);
	c3 = new Creneau(2014, 1, 17, 15, 15, 105, d030, cs410cm);
	c4 = new Creneau(2014, 1, 17, 10, 00, 105, a042, cs421_422cm);
	c5 = new Creneau(2014, 1, 17, 17, 15, 105, a042, cs310cm);
	//c1 = new Creneau(2014, 1, 17, 13, 15, 105, a042, cs310cm);
	//c2 = new Creneau(2014, 1, 17, 13, 15, 210, b141, cs330tp1);

	
	p.addCreneau(c1);
	p.addCreneau(c2);
	p.addCreneau(c3);
	p.addCreneau(c4);
	p.addCreneau(c5);

	System.out.println(p);
		
	System.out.println("Le groupe " + a3tp1.getNom() + " est dans le(s) creneau(x) : "+p.planningGroupe(a3tp1) + " pour un total de " + p.totalHeuresGroupe(a3tp1) + " heures");
	System.out.println("Le groupe " + a4ir.getNom() + " est dans le(s) creneau(x) : "+p.planningGroupe(a4ir));
	System.out.println("Le groupe " + a3tp1.getNom() + " est dans le(s) creneau(x) : " + p.planningGroupe(a3tp1));*/

    	String c1 = "toto";
    	String c2 = "toto";
    	c2 = "titi";
    	if (c1 == c2) // A ne jamais faire dans un code
    	    System.out.println("M�me objet");
    	else if (c1.equals(c2))
    	    System.out.println("Objets �quivalent (mais espaces m�moires diff�rents");
    	 	
    	String c3 = new String("toto");
    	String c4 = new String("toto");
    	if (c3 == c4) // A ne jamais faire dans un code
    	    System.out.println("M�me objet");
    	else if (c3.equals(c4))
    	    System.out.println("Objets �quivalent (mais espaces m�moires diff�rents");
    }
}

// Sortie "prof" à la fin du TP 
// 17/1/2014 13:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places)
// 17/1/2014 8:0 (210) : Activite TP1 CS330 ([3ATP1 (16 étudiants)]) Salle TP Informatique B141 (16 places)
// 17/1/2014 15:15 (105) : Activite CM CS410 ([4AIR (29 étudiants)]) Salle cours-TD D030 (180 places)
// 17/1/2014 10:0 (105) : Activite CM CS421 - CS422 ([4AIR (29 étudiants), 4AEIS (35 étudiants)]) Salle cours-TD A042 (100 places)
// 17/1/2014 17:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places)

// [17/1/2014 13:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places), 17/1/2014 8:0 (210) : Activite TP1 CS330 ([3ATP1 (16 étudiants)]) Salle TP Informatique B141 (16 places), 17/1/2014 17:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places)] (7.0 heures)
// [17/1/2014 15:15 (105) : Activite CM CS410 ([4AIR (29 étudiants)]) Salle cours-TD D030 (180 places), 17/1/2014 10:0 (105) : Activite CM CS421 - CS422 ([4AIR (29 étudiants), 4AEIS (35 étudiants)]) Salle cours-TD A042 (100 places)]
// [17/1/2014 13:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places), 17/1/2014 8:0 (210) : Activite TP1 CS330 ([3ATP1 (16 étudiants)]) Salle TP Informatique B141 (16 places), 17/1/2014 17:15 (105) : Activite CM CS310 ([3ATP1 (16 étudiants), 3ATP2 (16 étudiants), 3ATP3 (16 étudiants), 3ATP4 (16 étudiants), 3ATP5 (16 étudiants)]) Salle cours-TD A042 (100 places)]
