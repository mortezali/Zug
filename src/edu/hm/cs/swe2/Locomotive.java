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

		if (this.next == null) {
			this.next = next;
			next.setId(1);
		} else {
			this.next = this.next.addWagon(next);
		}

	}

	

/*	// TODO: l�uft die 5 ebenen durch und ruft jeweils alle Ebenen auf.
	public String toString() {
		return toString();

	}*/
	
public String toString() {
		
		String result = "";
		
		// Ruft private Hilfsmethode auf; 
		// Auszugebende Zeile �ber Parameter i gesteuert 
		for (int i=5; i>=0; i--) {
		  result += this.toString(i);
		}
		result += "\n";
		
		return result;
	}

	// Erstellen Sie die Methode printTrain(), die die Darstellung des
	// kompletten Zuges als
	// Zeichenkette auf der Console ausgibt (Level 3, Anwenden).

	// TODO: Die Methode sollte durch printTrain() ersetzt werden und arbeitet
	// mit toStirng()
/*	public String toString(int level) {
		
		String output = "";
		
		switch(level){
		case 5 : 
			
			
			break;
			
		case 4 :
				
				break;
		case 3 :
			
			break;
		case 2:
			break;
		case 1:
			break;
		case 0 :
			break;
			default:
				break;
		}
return output;

	}*/

private String toString(int level) {

	String result = "";
	switch (level) {
	case 0:
		// Erzeugen der R�der
		result += " ***    ***   ";
		break;
	case 1:
		result += "************->";
		break;
	case 2:
		result += "* " + motivePower.toString()  + " *  ";
		break;
	case 3:
		result += "************  ";
		break;
	case 4:
		result += " **    *   *";
		break;
	case 5:
		result += " **   ******";
		break;
	}
	if (next == null || level == 4 || level == 5) {
		result += "\n";
	} else {
		result += next.toString(level);
	}
	
	return result;
}
	
	public void printTrain() {
		// �ffentlich aufrufbare Methode zum Drucken eines Zugs;
		// Ruft gleichnamige private Ausgabemethode auf; 
		// Auszugebende Zeile �ber Parameter i gesteuert 
		System.out.println(this.toString());
	}
//		System.out.println("**    ******" + "\n" + "**    *     *" + "\n"
//				+ "*************" + "* " + motivePower.toString() + "  *");
//		System.out.println("**********->" + "\n" + " ***     *** ");
	

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
