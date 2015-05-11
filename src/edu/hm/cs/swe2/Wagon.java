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

/*	public boolean trainCarriesDangerousGoods(Wagon wagon) {

		if (wagon.isCarriesDangerousGoods()) {
			return true;

		} else {
			if (wagon.next != null) {
				trainCarriesDangerousGoods(wagon.next);
			}
		}
		return false;
	}*/
	public boolean trainCarriesDangerousGoods() {
		if (carriesDangerousGoods) {
			return true;
		} else if (next == null) {
			return false;
		} else {
			return next.trainCarriesDangerousGoods();
		}
	}
	
	

	/*public Wagon addWagon(Wagon wagon) {
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

	}*/
	
	/**
	 * Hängt den neuen Waggon hinter dem aktuellen Waggon ein.
	 * 
	 * @param newWagon
	 *            Der einzuhängende Waggon.
	 * @return Der erste Waggon des ggf. modifizierten Zuges
	 */
	public Wagon addWagon(Wagon newWagon) {
		if (newWagon.isPassengerWagon() && this.isPassengerWagon == false) {
			// Neuer Waggon ist Personenwaggon;
			// Zug enthält bisher nur Güterwaggons;
			// Personenwaggon also davor einfügen, sofern kein Gefahrgut im Zug
			if (this.trainCarriesDangerousGoods()) {
				// Restlicher Zug enthält Gefahrgut, Waggon nicht einfügen
				System.out
						.println("Personenwaggon kann nicht eingefügt werden, da Zug bereits Gefahrgut enthält");
				return this;
			} else {
				// Restlicher Zug enthält kein Gefahrgut, Waggon einfügen
				newWagon.setNext(next);
				return newWagon;
			}
		} else if (newWagon.getIsCarriesDangerousGoods() && this.isPassengerWagon) {
			// Neuer Waggon ist Güterwaggon mit Gefahrgut;
			// Zug enthält bereits Personenwaggons;
			// Neuer Waggon kann nicht eingefügt werden
			System.out
					.println("Zug enthält Personenwaggons; Gefahrgutwaggon kann nicht eingefügt werden");
			return this;
		} else {
			this.addWagon(newWagon, 1);
			return this;
		}
	}

	/**
	 * Hängt den neuen Waggon hinter dem aktuellen Waggon ein.
	 * 
	 * Bei Eintritt in diese Methode ist sichergestellt, dass der einzufügende
	 * Waggon hinter dem aktuellen Waggon einzuhängen ist, und dass nicht
	 * versucht wird, einen Gefahrgutwaggon in einen Personenzug einzuhängen.
	 * 
	 * @param newWagon
	 *            Der einzuhängende Waggon.
	 * @param numberOfWagons
	 *            Die Ordnungsnummer des aktuellen Waggons, an den der neue
	 *            Waggon angehängt werden soll.
	 */
	private void addWagon(Wagon newWagon, int numberOfWagons) {

		if (next == null) {
			// Zug hat keine weiteren Waggons
			if (newWagon.isPassengerWagon() == isPassengerWagon) {
				// Neuer Waggon und aktueller Waggon sind vom gleichen Typ
				newWagon.setId(numberOfWagons + 1);
			} else {
				// w ist der erste und letzte Güterwaggon in einem Personenzug
				newWagon.setId(1);
			}
			this.setNext(newWagon);
		} else if (next.isPassengerWagon() == isPassengerWagon) {
			// Nächster Waggon ist vom gleichen Typ wie aktueller Waggon; Zug
			// weiter durchlaufen
			next.addWagon(newWagon, numberOfWagons + 1);
		} else {
			// Nächster Waggon ist der erste Güterwaggon
			if (newWagon.isPassengerWagon()) {
				// Neuen Waggon als letzten Personenwaggon in den Zug einfügen,
				// vor die dann folgenden Güterwaggons
				newWagon.setId(numberOfWagons + 1);
				newWagon.setNext(next);
				this.setNext(newWagon);
			} else {
				// Waggonzähler zurücksetzen, um Anzahl der bestehenden
				// Güterwaggons zu ermitteln; Neuen Waggon als letzten
				// Güterwaggon hinten ans Zugende fügen
				next.addWagon(newWagon, 1);
			}
		}
	}
	

	private boolean isCarriesDangerousGoods() {
		return carriesDangerousGoods;
	}

	public boolean isPassengerWagon() {
		return isPassengerWagon;
	}

	public int getId() {
		return id;
	}

	public boolean getIsPassengerWagon() {
		return isPassengerWagon;
	}

	public boolean getIsCarriesDangerousGoods() {
		return carriesDangerousGoods;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNext(Wagon next) {
		this.next = next;
	}
}
