package SpitalMCV.view;

import SpitalMCV.controller.ControllerPacient;
import SpitalMCV.model.Pacient;

import java.util.Scanner;

public class View {

    public ControllerPacient controllerPacient = new ControllerPacient();

    public Scanner scanner = new Scanner(System.in);


    public void meniu() {

        System.out.println("Apasati tasat 1 pentru a vedea toti pacientii");
        System.out.println("Apsati tasta 2 pentru a adauga un pacient");
        System.out.println("Apasati tasta 3 pentru a sterge un pacient ");
        System.out.println("Apasati tasta 4 pentru a modifica un pacient ");


    }


    public void play() {
        controllerPacient.loadPacienti();
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    controllerPacient.afisarePacient();
                    break;

                case 2:
                    adaugarePacient();
                    break;

                case 3:
                    stergerePacient();
                    break;

                case 4:
                    updatePacient();
                    break;

                default:
                    System.out.println("Alegere gresita");
            }
        }

    }

    public void adaugarePacient() {
        System.out.println("Introduceti id-ul pacientului: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti afectiunea: ");
        String afectiune = scanner.nextLine();
        System.out.println("Introduceti salonul in care se afla (1-9): ");
        char nrSalon = scanner.nextLine().charAt(0);
        System.out.println("Introduceti true,daca pacientul are COVID si false, daca pacientul nu are COVID: ");
        boolean areCovid = Boolean.parseBoolean(scanner.nextLine());


        Pacient pacient = controllerPacient.findPacientByNumeSiPrenume(nume, prenume);
        if (pacient == null) {
            Pacient sNou = new Pacient();
            sNou.id = id;
            sNou.nume = nume;
            sNou.prenume = prenume;
            sNou.afectiune = afectiune;
            sNou.nrSalon = nrSalon;
            controllerPacient.addPacient(sNou);
            System.out.println("S-a adaugat cu success ");
        } else {

            System.out.println("Pacientul exista deja");
        }

    }

    public void stergerePacient() {
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele: ");
        String prenume = scanner.nextLine();

        Pacient pacient = controllerPacient.findPacientByNumeSiPrenume(nume, prenume);
        if (pacient == null) {
            System.out.println("Nu exista un pacient cu acest nume si prenume");
        } else {
            controllerPacient.removePacient(pacient);
            System.out.println("Pacientul a fost sters");
        }

    }


    public void updatePacient() {

        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele: ");
        String prenume = scanner.nextLine();

        Pacient pacient = controllerPacient.findPacientByNumeSiPrenume(nume, prenume);
        if (pacient == null) {
            System.out.println("Nu exista un pacinet cu acest nume si prenume");
        } else {

            System.out.println("Introduceti cu virgula campurile ce doriti sa fie modificate: id,afectiune,nrSalon");

            String[] upd = scanner.nextLine().split(",");


            Pacient nou = new Pacient();

            nou.nume = nume;
            nou.prenume = prenume;

            for (int i = 0; i < upd.length; i++) {


                switch (upd[i]) {

                    case "id":
                        System.out.println("Introduceti noul id");
                        nou.id = Integer.parseInt(scanner.nextLine());
                        break;
                    case "afectiune":
                        System.out.println("Introduceti noua afectiune: ");
                        nou.afectiune = scanner.nextLine();
                        break;
                    case "nrSalon":
                        System.out.println("Introduceti noul nr de salon: ");
                        nou.nrSalon = scanner.nextLine().charAt(0);
                        break;
                    default:
                        System.out.println("Alegere gresita");
                }
            }


            controllerPacient.update(nou);

        }
    }
}
