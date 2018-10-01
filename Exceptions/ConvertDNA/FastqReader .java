import java.io.*;

/**
 * Reads the lines from a BufferedReader to build a FastqReader. 
 */

public class FastqReader 
{
	private BufferedReader br; 
	
	public FastqReader(BufferedReader br) {
		this.br = br; 
	}
	
	/**
	 * Returns next record in the file, or null if EOF (end-of-file).
	 * Reads the next three lines and returns a FastqRecord if it can be constructed. 
	 * @return null or newFast
	 * @throws IOException
	 * @throws RecordFo rmatException
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		String deflineR = br.readLine();
		
		// Read the defline from the BufferedReader and return null if it reads null.
		// This indicates the end of the file. 
		if (deflineR == null) {
			return null;
		}
		
		// Reads the three lines after defline and returns a constructed FastqRecord.
		else {
			
			String sequenceR = br.readLine(); 
			String plus = br.readLine();
			String qualityR = br.readLine();
			FastqRecord newFast = new FastqRecord(deflineR, sequenceR, qualityR);
			
			return newFast; 
		}
	}
}
