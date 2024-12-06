public class Etudiant implements Comparable<Etudiant>{
    String cne ;
    String nom ;
    String prenom;
    double [] notes ;
    String etat = "NULL";

    Etudiant (String cne, String nom, String prenom, double [] notes) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
    }

    public double calcMoy(){
        if (notes == null) {
            return 0.0; 
        }
        double sum = 0;
        for (double note : notes) {
            sum += note;
        }
        return sum / notes.length;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double[] getNotes() {
        return notes;
    }

    public void setNotes(double[] notes) {
        this.notes = notes;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString(){
        return "cne : " + cne + "\nnom : " + nom + "\nprenom : " + prenom + "\nmark 1 = " + notes[0] + ", mark 2 = " + notes[1] + ", mark 3 = " + notes[2] + ", mark 4 = " + notes[3] + ", with moyenne = "+ calcMoy();
    }

    @Override
    public int compareTo(Etudiant o) {
        return Double.compare(o.calcMoy(), this.calcMoy());
    }



    public boolean estValide() {
        return calcMoy() >= 10;
    }

    public String getType() {
        return "Etudiant";
    }
}
