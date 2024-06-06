package swen221Ass1;

import java.util.Set;

public record Building(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) {
    //Constructor for a building with only a primary address
    public Building(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) {
        this.boundingBox = boundingBox;
        this.primaryAddress = primaryAddress;
        this.secondaryAddresses = Set.copyOf(secondaryAddresses);

        if (boundingBox == null || primaryAddress == null || secondaryAddresses == null) {
            throw new NullPointerException("Parameters cannot be null");
        }
    }

    //Method for creating a building with only a primary address
    public static Building of(GeoBox boundingBox, Address primaryAddress) {
        if (boundingBox == null || primaryAddress == null) {
            throw new NullPointerException("Parameters cannot be null");
        }
        return new Building(boundingBox, primaryAddress, Set.of());
    }

    //Method for creating a building with a primary address and secondary addresses
    public static Building of(GeoBox boundingBox, Address primaryAddress, Set<Address> secondaryAddresses) {
    	if (boundingBox == null || primaryAddress == null || secondaryAddresses == null) {
            throw new NullPointerException("Parameters cannot be null");
        }
    	if (secondaryAddresses.isEmpty()) {
    		throw new IllegalArgumentException("illegal arguments");
    	}
        return new Building(boundingBox, primaryAddress, secondaryAddresses);
    }
}

