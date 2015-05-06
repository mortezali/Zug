package edu.hm.cs.swe2;

public class Locomotive {

	private MotivePower motivePower;
	private Wagon next;
	private int id = 0;

	public Locomotive(MotivePower motivePower) {

		// this.motivePower = motivePower;
		// next = null; Aufruf auf den anderen Konstruktor
		this(motivePower, null);

	}

//	  Über einen Zähler ist zu verwalten, wie viele Lokomotiven bisher insgesamt erzeugt wurden. 
//	  Ein  weiterer  Zähler  dokumentiert,  wie  viele  dieser  Lokomotiven  mit  Dampf  getrieben 
//	  werden (Level 3, Anwenden). 
	//TODO: Überlegen, wie du Global einen counter hochzählen lassen könntest.
	public Locomotive(MotivePower motivePower, Wagon wagon) {

		this.motivePower = motivePower;
		this.next = wagon;

	}

	public void addWagon(Wagon next) {

		if (next == null) {
			this.next = next;
			next.setId(id);
		}
		// TODO: Hier die Methode aus der Wagonklasse hinzufügen, die einen
		// Wagon hinzufügt
	}



	private String toString(int level) {

		return printLocomotive(level);
	}

	//TODO: läuft die 5 ebenen durch und ruft jeweils alle Ebenen auf.
	public String toString() {
		return toString();

	}
//	Erstellen Sie die Methode  printTrain(), die die Darstellung des kompletten Zuges als 
//	Zeichenkette auf der Console ausgibt (Level 3, Anwenden).
	
	//TODO: Die Methode sollte durch printTrain() ersetzt werden und arbeitet mit toStirng()
	public void printLocomotive(int level) {

		System.out.println("**    ******" + "\n" + "**    *     *" + "\n"
				+ "*************" + "* " + motivePower.toString() + "  *");
		System.out.println("**********->" + "\n" + " ***     *** ");
	}
	
}
