package SpitalMCV.controller;

import SpitalMCV.model.Pacient;

import java.util.ArrayList;

public class ControllerPacient {
    public ArrayList<Pacient> pacienti = new ArrayList<>();

    public void loadPacienti() {
        Pacient p1 = new Pacient();
        p1.id = 11;
        p1.nume = "Ene";
        p1.prenume = "Mihaela";
        p1.afectiune = "anxietate";
        p1.nrSalon = '1';
        p1.areCovid = false;


        Pacient p2 = new Pacient();
        p2.id = 22;
        p2.nume = "Popescu";
        p2.prenume = "Felicia";
        p2.afectiune = "depresie";
        p2.nrSalon = '2';
        p2.areCovid = true;


        Pacient p3 = new Pacient();
        p3.id = 33;
        p3.nume = "Ionescu";
        p3.prenume = "Marin";
        p3.afectiune = "gripa";
        p3.nrSalon = '3';
        p3.areCovid = false;


        Pacient p4 = new Pacient();
        p4.id = 44;
        p4.nume = "Simionescu";
        p4.prenume = "Floricica";
        p4.afectiune = "dermatita";
        p4.nrSalon = '4';
        p4.areCovid = false;

        Pacient p5 = new Pacient();
        p5.id = 55;
        p5.nume = "Popa";
        p5.prenume = "Andreea";
        p5.afectiune = "dementa";
        p5.nrSalon = '5';
        p5.areCovid = true;


        Pacient p6 = new Pacient();
        p6.id = 66;
        p6.nume = "Ilie";
        p6.prenume = "Stefan";
        p6.afectiune = "covid";
        p6.nrSalon = '6';
        p6.areCovid = true;


        this.pacienti.add(p1);
        this.pacienti.add(p2);
        this.pacienti.add(p3);
        this.pacienti.add(p4);
        this.pacienti.add(p5);
        this.pacienti.add(p6);


    }

    public void afisarePacient() {
        for (int i = 0; i < this.pacienti.size(); i++) {
            System.out.println(this.pacienti.get(i).descrierePacient());
            System.out.println("\n");
        }
    }

    public Pacient findPacientByNumeSiPrenume(String nume, String prenume) {
        for (int i = 0; i < this.pacienti.size(); i++) {

            boolean equalsNume = pacienti.get(i).nume.equals(nume);
            boolean equalsPrenume = pacienti.get(i).prenume.equals(prenume);

            if (equalsNume && equalsPrenume) {
                return pacienti.get(i);
            }

        }
        return null;
    }


    public void addPacient(Pacient pacient) {
        this.pacienti.add(pacient);
    }

    public void removePacient(Pacient pacient) {
        this.pacienti.remove(pacient);

    }


    public void update(Pacient pacient) {


        Pacient deUpdatat = findPacientByNumeSiPrenume(pacient.nume, pacient.prenume);

        if (pacient.id != 0) {
            deUpdatat.id = pacient.id;
        }

        if (pacient.afectiune != null) {
            deUpdatat.afectiune = pacient.afectiune;
        }

        if (pacient.nrSalon != 0) {

            deUpdatat.nrSalon = pacient.nrSalon;
        }

    }

}
