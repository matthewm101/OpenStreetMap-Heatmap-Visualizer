package matthewm101;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import javax.swing.SwingWorker;

/**
 * An XML parser that reads the nodes of an OpenStreetMap xml file.
 * @author Matthew M
 */
public class PointOfInterestParser extends DefaultHandler {

    /**
     * The list of all points of interest parsed by this parser.
     */
    private Stack<PointOfInterest> objects = new Stack<>();

    /**
     * The map of all tags of the point of interest currently being parsed.
     */
    private HashMap<String, String> currentTagDescs;

    /**
     * The minimum latitude of the map data's bounds.
     */
    private double minLat;
    /**
     * The maximum latitude of the map data's bounds.
     */
    private double maxLat;
    /**
     * The minimum longitude of the map data's bounds.
     */
    private double minLon;
    /**
     * The maximum longitude of the map data's bounds.
     */
    private double maxLon;

    /**
     * A reference to the task that is using this class. If the task is
     * cancelled, this class's parsing process will quickly terminate.
     */
    private SwingWorker task;
        
    /**
     * Parses the xml file with the provided file name.
     * @param input The file to parse.
     * @param task The SwingWorker that may send cancellation requests.
     * @return The list of all points of interest found in the file.
     * @throws IOException If the file is not found.
     */
    public List<PointOfInterest> parse(File input, SwingWorker task)
        throws IOException {
        this.task = task;
        if (!input.exists()) {
            throw new FileNotFoundException(
                "Could not find the specified file.");
        }
        SAXParser reader;
        try {
            reader = SAXParserFactory.newInstance().newSAXParser();
            reader.parse(input, this);
        } catch (ParserConfigurationException e) {
            System.err.println("A serious error occurred when configuring the"
                    + " XML parser.");
        } catch (SAXException e) {
            //An SAXException is thrown to easily terminate the parse once
            //the way section is reached.
            //SAXExceptions are also thrown when the process is cancelled.
        }
        return objects;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (task.isCancelled() || qName.equalsIgnoreCase("way")) {
            throw new SAXException();
        } else if (qName.equalsIgnoreCase("node")) {
            currentTagDescs = new HashMap<>();
            double lat = Double.parseDouble(attributes.getValue("lat"));
            double lon = Double.parseDouble(attributes.getValue("lon"));
            objects.add(new PointOfInterest(lat, lon, currentTagDescs));
        } else if (qName.equalsIgnoreCase("tag")) {
            currentTagDescs.put(attributes.getValue("k"),
                    attributes.getValue("v"));
        } else if (qName.equalsIgnoreCase("bounds")) {
            minLat = Double.parseDouble(attributes.getValue("minlat"));
            maxLat = Double.parseDouble(attributes.getValue("maxlat"));
            minLon = Double.parseDouble(attributes.getValue("minlon"));
            maxLon = Double.parseDouble(attributes.getValue("maxlon"));
        }
    }

    /**
     * Returns the latitude and longitude bounds of the parsed data.
     * @return An array: [minLat, maxLat, minLon, maxLon]
     */
    public double[] getBounds() {
        double[] bounds = new double[4];
        bounds[0] = minLat;
        bounds[1] = maxLat;
        bounds[2] = minLon;
        bounds[3] = maxLon;
        return bounds;
    }
}
