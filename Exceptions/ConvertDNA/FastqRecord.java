/**
 * FastqRecord contains the defline, sequence, and quality string
 * from a record in a fastq file. - (Homework Assignment Instructions) 
 */
public class FastqRecord implements DNARecord 
{	
	private String defline;
	private String sequence;
	private String quality; 
		
	/**
	 * Constructor for the FastqRecord class. 
	 * Checks first character of variable defline to determine if it starts with '@'.
	 * Throws an exception if it doesn't.
	 * @param defline
	 * @param sequence
	 * @param quality
	 * @throws RecordFormatException
	 */
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {
		if (defline.charAt(0) != '@') {
			throw new RecordFormatException ("Defline does not start with '@'");
		}
		else {
			this.defline = defline; 
		}
		
		this.sequence = sequence;
		this.quality = quality; 
	}
	
	/**
	 * The get methods (getDefline() and getSequence()) 
	 * that satisfy the DNARecord interface. 
	 */
	public String getDefline() {
		return defline; 
	}
	
	public String getSequence() {
		return sequence; 
	}
	
	/**
	 * The equals method (deflineEquals(), sequenceEquals(), and qualityEquals())
	 * checks for deep equality 
	 * @return true or false
	 */
	public boolean equals(Object x) {
		FastqRecord something = (FastqRecord) x; 
		
		if (!defline.equals(something.defline)) {
			return false; 
		}
		
		if(!sequence.equals(something.sequence)) {
			return false; 
		}
		
		if(!quality.equals(something.quality)) {
			return false; 
		}
		
		return true; 
	}
	
	/**
	 * Determines the quality based on whether it contains an exclamation mark
	 * Actual method is more complicated - (Homework Assignment Instructions) 
	 * @return qualityCheck
	 */
	public boolean qualityIsLow()
	{
		boolean qualityCheck = false; 
		if(quality.contains("!")) {
			qualityCheck = true; 
		}
		return qualityCheck; 
	} 
	
	/**
	 * Returns all the sums of the hashcodes of defline, sequence, and quality.
	 * @return sum
	 */
	public int hashCode()
	{
		int sum = defline.hashCode() + sequence.hashCode() + quality.hashCode();
		return sum; 
	}
}
