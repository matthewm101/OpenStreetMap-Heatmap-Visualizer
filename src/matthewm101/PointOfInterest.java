package matthewm101;
import java.util.Map;

/**
 * A class that stores the location and tags of an OpenStreetMap node.
 * @author Matthew M
 */
public class PointOfInterest {

    /**
     * The latitude of the point of interest.
     */
    private double lat;
    /**
     * The longitude of the point of interest.
     */
    private double lon;

    /**
     * A map of all the key-value tags that this point of interest contains.
     */
    private Map<String, String> descs;

    /**
     * Creates a new PointOfInterest object with the given latitude, longitude,
     * and map of key-value sets.
     *
     * @param lat   The latitude of the point.
     * @param lon   The longitude of the point.
     * @param descs A map of the tags of the point; each tag contains a key
     *              and a value.
     */
    public PointOfInterest(double lat, double lon, Map<String, String> descs) {
        this.lat = lat;
        this.lon = lon;
        this.descs = descs;
    }

    /**
     * Returns the key-value mappings of this point's tags.
     *
     * @return The map of the tags' key-value pairs.
     */
    public Map<String, String> getDescriptors() {
        return descs;
    }

    /**
     * Returns the latitude of the point.
     *
     * @return The latitude of the point.
     */
    public double getLatitude() {
        return lat;
    }

    /**
     * Returns the longitude of the point.
     *
     * @return The longitude of the point.
     */
    public double getLongitude() {
        return lon;
    }
}
