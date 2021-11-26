import java.util.Date;

public class Etudiant {
    
    private static int code = 0;
    private int matricule;
    private String nom;
    private String genre;
    private Date dateNaissance;
    private double moyenne;

    public Etudiant(String nom,String genre,Date dateNaissance,double moyenne){
        ++code;
        this.matricule = code;
        this.nom = nom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = moyenne;
    }

    public Etudiant(){
        
    }

    

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void afficher(){
        System.out.println("Informations de l'etudiant numero"+this.matricule);
        System.out.println("Matricule : "+this.matricule+" Nom : "+this.nom+" genre : "+this.genre+" Date de naissance : "+this.dateNaissance.toString()+" Moyenne : "+this.moyenne);
        System.out.println();
    }

    public int calculerAge(Date dateNaissance){
        Date dateActuelle = new Date();
        return dateActuelle.getYear() - dateNaissance.getYear();
    }

    public void bonifier(double bonus){
        this.moyenne += bonus;
    }

 

}
