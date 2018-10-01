/**
 * FastaRecord contains the defline and sequence string
 * from a record in a fastq file. - (Homework Assignment Instructions) 
 */
public class FastaRecord implements DNARecord 
{	
	private String defline; 
	private String sequence; 
	
	/**
	 * Constructor for the FastaRecord class. 
	 * Similar to the FastqRecord class with a few differences. 
	 * @param defline
	 * @param sequence
	 * @throws RecordFormatException
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException {
		if (defline.charAt(0) != '>') {
			throw new RecordFormatException ("Defline does not start with '>'");
		}
		else {
			this.defline = defline; 
		}
		
		this.sequence = sequence; 
	}
	
	/**
	 * Initializes defline and sequence with the values from FastqRecord class. 
	 * Changes the first character from defline into '>'
	 * @param fastqRec
	 */
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = fastqRec.getDefline();
		if(fastqRec.getDefline().charAt(0) == '@')
		{
		    this.defline = ">" + fastqRec.getDefline().substring(1);
		}
		this.sequence = fastqRec.getSequence(); 
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
	 * The equals method (deflineEquals() and sequenceEquals())
	 * checks for deep equality 
	 * @return true or false
	 */
	public boolean equals(Object x) {
		FastqRecord something = (FastqRecord) x; 
		
		if (!defline.equals(something.getDefline())) {
			return false; 
		}
		
		if(!sequence.equals(something.getSequence())) {
			return false; 
		}
		
		return true; 
	}
	/**
	 * Returns all the sums of the hashcodes of defline and sequence.
	 * @return sum
	 */
	public int hashCode()
	{
		int sum = defline.hashCode() + sequence.hashCode();
		return sum; 
	}
}
