// ------------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ------------------------------------------------
//   Ecriture et utilisation d'une classe 
// ------------------------------------------------


public class CompteBancaire {

  // -----------------------------------------------------------------
  // LES ATTRIBUTS
  // -----------------------------------------------------------------

  private String nomTitulaire;
  private double solde;
  private double decouvertMaxiParDefaut;
  private int numeroCompte;
  
  static int compteur = 0;
  // ------------------------------------------------------------------
  // LES CONSTRUCTEURS
  // ------------------------------------------------------------------

  // Le constructeur « principal » :
  public CompteBancaire(String nom, double versementInitial) {
    nomTitulaire = new String(nom);
    solde = versementInitial;
    decouvertMaxiParDefaut = 500;
    numeroCompte = compteur;
    compteur += 1;
  }
  
  // Un 2-ème constructeur pour ouvrir un cpte sans versement initial :
  public CompteBancaire(String nom) {
    this(nom, 0);  // appel du constructeur principal
  }

  // ------------------------------------------------------------------
  // LES METHODES "ORDINAIRES"
  // ------------------------------------------------------------------

  public double renvoyerSolde() {
    return solde;
  }
  public String renvoyerTitulaire() {
    return new String(nomTitulaire);
  }

  public void afficher() {
	  System.out.println("Le titulaire est " + this.renvoyerTitulaire() + " et le solde est " + this.renvoyerSolde());
  }

  // METHODES DE RETRAIT, DEPOT, VIREMENT
  public void deposer(double montant) {
	  if (montant > 0) {
		  solde = solde + montant;
	  }
  }
  
  public String toString() {
	  return "Le numéro de compte est " + numeroCompte + " le titulaire est " + nomTitulaire + " et le solde est "+ solde;
  }
  
  
  
  public void retirer(double retrait) {
	  if (retrait > 0 && (solde - retrait) > -decouvertMaxiParDefaut) {
		  solde = solde - retrait;
	  }
  }
  
  public void virement(CompteBancaire c, double montant) { //virement depuis c du montant donné
	  if (-decouvertMaxiParDefaut < (c.solde - montant)) {
		  this.deposer(montant);
		  c.retirer(montant);
	  }	  
  }
  // ######################################
  // ##########" A COMPLETER ##############
  // ######################################

  // ----------------------------------------------------------------
  // LE PROGRAMME PRINCIPAL (se contente ici de tester les methodes)
  // ----------------------------------------------------------------
  
  public static void main(String[] args) {
    CompteBancaire c1 = new CompteBancaire("Dupond");
    CompteBancaire c2 = new CompteBancaire("Martin", 500);
    System.out.println("Juste après création :");
    c1.afficher();
    c2.afficher();
    c1.deposer(1000);
    c1.afficher();
    c2.afficher();
    c1.deposer(-5);
    c1.afficher();
    c2.afficher();
    c2.retirer(300);
    c1.afficher();
    c2.afficher();
    c2.virement(c1, 400);
    c1.afficher();
    c2.afficher();
    c2.virement(c1, 700);
    c1.afficher();
    c2.afficher();
    // ######################################
    // ##########" A COMPLETER ##############
    // ######################################

  } // fin de la fonction main()
  
} // fin de la classe CompteBancaire
