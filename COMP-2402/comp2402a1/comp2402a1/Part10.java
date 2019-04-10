package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Part10 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		
		// Current List
		List<String> readingArrayList = new ArrayList<>();
		
		// Reading our lines 
		for (String line = r.readLine(); line != null; line = r.readLine()) {
            
            readingArrayList.add(line);
		}

		// String Max
		// Index USed 
		String obtained_max_value;
		int obtained_index_value;

		while (readingArrayList.size() > 0) {
			
			// Gathering Max Value 
			// Printing Value 
			// Checking Index 
			// Reading List

			obtained_max_value = Collections.max(readingArrayList);
			w.println(obtained_max_value);
			obtained_index_value = readingArrayList.lastIndexOf(obtained_max_value);
			readingArrayList.subList(0, obtained_index_value+1).clear();

		}
	}	

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
