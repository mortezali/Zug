package edu.hm.cs.swe2;

public class Wagon {
	private int id = 0;

	private final boolean isPassengerWagon;
	private final boolean carriesDangerousGoods;
	private Wagon next;

	public Wagon(boolean isPassengerWagon, boolean carriesDangerousGoods) {

		this.isPassengerWagon = isPassengerWagon;

		if (this.isPassengerWagon() && carriesDangerousGoods) {

			System.out
					.println("Personenwaggon, darf kein Gefahrgut enthalten! Waggon nicht beladen!");

			this.carriesDangerousGoods = false;

		} else {

			this.carriesDangerousGoods = carriesDangerousGoods;
		}

	}

/*	public String printWagon(int level) {
		String sign = "";
		if (!this.isPassengerWagon()) {
			sign = "f";
			if (this.isCarriesDangerousGoods()) {
				System.out.println("Güterwaggon mit Gefahrgut");
			} else
				System.out.println("Güterwaggon ohne Gefahrgut");
		}

		else {
			System.out.println("Personenwaggon");
			sign = "p";
		}

		System.out.println("**********" + "\n" + "* " + sign + id);
		if (getIsCarriesDangerousGoods()) {

			System.out.println(" dg");

		} else
			System.out.println("    ");

		System.out.println(" *" + "\n" + "**********->" + "\n" + " *** "
				+ " *** ");

}	*/
	
	public String toString(int level) {

		String result = "";

		switch (level) {
		case 0:
			// Darstellen der R�der
			result += " ***  ***   ";
			break;
		case 1:
			// Darstellen von Bodenplatte und Anh�ngerkupplung
			result += "**********->";
			break;
		case 2:
			// Darstellen von Waggonbegrenzung und Beschriftung
			result += "* ";
			if (isPassengerWagon) {
				result += "p";
			} else {
				result += "f";
			}
			if (id < 10) {
				result += "0";
			}
			result += id + " ";
			if (carriesDangerousGoods) {
				result += "dg";
			} else {
				result += "  ";
			}
			result += " *  ";
			break;
		case 3:
			// Darstellen der Deckelplatte
			result += "**********  ";
			break;
		}
		if (next == null) {
			// Zeilenumbruch, falls Zugende erreicht ist
			result += "\n";
		} else {
			// Gleiche Zeile f�r n�chsten Waggon darstellen
			result += next.toString(level);
		}

		return result;
	}

	public boolean trainCarriesDangerousGoods(Wagon wagon) {

		if (wagon.isCarriesDangerousGoods()) {
			return true;

		} else {
			if (wagon.next != null) {
				trainCarriesDangerousGoods(wagon.next);
			}
		}
		return false;
	}

	public Wagon addWagon(Wagon wagon) {
		if (this.next != null) {
			if (wagon.isCarriesDangerousGoods()) {

				if (this.isPassengerWagon()) {
					System.out
							.println("Zug enthält PersonenWaggons; Gefahrgutwaggon kann nicht eingefügt werden");
					return this;
				}
				if (this.next != null) {
					if (!wagon.isCarriesDangerousGoods()) {
						if (!wagon.isPassengerWagon()) {

							System.out
									.println("Zug enthält Gefahrgutwaggon; PersonenWaggons kann nicht eingefügt werden");

						}
						return this;
					}
				}

			}
			if (wagon.isPassengerWagon()) {
				if (!this.isPassengerWagon()) {

					wagon.id = 1;
					wagon.next = this;
					return wagon;
				}

			}
		}

		this.addWagon(wagon, id);
		return this;

	}

	private void addWagon(Wagon wagon, int id) {
		if (wagon.isPassengerWagon()) {
			if (wagon.isCarriesDangerousGoods()) {

				System.out
						.println("Zug enthält Gefahrgutwaggon; Personenwaggon kann nicht eingefügt werden");
			} else if (this.next.isPassengerWagon()) {
				this.next.addWagon(wagon, id);
			} else {
				wagon.id = this.id + 1;
				wagon.next = this.next;
				this.next = wagon;
			}

		} else {
			if (this.next == null) {
				this.next = wagon;
				wagon.id = this.id + 1;

			} else {
				this.next.addWagon(wagon, id);
			}
		}

	}

	private boolean isCarriesDangerousGoods() {
		return true;
	}

	public boolean isPassengerWagon() {
		return true;
	}

	public int getId() {
		return id;
	}

	public boolean getIsPassengerWagon() {
		return true;
	}

	public boolean getIsCarriesDangerousGoods() {
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNext(Wagon next) {
		this.next = next;
	}
}
