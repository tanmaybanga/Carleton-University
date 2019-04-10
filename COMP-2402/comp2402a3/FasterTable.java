package comp2402a3;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 *  This is just a copy of A2Table, your job is to make it faster
 */
public class FasterTable<T> implements Table<T> {
	List<List<T>> tab;

// Creating new ArrayList
	List<Integer> myList; 

// Add new size to listm with varible
	int nSize, nrows, ncols; 

	public FasterTable(Class<T> t) {
		nSize = 0; //Add my varible here
		nrows = 0;
		ncols = 0;

		tab = new ArrayList<List<T>>();

	// Include ArrayList defintion here
		myList = new ArrayList<Integer>(); 
	}

	public int rows() {
		return nrows;
	}

	public int cols() {
		return ncols;
	}

	public T get(int i, int j) {
		if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
			throw new IndexOutOfBoundsException();

			// Grabbing Varible from Array List
			// Then adding to my list
		int currentIndex = myList.get(j); 
		return tab.get(i).get(currentIndex); 
	}

	public T set(int i, int j, T x) {
		if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
			throw new IndexOutOfBoundsException();

			// Grabbing Varible from Array List
			// Chaning Varible to ArrayList Constant
		int currentIndex = myList.get(j); 
		return tab.get(i).set(currentIndex, x); 
	}

	public void addRow(int i) {
		if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
		nrows++;
		List<T> row = new ArrayList<T>();
		for (int j = 0; j < cols(); j++) row.add(null);
		tab.add(i, row);
	}

	public void removeRow(int i) {
		if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();
		nrows--;
		tab.remove(i);
	}

	public void addCol(int j) {
        // this method is too slow! <- Here is where we add the fix
		// Adding Previous Varible nSize
		if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
		ncols++;
		nSize++; 

		// We also need to add null at the end of position
		// Here we are adding Null to the end of the position
		// This will allow for collum to be in correct J location
		for (int i = 0; i < rows(); i++)
			tab.get(i).add(null); 

		myList.add(j, nSize-1);
		 
	}

	public void removeCol(int j) {
        // this method is too slow! <- Here is how we can fix it
        // Removing From Position myList.remove(j)
		if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
		ncols--;

		myList.remove(j); 
		// Here we have removed the for loop
		// Remove the Tag get entry
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows(); i++) {
			for (int j = 0; j < cols(); j++) {
				sb.append(String.valueOf(get(i, j)));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Tester.testTable(new FasterTable<Integer>(Integer.class));
	}
}
