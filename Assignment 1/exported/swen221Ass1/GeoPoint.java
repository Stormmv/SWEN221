package swen221Ass1;

public record GeoPoint(double latitude, double longitude) {
	
	//function to return string with required number of d.p
	public String toString(int precision) {
	    if (precision < 0) {
	        throw new IllegalArgumentException("precision cannot be negative");
	    }
	    int prec = (precision >= 0) ? precision : 8;
	    return String.format("[latitude: %." + prec + "f, longitude: %." + prec + "f]", latitude, longitude);
	}
	
	//function to return string with no set d.p
	public String toString() {
	    int prec = 8;
	    return String.format("[latitude: %." + prec + "f, longitude: %." + prec + "f]", latitude, longitude);
	}
    
	//check to see if points are in range when creating a new GeoPoint
    public GeoPoint {
        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude >= 180) {
        	throw new IllegalArgumentException("latitude and longitude must be in the range -90 -- +90 and -180 -- +180");
        }
    }
    
    //averages the GeoPoints while keeping in mind the Antimeridian
    public GeoPoint average(GeoPoint other) {
        double avgLatitude = (this.latitude + other.latitude) / 2;
        double dLon = other.longitude - this.longitude;
        double avgLongitude = this.longitude + ((dLon > 180) ? (dLon - 360) : (dLon < -180) ? (dLon + 360) : dLon) / 2;
        return new GeoPoint(avgLatitude, avgLongitude);
    }
}
