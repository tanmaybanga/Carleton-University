package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part6 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */


	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {

		// Here we are creating a tree set, this will comapre based off of the string 
			// length that has been done 
		// Once done, we will look for any differences between the strings 
		// If there are no differences that are found, we will comapre the two using 
		//		the usual solving methods 
		// If there is nothing found, we will return the dfference seen

		Set<String> treeSetVarible = new TreeSet<>(new Comparator<String>() {
			public int compare(String treeSetVarible1, String treeSetVarible2) {
				int comparable = treeSetVarible1.length() - treeSetVarible2.length(); // Comparison begins
				if (comparable == 0) {
					return treeSetVarible1.compareTo(treeSetVarible2);
				}

				return comparable; // Reset and return
			}

		});

		// Final Added
		for (String line = r.readLine(); line != null; line = r.readLine()) {

				treeSetVarible.add(line);

		}

		// Final Output
		for (String text : treeSetVarible) {

				w.println(text);

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
