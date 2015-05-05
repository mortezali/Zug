package edu.hm.cs.swe2;

public enum MotivePower {

	STEAM, DIESEL, ELECTRIC;

	@Override
	public String toString() {

		switch (this) {
		case STEAM:
			return "Steam   ";
		case DIESEL:
			return "Diesel  ";
		case ELECTRIC:
			return "Electric";

		default:
			return "        ";
		}

	}

}