/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */

import javax.swing.JFrame;

public class AppliVisage2 {
	public static void main(String[] args) {
		JFrame laFenetre = new JFrame("VISAGE ANIME");
		laFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laFenetre.setSize(800, 800);
		Dessin d = new Dessin();
		laFenetre.add(d);
		laFenetre.setVisible(true);
		// creation d'un objet VisageRond
		VisageRond v1 = new VisageRond(200,200);
		// on rajoute cet objet la z�ne de dessin
		d.ajouterObjet(v1);
		// la boucle d'animation
		while (true) {
			// le visage a atteint un des bords, il change de direction
			if (v1.bordGaucheAtteint()){
				v1.inverserDx();
			}
			if (v1.bordDroitAtteint()){
				v1.inverserDx();
			}
			if (v1.bordBasAtteint()){
				v1.inverserDy();
			}
			if (v1.bordHautAtteint()){
				v1.inverserDy();
			}
			// le visage effectue un déplacement élémentaire
			v1.deplacer();
			// la zone de dessin se réaffiche
			d.repaint();
			// un temps de pause pour avoir le temps de voir le nouveau dessin
			d.pause(5);
		}
	}
} // AppliVisage2
