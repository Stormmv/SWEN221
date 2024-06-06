package swen221Ass1;

public record Address(Street street, City city, String address) {
	
	//checks to make sure that none of the parameters are null
	public Address{
		if (street == null || city == null || address == null) {
			throw new NullPointerException("null vars");
		}
	}
	
	//returns the street the address is on
	public Street street() {
		return street;
	}
	
	//returns the city of the address
	public City city() {
		return city;
	}
	
	//returns the address
	public String number() {
		return address;
	}
}
