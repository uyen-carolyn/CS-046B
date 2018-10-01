package dna;

import java.io.*;
import java.util.*;

/**
 * Converts the file to either fastq or fasta, depending on what the file initially is. 
 */
public class FileConverter 
{
	private File fastq;
	private File fasta; 
	
	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq; 
		this.fasta = fasta; 
	}
	 
	/**
	 * Writes a fasta file given a fastq file, which converts the defline and quality as well. 
	 * @throws IOException
	 */
	public void convert() throws IOException
	{
		// Builds chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br); 

		// Builds chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw); 
		TreeSet<String> deflines = new TreeSet<String>(); 
		
		// Read, translate, write a fastq into a fasta file.
		FastqRecord fastQ; 
		while(true) {
			try {
				fastQ = fqr.readRecord(); 
				
				if (fastQ == null) {
					break; 
				}
				
				if (deflines.add(fastQ.getDefline()) == true && fastQ.qualityIsLow() == false) {
					FastaRecord fastA = new FastaRecord(fastQ); 
					faw.writeRecord(fastA);
				}  
			}
			
			catch(RecordFormatException e) {
				
			}
		}
		
		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close(); 
		fw.close();
		br.close(); 
		fr.close(); 
	}
	
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			
			converter.convert();
		}
		
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		
		System.out.println("Done");
	}
}
