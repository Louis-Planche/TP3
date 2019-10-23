// ----------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ----------------------------------------------
//   Ecriture et utilisation d'une classe
//              Tableau d'objets
// ----------------------------------------------

import java.util.Scanner;     // pour les saisies


public class Banque {
	
	

  // -----------------------------------------------------------------
  // LES ATTRIBUTS STATIQUES
  // (attributs partagés par toutes les instances de la classe)
  // -----------------------------------------------------------------
  public static final int NB_MAX_CLIENT = 20; // une très petite banque !

  // -----------------------------------------------------------------
  // LES ATTRIBUTS "ORDINAIRES" (non-statiques)
  // -----------------------------------------------------------------
  //  - nom de la banque
  //  - nombre de clients
  //  - tableau des comptes
  private String nomBanque;
  private int nombreClients;
  private CompteBancaire[] clients;
  // ######################################
  // ##########" A COMPLETER ##############
  // ######################################
  
  // ------------------------------------------------------------------
  // LES CONSTRUCTEURS
  // ------------------------------------------------------------------

  public Banque(String nom) {
    nomBanque = nom;
    nombreClients = 0;
    clients = new CompteBancaire[NB_MAX_CLIENT];
  }

  // ------------------------------------------------------------------
  // LES METHODES "ORDINAIRES"
  // ------------------------------------------------------------------
  
  // Description de la banque (son nom, son nombre de clients,
  //   et le descriptif de chaque compte)
  public void afficher() {
    System.out.println("Le nom de la banque est " + nomBanque + " et le nombre de client est " + nombreClients);
    for (int i = 0; i < nombreClients; i++) {
    	if (clients[i].renvoyerSolde() < 0) {
    		System.out.println("!" + clients[i].toString());
    	}
    	else {
    		System.out.println(clients[i].toString());
    	}
    	
    }
  }
  
  // Ajout d'un compte à la banque
  public void ajoute(CompteBancaire c) {
	  if (nombreClients > 19) {
		  System.out.println("Il y a déjà trop de clients.");
	  }
	  else {
		  clients[nombreClients] = c;
		  nombreClients = nombreClients + 1;
	  }

    // ######################################s
    // ##########" A COMPLETER ##############
    // ######################################
  }
  
  
  // Recherche du compte d'un client, ou null si pas trouvé
  public CompteBancaire recherche(String nom)   {
	  CompteBancaire temp;
	  for(int i = 0; i < nombreClients; i++) {
		  if (clients[i].renvoyerTitulaire().equals(nom)) {
			  temp = clients[i]; 
			  return temp;
		  }
	  }
    // ######################################
    // ##########" A COMPLETER ##############
    // ######################################
    return null;
  }
  
  // Dépot d'un montant sur le compte d'un client
  //   (retourne vrai si l'opération a pu être effectuée)
  public boolean depose(String nom, double montant) {
    if (this.recherche(nom) == null) {
    	return false;
    }
    else {
    	CompteBancaire cbTemp = this.recherche(nom);
    	cbTemp.deposer(montant);
    	return true;
    }
  }
  
  // Retrait d'un montant sur le compte d'un client,
  //  (retourne vrai si l'opération a pu être effectuée)
  public boolean retire(String nom, double montant)   {
	  if (this.recherche(nom) == null) {
	    	return false;
	    }
	  else {
	    	CompteBancaire cbTemp = this.recherche(nom);
	    	double soldeInit = cbTemp.renvoyerSolde();
	    	cbTemp.retirer(montant);
	    	if (soldeInit == cbTemp.renvoyerSolde()) {
	    		return false;
	    	}
	    	else {
	    		return true;
	    	}
	  }
  }

  // Virement entre deux clients (si possible)
  //  retourne vrai si l'opération a pu être effectuée
	
	
	  public boolean vire(String debite, String credite, double montant) { if
	  (this.recherche(debite) ) {
	  
	  }
	  
	  // ###################################### 
	  // ##########" A COMPLETER############## 
	  // ######################################
	  
	  return false; }
	 
  // ----------------------------------------------------------------
  // LE PROGRAMME PRINCIPAL (se contente ici de tester les methodes)
  // ----------------------------------------------------------------

  static public void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nomTitulaire; // pour les saisies ci-dessous
    double montant; // pour les saisies ci-dessous

    Banque lyonnais = new Banque("Credit Lyonnais");
    
    // quelques clients de la banque
    lyonnais.ajoute(new CompteBancaire("Calvin", 100.0));
    lyonnais.ajoute(new CompteBancaire("Hobbes", -10.0));
    lyonnais.ajoute(new CompteBancaire("Suzy", 100.0));
    
    // la banque ne ferme jamais;-)
    while (true) {
      // affiche un menu minimal
      System.out.println();
      System.out.println("### GESTION DE LA BANQUE");
      System.out.print("(i)nfos (a)joute (c)onsulte (d)epose (r)etire (v)ire (q)uitte: ");      
      char choix=sc.next().charAt(0);
      sc.nextLine(); // Pour sauter le passage à la ligne tapé par l'utilisateur
                     // (important pour que les prochains nextLine() fonctionnent)

      switch ( choix ) {
      case 'q': // QUITTE l'application guichet
        System.out.println("fermeture du programme");
        return;
      case 'i': // INFOS sur la banque
        lyonnais.afficher();
        break;
      case 'a': // AJOUTE un nouveau compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        // le compte est créé ici
        lyonnais.ajoute(new CompteBancaire(nomTitulaire, montant));
        break;
      case 'c': // CONSULTE un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        CompteBancaire c = lyonnais.recherche(nomTitulaire);
        if (c==null) {
          System.out.println("Pas de compte au nom de " + nomTitulaire);
        }
        else {
          System.out.print("compte: ");
          c.afficher();
        }
        break;
      case 'd': // DÉPOSE sur un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        System.out.println("depot: " + lyonnais.depose(nomTitulaire, montant));
        break;
      case 'r': // RETRAIT d'un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        System.out.println("retrait: " + lyonnais.retire(nomTitulaire, montant));
        break;
      case 'v': // VIRE entre deux comptes
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################
        break;

        // FERMETURE DE COMPTE
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################

        // EN-COURS TOTAL
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################
      
      default:
        System.err.println("action inconnue...");
      }
    }
  } // fin de la fonction main()
  
} // fin de la classe Banque
