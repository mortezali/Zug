package edu.hm.cs.swe2;

public class Main {

	public static void main(String[] args) {
		
		Locomotive train = new Locomotive(MotivePower.STEAM);
		
		Wagon GwDa = new Wagon (true, true);
		Wagon GwoDa = new Wagon (true, false);
		Wagon GwoDa2 = new Wagon (true, false);
		Wagon PwwDa = new Wagon (false, true);
		Wagon PwoDa = new Wagon (true, false);
		
		train.addWagon(PwoDa);
		train.addWagon(GwoDa2);
		
		train.printTrain();

	}

}
