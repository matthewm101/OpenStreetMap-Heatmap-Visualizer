package matthewm101;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A utility class that filters out OpenStreetMap points of interest based on
 * whether they have specific tags.
 * @author Matthew M
 */
public class StreetMapDataInterpreter {

    /**
     * Returns a list of POIs that meet at least one of the criteria in the
     * criteria list.
     * @param source The starting list of POIs.
     * @param criteria The criteria, one of which each POI should match.
     * @return A list containing all POIs that meet at least one criterion.
     */
    public static List<PointOfInterest> filter(List<PointOfInterest> source,
                       List<Entry<String, String>> criteria) {
        return sift(source, criteria);
    }

    /**
     * Using a list of PointOfInterest objects and a list of criteria,
     * this method returns only the objects in the given list that pass at
     * least one of the given criteria.
     *
     * @param input     A list of PointOfInterest objects to sift through.
     * @param criteria  A list of criteria. Criteria will be handled as such:
     *                  The key must be nonnull.
     *                      Any nonnull keys will be ignored.
     *                  If the value is null,
     *                      all POIs that contain the key will be returned.
     *                  If the value is nonnull,
     *                      all POIs that contain the key-value pair
     *                      will be returned.
     * @return The list of all PointOfInterest objects provided by the input
     *         that meet at least one of the given criteria.
     */
    private static List<PointOfInterest> sift(List<PointOfInterest> input,
                    List<Entry<String, String>> criteria) {
        ArrayList<PointOfInterest> matches = new ArrayList<>();
        for (PointOfInterest point : input) {
            boolean meetsAllCriteria = false;
            for (Entry<String, String> crit : criteria) {
                String lowercaseKey = crit.getKey().toLowerCase();
                Map<String, String> descs = point.getDescriptors();
                Set<String> keySet = descs.keySet();
                if (keySet.contains(lowercaseKey)) {
                    if (crit.getValue() == null
                        || descs.get(lowercaseKey).equals(crit.getValue())) {
                        meetsAllCriteria = true;
                        break;
                    }
                }
            }
            if (meetsAllCriteria) {
                matches.add(point);
            }
        }
        return matches;
    }
}
