package comp2402a1;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Part2 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */

	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		//Here, we are creating a lsit for the odd and even numbers that we have
		List<String> value_identify_even = new ArrayList<>();
		List<String> value_identify_odd = new ArrayList<>();

		//Here we will keep track of what line we are on
		int line_identify = 0;

		for (String line = r.readLine(); line != null; line = r.readLine()) {
				//Here we are going to check if we are on a even line
				if (line_identify % 2 == 0) {
					value_identify_even.add(line);
				}
				else {
					value_identify_odd.add(line);
				}

				line_identify++;
		}

		for (String text : value_identify_even) {
				w.println(text); //output
		}
		for (String text : value_identify_odd) {
				w.println(text); //output
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
