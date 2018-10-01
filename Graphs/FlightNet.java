/**
 * Models a company's air route. 
 */

import java.util.HashSet;
import java.util.ArrayList; 

public class FlightNet extends HashSet<Airport>{
	/**
	 * checks if the model contains an airport with a specific name
	 * @param name
	 * @return isAvailable
	 */
	public boolean nameIsAvailable(String name) {
		boolean isAvailable = true; 
		
		for(Airport a : this) {		// checks all possible connections that may have that name. 
			if (a.getName().equals(name)) {
				isAvailable = false; 
			}
		}
		
		return isAvailable; 
	}

	/**
	 * Connects two airplanes, a1 and a2, to each other. Method disconnect() is similar
	 * @param a1
	 * @param a2
	 */
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		
		a2.connectTo(a1);
	}
	
	/**
	 * Disconnects two airplanes, a1 and a2, from each other. Method connect() is similar
	 * @param a1
	 * @param a2
	 */
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		
		a2.disconnectFrom(a1);
	}
	
	/**
	 * removes the airport and disconnects it from any connections it had before
	 * @param removeMe
	 */
	public void removeAndDisconnect(Airport removeMe) {
		remove(removeMe); 
		
		for (Airport a : this) {			// loop used to disconnect all connections of removeMe
			if(removeMe.isConnectedTo(a)) {
				disconnect(removeMe, a); 
			}
		}
	}
	
	/**
	 * Checks all the airports in the model and returns the first airport
	 * who's coordinates are within the maximum distance
	 * @returns null
	 */
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		ArrayList<Airport> aero = new ArrayList<>(this); // creates an array of airports to compare distance to
		
		int distance = 0;
		Airport nearest = null; 
		int nearX = 0;
		int nearY = 0; 
		
		for(Airport a : aero) {
			// used distance formula to find the distance by taking the square root of the sum of the differences between the two coordinates.
			// distance = sqrt((x-a)^2 + (y-b)^2)
			
			nearX = x - a.getX(); 
			nearY = y - a.getY();
			
			distance = (int) Math.sqrt(nearX*nearX + nearY*nearY); 
			
			if (distance <= maximumDistance) {
				nearest = a;
				
				break; // since the program asks for the first airport within distance
			}
		}
		return nearest; 
	}
	
	/**
	 * Provided class from Canvas
	 * @return net
	 */
	public static FlightNet makeTestInstance()
	{
	  Airport sfo = new Airport("SFO",  31, 207);
	  Airport lax = new Airport("LAX",  81, 291);
	  Airport jfk = new Airport("JFK", 724, 169);
	  Airport mia = new Airport("MIA", 667, 455);
	  Airport sea = new Airport("SEA",  92,  31);

	  FlightNet net = new FlightNet();

	  net.add(sfo);
	  net.add(lax);
	  net.add(jfk);
	  net.add(mia);
	  net.add(sea);

	  net.connect(sfo, sea);
	  net.connect(sfo, jfk);
	  net.connect(sfo, lax);
	  net.connect(jfk, mia);
	  net.connect(jfk, sea);

	  return net;
	}
}
