import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Hello bro to our application, hope you enjoy it so you have to fill out firstly the database then you can manage it with a lot of operations : ");
        System.out.println("Give the number of students to insert : ");

        int n = scanner.nextInt();

        List<Etudiant> stds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Insert student number " + (i + 1) + ", informations : ");

            System.out.println("\n---Nano Menu ---");
            System.out.println("1. Ajouter un étudiant Engenering Cycle");
            System.out.println("2. Ajouter un étudiant Cycle preparatoire");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();

            System.out.print("Nom : ");
            String nom = scanner.next();

            System.out.print("Prenom : ");
            String prenom = scanner.next();

            System.out.print("Cne : ");
            String cne = scanner.next();

            System.out.println("Insert students marks : ");
            double[] marks = new double[4];

            for (int j = 0; j < 4; j++) {
                System.out.print("Insert mark N:" + (j + 1) + " : ");
                marks[j] = scanner.nextDouble();
            }

            if(choice == 1) {
                System.out.print("Pfe : ");
                Double pfe = scanner.nextDouble();

                stds.add(new EtudiantCycleIngenieur(cne, nom, prenom, marks, pfe));
            }

            else {
                stds.add(new EtudiantCyclePreparatoire(cne, nom, prenom, marks));
            }
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Modifier un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Rechercher un étudiant");
            System.out.println("5. Trier les étudiants par moyenne");
            System.out.println("6. Affichage des etudiants");
            System.out.println("7. Affichage etudiant concerne au ratt : ");
            System.out.println("8. Quitter");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add(stds, scanner);
                    break;
                case 2:
                    update(stds, scanner);
                    break;
                case 3:
                    delete(stds, scanner);
                    break;
                case 4:
                    Etudiant etd = find(stds, scanner);
                    if (etd == null) {
                        System.err.println("Not found !");
                    } else {
                        System.out.println(etd);
                    }
                    break;
                case 5:
                    sort(stds);
                    display(stds, scanner);
                    break;
                case 6:
                    display(stds, scanner);
                    break;
                case 7:
                    ratrrapage(stds, scanner);
                    break;
                case 8:
                    System.out.println("Good bye !");
                    return;
                default:
                    System.out.println("Sorry, unexisted option ...");
                    break;
            }
        }

    }

    public static void update(List<Etudiant> stds, Scanner scanner) {
        System.out.println("Update a student : ");
        Etudiant etd = find(stds, scanner);
        if (etd == null) {
            System.err.println("Not found !");
            return;
        }

        while (true) {
            System.out.println("This is the student with cne : " + etd.cne);
            System.out.println(etd);
            System.out.println("\n--- Mini Menu ---");
            System.out.println("1. Edit Nom");
            System.out.println("2. Edit Prenom");
            System.out.println("3. Edit CNE");
            System.out.println("4. Edit Marks");
            System.out.println("Press 5 to exit !");
            System.out.print("Votre choix: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Give me new Nom : ");
                    String nom = scanner.next();
                    etd.setNom(nom);
                    break;
                case 2:
                    System.out.print("Give me new Prenom : ");
                    String prenom = scanner.next();
                    etd.setPrenom(prenom);
                    break;
                case 3:
                    System.out.print("Give me new CNE : ");
                    String cne = scanner.next();
                    etd.setCne(cne);
                    break;
                case 4:
                    while (true) {

                        double[] marks = etd.getNotes();
                        System.out.println("These are " + etd.getNom() + ", marks : ");
                        for (double mark : marks) {
                            System.out.print(mark + " ");
                        }
                        System.out.println();

                        System.out.println("\n--- Micro Menu ---");
                        System.out.println("1. Edit Mark Number 1");
                        System.out.println("2. Edit Mark Number 2");
                        System.out.println("3. Edit Mark Number 3");
                        System.out.println("4. Edit Mark Number 4");
                        System.out.println("Press 5 To Exist");
                        System.out.print("Your Choice : ");
                        int choix = scanner.nextInt();

                        if (choix < 5 && choix > 0) {
                            System.out
                                    .println("This is the old value : " + marks[choix] + " , so insert the new one :");
                            marks[choix - 1] = scanner.nextDouble();
                            etd.setNotes(marks);
                        } else {
                            break;
                        }
                    }
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Enexisted option ... !");
            }
        }

    }

    public static void sort(List<Etudiant> stds) {
        if (stds.size() == 0) {
            System.out.println("No data to sort ...!");
            return;
        }
        Collections.sort(stds);
    }

    public static void delete(List<Etudiant> stds, Scanner scanner) {
        System.out.println("Delete a student : ");
        Etudiant etd = find(stds, scanner);
        if (etd == null) {
            System.err.println("Not found !");
            return;
        }
        stds.remove(etd);
        System.err.println("Student deleted sucessfuly !");
    }

    public static Etudiant find(List<Etudiant> stds, Scanner scanner) {
        System.out.println("Give student's CNE : ");
        String cne = scanner.next();
        Etudiant etd = null;
        for (Etudiant std : stds) {
            if (std.getCne().toLowerCase().equals(cne.toLowerCase())) {
                etd = std;
                break;
            }
        }
        return etd;
    }

    public static void add(List<Etudiant> stds, Scanner scanner) {

        System.out.println("\n---Nano Menu ---");
        System.out.println("1. Ajouter un étudiant Engenering Cycle");
        System.out.println("2. Ajouter un étudiant Cycle preparatoire");
        System.out.print("Votre choix: ");
        int choice = scanner.nextInt();

        System.out.println("Give the number of students to insert : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Insert student number " + (i + 1) + ", informations : ");

            System.out.print("Nom : ");
            String nom = scanner.next();

            System.out.print("Prenom : ");
            String prenom = scanner.next();

            System.out.print("Cne : ");
            String cne = scanner.next();

            System.out.println("Insert students marks : ");
            double[] marks = new double[4];

            for (int j = 0; j < 4; j++) {
                System.out.print("Insert mark N:" + (j + 1) + " : ");
                marks[j] = scanner.nextDouble();
            }

            if(choice == 1) {
                System.out.print("Pfe : ");
                Double pfe = scanner.nextDouble();

                stds.add(new EtudiantCycleIngenieur(cne, nom, prenom, marks, pfe));
            }

            else {
                stds.add(new EtudiantCyclePreparatoire(cne, nom, prenom, marks));
            }
        }
    }

    public static void setStatus(List<Etudiant> etds){
        int size = etds.size();
        double total = 0;
        for(Etudiant etudiant : etds){
            total+= etudiant.calcMoy();
        }

        double tMoy = total/size;

        for(Etudiant etudiant : etds){
            if (etudiant.calcMoy() >= tMoy){
                etudiant.setEtat("VA");
            }
            else{
                etudiant.setEtat("NV");
            }
        }
    }

    public static void display(List<Etudiant> stds, Scanner scanner) {

        if (stds.size() == 0) {
            System.out.println("No data to display ...!");
            return;
        }

        System.out.println("\n---Nano Menu ---");
        System.out.println("1. Display Engenering Cycle");
        System.out.println("2. Display Cycle preparatoire");
        System.out.print("Votre choix: ");
        int choice = scanner.nextInt();

        setStatus(stds);
        
        switch (choice) {
            case 1:
                System.out.println("Displaying Engenering Cycle : ");
                for (Etudiant std : stds) {
                    if (std.getType().equalsIgnoreCase("EtudiantCycleIngenieur")) {
                        System.out.println(std);
                    }
                }
                break;

            case 2 :
                System.out.println("Displaying Cycle preparatoire : ");
                for (Etudiant std : stds) {
                    if (std.getType().equalsIgnoreCase("EtudiantCyclePreparatoire")) {
                        System.out.println(std);
                    }
                }
                break; 
            default:
                break;
        }

    }

    public static void ratrrapage(List<Etudiant> stds, Scanner scanner){
        List<Etudiant> rat = new ArrayList<Etudiant>();
        for(Etudiant std : stds){
            if(std.estValide() == false){
                rat.add(std);
            }
        }
        display(rat,scanner);
    }
}