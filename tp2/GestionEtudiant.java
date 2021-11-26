import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionEtudiant {
    public static void main(String[] args) {
        int n;
        Etudiant tabEtudiant[];
        try {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Effectif de la classe :");
            n = sc.nextInt();
            sc.nextLine();
            tabEtudiant = new Etudiant[n];

            reinitialiserListe(tabEtudiant);
            tabEtudiant = sortTab(tabEtudiant);
            
            while(true){
                int choix = menu();
                if (choix == 1){
                    for (Etudiant etudiant : tabEtudiant) {
                        etudiant.afficher();
                    }
                } else if (choix == 2) {
                    rechercherPremier(tabEtudiant);
                } else if (choix == 3) {
                    rechercherDernier(tabEtudiant);
                } else if (choix == 4) {
                    reinitialiserListe(tabEtudiant);
                } else {
                    System.out.println("Good Bye");
                    System.exit(0);
                }
                sc.close();
            }
        } catch (InputMismatchException e) {
            //TODO: handle exception
            e.getMessage();
        }
    }

        

    

    private static Etudiant[] sortTab(Etudiant[] tabEtudiant){
        Etudiant tmp;
        for (int i = 0; i < tabEtudiant.length - 1; i++) {
            for (int j = i+1; j < tabEtudiant.length; j++) {
                if (tabEtudiant[j].getMoyenne() > tabEtudiant[i].getMoyenne() ) {
                   tmp = tabEtudiant[i];
                   tabEtudiant[i] = tabEtudiant[j];
                   tabEtudiant[j] = tmp;
                   
                }
            }
        }
        return tabEtudiant;
    }
    private static void reinitialiserListe(Etudiant[] tabEtudiant) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tabEtudiant.length; ++i) {
            System.out.println("Informations Etudiant "+(i+1));
            System.out.println("Annee de naissance : ");
            int annee = sc.nextInt();
            System.out.println("Mois de naissance : ");
            int mois = sc.nextInt();
            System.out.println("Jour de naissance : ");
            int jour = sc.nextInt();
            sc.nextLine();
            
            tabEtudiant[i] = new Etudiant(sc.nextLine(), sc.nextLine(),new Date(jour,mois,annee),sc.nextDouble());
            // sc.close();
        }
    }

    private static void rechercherDernier(Etudiant[] tabEtudiant) {
        tabEtudiant[tabEtudiant.length - 1].afficher();
    }

    private static void rechercherPremier(Etudiant[] tabEtudiant) {
        tabEtudiant[0].afficher();
    }

    public static int menu(){
        int choix;
        Scanner sb = new Scanner(System.in);
        do {
            System.out.println("1 - Liste Etudiants par Ordre de merite \n"+
                                "2 - Informations du premier \n"+
                                "3 - Informations du dernier \n"+
                                "4 - Reinitialiser la liste de la Classe\n"+
                                "5 - Exit\n");
            System.out.println("Votre choix :");
            choix = sb.nextInt();
            sb.nextLine();
        } while (choix < 1 || choix > 5);
        // sb.close();
        return choix;
    }
}
