/**
 * Written methods: public void connectTo(Airport that), public void disconnectFrom(Airport that), 
 * public boolean equals(Object x), public int compareTo(Airport that), public boolean isConnectedTo(Airport that)
 * 
 * Airport class used to help run FlightNet class
 */

import java.util.*;

public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route to/from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	/**
	 * Adds the airport to the list of connections
	 * @param that
	 */
	public void connectTo(Airport that)
	{
		connections.add(that); 
	}

	/**
	 * Disconnects an airport that is connected to a chosen airport
	 * Does nothing if the two are not connected
	 * @param that
	 */
	public void disconnectFrom(Airport that)
	{
		for(Airport a : connections) {		
			if (a.isConnectedTo(that)) {	// conditional statement used to determine if the airport is connected 
				a.disconnectFrom(that); 	// so that it can be disconnected
			}
		}
	}
	
	/**
	 * Determines if one airport name matches with another
	 * @param x
	 * @return true or false
	 */
	public boolean equals(Object x)
	{
		Airport that = (Airport)x; 
		
		return this.compareTo(that) == 0; 
	}
	
	/**
	 * Compares the airport by name and assigns a value based on placement of name compared to another
	 * @param that
	 * @return nameCompare 
	 */
	public int compareTo(Airport that)
	{
		int nameCompare = this.name.compareTo(that.name);
		
		return nameCompare; 
	}
	
	/**
	 * Checks to see if the airport is connected to a given airport
	 * @param that
	 * @return isConnected
	 */
	public boolean isConnectedTo(Airport that)
	{
		boolean isConnected = false; 

		if(this.getConnections().contains(that)) {	// checks connection by seeing if the arraylist getConnections contains that airport
			isConnected = true; 
		}
		
		return isConnected;
	}
	
	
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
