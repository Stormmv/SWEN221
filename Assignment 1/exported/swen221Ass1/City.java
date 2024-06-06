package swen221Ass1;

import java.util.HashSet;
import java.util.Set;

public class City {
	
	//stores the name, population, and streets in the city
    private final String name;
    private int population;
    private Set<Street> streets;

    //if name is null or population is negative then will throw error, if not then will create a new city
    public City(String name, int population) {
        if (name == null) {
            throw new NullPointerException("cant be null");
        }
        if (population < 0) {
        	throw new IllegalArgumentException("cant be negative");
        }
        this.name = name;
        this.population = population;
        this.streets = new HashSet<>();
    }
    
    //adds a street to the set
    public void addStreet(Street newStreet) {
        streets.add(newStreet);
    }

    //returns the set of streets
    public Set<Street> streets() {
        return new HashSet<>(streets);
    }

    //returns name of city
    public String name() {
        return name;
    }
    
    //changes the population of the city then returns it
    public int population(int newpop) {
        if (newpop < 0) {
        	throw new IllegalArgumentException("cant be negative");
        }
        if (newpop >= 0){this.population = newpop;}
    	return population;
    }
    
    //returns the population of the city
    public int population() {
    	return population;
    }
}