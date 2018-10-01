package dna;

/**
 * Allows the constructor for FastqRecord to throw an exception 
 * by overriding the Exception class. 
 * @author Uyen Nguyen
 */

public class RecordFormatException extends Exception
{
	public RecordFormatException(String message) {
		super(message);
	}
}
