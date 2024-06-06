package swen221Ass1;

public record GeoBox(GeoPoint ne, GeoPoint sw) {
    
	//when creating a GeoBox, will validate it with the given NE and SW GeoPoints
	public GeoBox {
        validateGeoBox(ne, sw);
    }

	//validates the GeoPoints to make sure that they are in range to create a GeoBox
    private static void validateGeoBox(GeoPoint ne, GeoPoint sw) {
        double neLongitude = ne.longitude();
        double swLongitude = sw.longitude();

        if (ne.latitude() < sw.latitude() || (!crossesAntimeridian(neLongitude, swLongitude) && neLongitude < swLongitude)) {
            throw new IllegalArgumentException("NE must be north and east of SW");
        }

        double latitudeDifference = Math.abs(ne.latitude() - sw.latitude());
        double longitudeDifference;

        if (crossesAntimeridian(neLongitude, swLongitude)) {
            longitudeDifference = (neLongitude + 360 - swLongitude) % 360;
        } else {
            longitudeDifference = Math.abs(neLongitude - swLongitude);
        }

        if (latitudeDifference > 30 || longitudeDifference > 30) {
            throw new IllegalArgumentException("Latitude and longitude must be within 30 degrees");
        }

        if (ne.latitude() > 80 || sw.latitude() < -80) {
            throw new IllegalArgumentException("Latitude must be within 80 degrees of the equator");
        }
    }

    //if crossing the Antimeridian, will calculate the shortest point so that it is not out of range
    private static boolean crossesAntimeridian(double lon1, double lon2) {
        return Math.abs(lon1 - lon2) > 180;
    }

    //returns the SE point of the GeoBox
    public GeoPoint se() {
        return new GeoPoint(sw.latitude(), ne.longitude());
    }

    //returns the NW point of the GeoBox
    public GeoPoint nw() {
        return new GeoPoint(ne.latitude(), sw.longitude());
    }
    
    //returns the center point of the GeoBox
    public GeoPoint center() {
        return ne.average(sw);
    }
}
