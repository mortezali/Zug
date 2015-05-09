package edu.hm.cs.swe2;

public class Locomotive {

	private MotivePower motivePower;
	private Wagon next;
	private int id = 0;

	public Locomotive(MotivePower motivePower) {

		// Aufruf auf den anderen Konstruktor
		this(motivePower, null);

	}

	private static int totalSteamedPower = 0;
	private static int totalCreated = 0;

	public Locomotive(MotivePower motivePower, Wagon wagon) {

		this.motivePower = motivePower;
		this.next = wagon;
		totalCreated++;

		if (this.motivePower == MotivePower.STEAM) {
			totalSteamedPower++;
		}

	}

	public void addWagon(Wagon next) {

		if (next == null) {
			this.next = next;
			next.setId(id);
		}
		
		
		// TODO: Hier die Methode aus der Wagonklasse hinzuf�gen, die einen
		// Wagon hinzuf�gt
	
		Wagon wagon = new Wagon (true, true);
		wagon.addWagon(wagon);	
		
	}

	private String toString(int level) {

		return null;
	}

	// TODO: l�uft die 5 ebenen durch und ruft jeweils alle Ebenen auf.
	public String toString() {
		return toString();

	}

	// Erstellen Sie die Methode printTrain(), die die Darstellung des
	// kompletten Zuges als
	// Zeichenkette auf der Console ausgibt (Level 3, Anwenden).

	// TODO: Die Methode sollte durch printTrain() ersetzt werden und arbeitet
	// mit toStirng()
	public void printLocomotive(int level) {

		System.out.println("**    ******" + "\n" + "**    *     *" + "\n"
				+ "*************" + "* " + motivePower.toString() + "  *");
		System.out.println("**********->" + "\n" + " ***     *** ");
	}

	public Wagon getNext() {
		return next;
	}

	public int getId() {
		return id;
	}

	public static int getTotalCreated() {
		return totalCreated;
	}

	public static int getTotalSteamedPower() {
		return totalSteamedPower;
	}

	public void setMotivePower(MotivePower motivePower) {
		this.motivePower = motivePower;
	}

	public void setNext(Wagon next) {
		this.next = next;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void setTotalCreated(int totalCreated) {
		Locomotive.totalCreated = totalCreated;
	}

	public static void setTotalSteamedPower(int totalSteamedPower) {
		Locomotive.totalSteamedPower = totalSteamedPower;
	}

	public MotivePower getMotivePower() {
		return motivePower;
	}
}
