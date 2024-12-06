public class EtudiantCycleIngenieur extends Etudiant {

    private double pfe;

    public EtudiantCycleIngenieur(String cne, String nom, String prenom, double[] notes, double pfe) {
        super(cne, nom, prenom, notes);
        this.pfe = pfe;
    }

    @Override
    public double calcMoy() {
        double sommeNotes = 0;
        for (double note : notes) {
            sommeNotes += note;
        }
        double moyenneNotes = sommeNotes / notes.length;
        return moyenneNotes * 0.5 + pfe * 0.5;
    }

    @Override
    public boolean estValide() {
        return calcMoy() >= 12;
    }

    @Override
    public String toString() {
        return super.toString() + " \\n Note de projet de fin d'études : " + pfe + "\nmention : " + mention();
    }

    public String mention(){
        double moy = calcMoy();
        if(estValide() == false){
            return "NV";
        }
        if(moy > 15){
            return "Very Good";
        }
        if(moy > 13){
            return "Good";
        }
        return "Assez bien";
    }

    @Override
    public String getType() {
        return "EtudiantCycleIngenieur";
    }
}