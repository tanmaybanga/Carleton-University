package comp2402a3;

import java.util.List;
import java.util.ArrayList;

/**
 */
public class A2Table<T> implements Table<T> {
	List<List<T>> tab;

	int nrows, ncols;

	public A2Table(Class<T> t) {
		nrows = 0;
		ncols = 0;
		tab = new ArrayList<List<T>>();
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
		return tab.get(i).get(j);
	}

	public T set(int i, int j, T x) {
		if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1)
			throw new IndexOutOfBoundsException();
		return tab.get(i).set(j, x);
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
		if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();
		ncols++;
		for (int i = 0; i < rows(); i++)
			tab.get(i).add(j, null);
	}

	public void removeCol(int j) {
		if (j < 0 || j > cols() - 1) throw new IndexOutOfBoundsException();
		ncols--;
		for (int i = 0; i < rows(); i++)
			tab.get(i).remove(j);
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
		Tester.testTable(new A2Table<Integer>(Integer.class));
	}
}
