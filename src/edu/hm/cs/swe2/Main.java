package edu.hm.cs.swe2;

public class Main {

	public static void main(String[] args) {

		Locomotive train = new Locomotive(MotivePower.STEAM);

		Wagon GwDa = new Wagon(true, true);
		Wagon GwoDa = new Wagon(true, false);
		Wagon GwoDa2 = new Wagon(true, false);
		Wagon PwwDa = new Wagon(false, true);
		Wagon PwoDa = new Wagon(true, false);

		train.addWagon(PwoDa);
		train.addWagon(GwoDa2);
		train.addWagon(GwDa);
		train.addWagon(GwoDa);
		train.addWagon(PwwDa);

		train.printTrain();

		Locomotive train1 = new Locomotive(MotivePower.DIESEL);

		Wagon GwDa1 = new Wagon(true, true);
		Wagon GwoDa1 = new Wagon(true, false);
		Wagon GwoDa3 = new Wagon(true, false);
		Wagon PwwDa1 = new Wagon(false, true);
		Wagon PwoDa2 = new Wagon(true, false);

		train1.addWagon(GwoDa1);
		train1.addWagon(GwoDa3);
		train1.addWagon(PwwDa1);
		train1.addWagon(PwoDa2);
		train1.addWagon(GwDa1);
	

		train1.printTrain();
		
		
		Locomotive train2 = new Locomotive(MotivePower.ELECTRIC);

		Wagon GwDa5 = new Wagon(true, true);
		Wagon GwDa6 = new Wagon(true, false);
		Wagon GwDa7 = new Wagon(true, false);
		Wagon GwDa8 = new Wagon(false, true);
		Wagon GwDa9 = new Wagon(true, false);

		train2.addWagon(GwDa5);
		train2.addWagon(GwDa6);
		train2.addWagon(GwDa7);
		train2.addWagon(GwDa8);
		train2.addWagon(GwDa9);
	

		train2.printTrain();

	}

}
