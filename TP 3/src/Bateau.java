
public class Bateau {
	private int taille;
	private int[][] coords;
	private int[] etats; // 0 touché et 1 pas touché
	
	public Bateau(int t, int longueur, int largeur) { //longueur abscisses et largeur ordonnées
		taille = t;
		etats = new int[t];
		for (int i = 0; i < t; i++) {
			etats[i] = 1;
		}
		coords[0][0] = (int) Math.random()*longueur;
		coords[0][1] = (int) Math.random()*largeur;
		int rotation = (int) (Math.random()*4 - 0.0001);
		while (coords[1][0] < 0 && coords[1][1] < 0 && coords[1][0] > longueur&&coords[1][1] > largeur) {
			if (rotation == 0) {
				coords[1][0] = coords[0][0] + 1;
				coords[1][1] = coords[0][1];
				rotation = 1;
			}
			if (rotation == 1) {
				coords[1][0] = coords[0][0];
				coords[1][1] = coords[0][1] + 1;
				rotation = 2;
			}
			if (rotation == 2) {
				coords[1][0] = coords[0][0] - 1;
				coords[1][1] = coords[0][1];
				rotation = 3;
			}
			if (rotation == 3) {
				coords[1][0] = coords[0][0];
				coords[1][1] = coords[0][1] - 1;
				rotation = 0;
			} 
		}
		for (int i = 2; i < t; i++) {
			int sens;
			if (Math.random()>0.5) {
				sens = 1;
			}
			else {
				sens = 0;
			}
			while (coords[i][0] < 0 && coords[i][1] < 0 && coords[i][0] > longueur && coords[i][1] > largeur) {
				if (sens == 1 && coords[1][0] == coords[0][0] - 1 && coords[1][0] == coords[0][0] + 1) {
					
				}
				if (sens == 0 && coords[1][0] == coords[0][0] - 1 && coords[1][0] == coords[0][0] + 1) {
					
				}
				if (sens == 1 && coords[1][1] == coords[0][1] - 1 && coords[1][1] == coords[0][1] - 1) {
					
				}
				if (sens == 0 && coords[1][1] == coords[0][1] - 1 && coords[1][1] == coords[0][1] + 1) {
					
				}
			}
		}
	}
	
}
