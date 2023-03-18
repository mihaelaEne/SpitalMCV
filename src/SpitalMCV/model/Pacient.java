package SpitalMCV.model;

public class Pacient {
    public int id;
    public String nume;
    public String prenume;
    public String afectiune;
    public char nrSalon;
    public boolean areCovid;


    public String descrierePacient() {
        String text = "";
        text += "Id-ul pacientului este: " + this.id + "\n";
        text += "Numele de familie al pacientului este: " + this.nume + "\n";
        text += "Prenumele pacientului este: " + this.prenume + "\n";
        text += "Afectiunea de care sufera " + this.nume + " " + this.prenume + " este " + this.afectiune + "\n";
        text += "Nr salonului este (de la 1 la 9) este: " + this.nrSalon + "\n";
        text += this.nume + this.prenume + " are covid?" + "\n" + (this.areCovid ? "da" : "nu");


        return text;
    }
}
