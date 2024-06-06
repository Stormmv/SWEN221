package swen221Ass1;

public record Street(GeoBox boundingBox, String name, int length) {
    
	//checks to see if any of the parameters are null or empty
	public Street {
        if (boundingBox == null || name == null || name.isEmpty() || length <= 0) {
            throw new NullPointerException("Invalid parameters for Street");
        }
    }
	
	//returns the name
    public String toString() {
    	return(name);
    }
    
    //returns the length
    public int length() {
    	return(length);
    }
    
    //returns the GeoBox the street is in
    public GeoBox boundingBox() {
    	return(boundingBox);
    }
}
