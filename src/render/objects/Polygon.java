package render.objects;

import java.util.ArrayList;
import java.util.Locale;

import graph.*;
import render.ScadObject;

public class Polygon implements ScadObject {

	// the ArrayList of Points used by the Polygon
	private ArrayList<Vector> points;

	// the layout String for creating the Polygon
	final static String polygon = "polygon(%1s,10);\n";

	// the layout String for extruding the Polygon
	final static String linear_extrude = "linear_extrude(%1$.2f, center = true){\n%2$s}";

	// constructor using ArrayList of points
	/**
	 * Creates a new Polygon object using an ArrayList of position vectors.
	 * 
	 * @param points
	 *            the ArrayList of position vectors
	 */
	public Polygon(ArrayList<Vector> points) {
		this.points = points;
	}
	
	public Polygon(Edge e){
		points = new ArrayList<>();
		ArrayList<Node> nodes = e.getFace().getNodes();
		for(Node n : nodes){
			getPoints().add(n.getOrigin());
		}
	}

	// getter - setter
	// getting the ArrayList of points
	/**
	 * Returns the ArrayList of position vectors.
	 * 
	 * @return the ArrayList of vectors
	 */
	public ArrayList<Vector> getPoints() {
		return points;
	}

	// setting the ArrayList of points
	/**
	 * Overrides the ArrayList of position vectors with a new ArrayList.
	 * 
	 * @param points
	 *            the new ArrayList of position vectors
	 */
	public void setPoints(ArrayList<Vector> points) {
		this.points = points;
	}

	// printing the String to create the Polygon
	/**
	 * Prints a String used for creating the Polygon.
	 */
	@Override
	public String toString() {
		String s= "[";
		for (Vector p : points){
		s = s.concat(p.toScadString() + ", ");
		}
		s = s.substring(0,s.length()-2);
		s = s.concat("]");
		
		
		 s = String.format(Locale.UK, polygon, s);
		
		return (String.format(Locale.UK, linear_extrude, 1.0, s));
	}

}