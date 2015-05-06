package edu.hm.cs.swe2;

public class Locomotive {

	private MotivePower motivePower;
	private Wagon next;
	private int id = 0;

	public Locomotive(MotivePower motivePower) {

//		this.motivePower = motivePower;
//		next = null; Aufruf auf den anderen Konstruktor
		this (motivePower, null);

	}

	public Locomotive(MotivePower motivePower, Wagon wagon) {
		
		this.motivePower = motivePower;
		this.next = wagon;
	

	}

	public void addWagon(Wagon next) {
		
		if(next == null){
			this.next = next;
			next.setId(id);
		}
			
	}

	public void printLocomotive(int level) {

		System.out.println("**    ******" + "\n" + "**    *     *" + "\n"
				+ "*************" + "* " + motivePower.toString() + "  *");
		System.out.println("**********->" + "\n" + " ***     *** ");
	}


}
