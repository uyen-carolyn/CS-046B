import java.io.*;

/**
 * Writes a fasta record to print writer. - (Homework Assignment Instructions) 
 */
public class FastaWriter 
{

	private PrintWriter thePrintWriter;
	
	public FastaWriter(PrintWriter thePrintWriter) {
		this.thePrintWriter = thePrintWriter;
	}
	
	/**
	 * Write the defline and sequence as two separate lines using PrintWriter.
	 * @param rec
	 * @throws IOException
	 */
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());

	}
}
