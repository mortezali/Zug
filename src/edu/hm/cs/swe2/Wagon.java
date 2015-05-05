package edu.hm.cs.swe2;

public class Wagon {

	int id = 0;

	private final boolean isPassengerWagon;
	private final boolean carriesDangerousGoods;
	private Wagon next;

	public Wagon(boolean isPassengerWagon, boolean carriesDangerousGoods) {

		this.isPassengerWagon = isPassengerWagon;

		if (this.isPassengerWagon() && carriesDangerousGoods) {

			System.out
					.println("Personenwaggon darf kein Gefahrgut enthalten! Waggon nicht beladen!");

			this.carriesDangerousGoods = false;

		} else {

			this.carriesDangerousGoods = carriesDangerousGoods;
		}

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

	public void printWagon(int level) {
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

				if (this.next.isPassengerWagon()) {
					System.out
							.println("Zug enthält PersonenWaggons; Gefahrgutwaggon kann nicht eingefügt werden");
				}

			}
			if (wagon.isPassengerWagon()) {
				if (!this.next.isPassengerWagon()) {

					wagon.id = 1;
					wagon.next = this.next;
					this.next = wagon;
					return wagon;
				}

			}
		}

		this.addWagon(wagon, id);
		return wagon;

	}

	void addWagon(Wagon wagon, int id) {
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
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isPassengerWagon() {
		return true;
	}

}
