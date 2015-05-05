package edu.hm.cs.swe2;

public class Locomotive {

	private MotivePower motivePower;
	private Locomotive locomotive;
	private Wagon next;
	private int id = 0;

	public Locomotive(MotivePower motivePower, Locomotive locomotive) {

		this.motivePower = motivePower;
		this.locomotive = null;

	}

	public Locomotive(MotivePower motivePower, Wagon wagon) {

		this.locomotive = null;

	}

	public void addWagon(Wagon next) {
		if (next.isPassengerWagon()) {
			if (next.getIsCarriesDangerousGoods()) {

				System.out
						.println("Zug enthält Gefahrgutwaggon; Personenwaggon kann nicht eingefügt werden");
			} else if (this.next.isPassengerWagon()) {
				this.next.addWagon(next, id);
			} else {
				next.id = this.id + 1;
				Wagon.next = this.next;
				this.next = next;
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

	public void printLocomotive(int level) {

		System.out.println("**    ******" + "\n" + "**    *     *" + "\n"
				+ "*************" + "* " + motivePower.toString() + "  *");
		System.out.println("**********->" + "\n" + " ***     *** ");
	}


}
