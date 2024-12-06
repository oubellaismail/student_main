public class EtudiantCyclePreparatoire extends Etudiant {

    public EtudiantCyclePreparatoire(String cne, String nom, String prenom, double[] notes) {
        super(cne ,nom, prenom, notes); 
    }

    @Override
    public String getType() {
        return "EtudiantCyclePreparatoire";
    }
}