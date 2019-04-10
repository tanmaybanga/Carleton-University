package comp2402a5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
* A utility class with some static methods for testing List implementations
* @author morin
*/
public class Testum {

	protected static void myassert(boolean b) throws AssertionError {
		if (!b) {
			throw new AssertionError();
		}
	}

	protected static String s(Object c) {
		return c.getClass().getName();
	}


	public static void sortedSetSanityTests(SortedSet<Integer> ss, int n) {
		SortedSet<Integer> ts = new TreeSet<Integer>();
		ss.clear();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			Integer x = r.nextInt(2*n);
			if (ts.add(x) != ss.add(x))
			throw new RuntimeException("add(x) returned wrong value");
			if (!compareSortedSets(ts,ss))
			throw new RuntimeException("sorted sets differ!");
		}
		for (int i = 0; i < n; i++) {
			Integer x = r.nextInt(2*n);
			if (ts.remove(x) != ss.remove(x))
			throw new RuntimeException("remove(x) returned wrong value");
			if (!compareSortedSets(ts,ss))
			throw new RuntimeException("sorted sets differ!");
		}
		ss.clear();
		ts.clear();
		compareSortedSets(ts,ss);
	}

	public static void sortedSetSpeedTests(Collection<SortedSet<Integer>> css, int n) {
		long start, stop;

		for (SortedSet<Integer> ss : css) {
			ss.clear();
			myassert(ss.size() == 0);
		}

		for (SortedSet<Integer> ss : css) {
			System.out.print("random insertions (" + s(ss) + ")...");
			start = System.nanoTime();
			Random r = new Random();
			for (int i = 0; i < n; i++)
			ss.add(r.nextInt(2*n));
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
			myassert(ss.size() >= n/2);
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("random contains (" + s(ss) + ")...");
			start = System.nanoTime();
			Random r = new Random();
			for (int i = 0; i < 2*n; i++)
			ss.contains(r.nextInt(2*n));
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("random removals (" + s(ss) + ")...");
			start = System.nanoTime();
			Random r = new Random();
			for (int i = 0; i < 2*n; i++)
			ss.remove(r.nextInt(2*n));
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("random headSets (" + s(ss) + ")...");
			start = System.nanoTime();
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				ss.headSet(r.nextInt(2*n));
				Iterator<Integer> it = ss.iterator();
				if (it.hasNext()) it.next();
			}
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("iteration (" + s(ss) + ")...");
			start = System.nanoTime();
			for (Integer i : ss) { i = i + 1; }
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("clear (" + s(ss) + ")...");
			start = System.nanoTime();
			ss.clear();
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("sequential insertions (" + s(ss) + ")...");
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				myassert(ss.size() == i);
				ss.add(i*2);
			}
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
			myassert(ss.size() == n);
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("sequential contains (" + s(ss) + ")...");
			start = System.nanoTime();
			for (int i = 0; i < 2*n; i++)
			ss.contains(i);
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("sequential headSets (" + s(ss) + ")...");
			start = System.nanoTime();
			for (int i = 0; i < 2*n; i++)
			ss.headSet(i);
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

		for (SortedSet<Integer> ss : css) {
			System.out.print("iteration over subSets (" + s(ss) + ")...");
			start = System.nanoTime();
			for (Integer i : ss.subSet(n/2, 3*n/4)) { i = i + 1; }
			stop = System.nanoTime();
			System.out.println(" " + (1e-9 * (stop - start)) + " seconds");
		}
		System.out.println();

	}

	protected static <T> boolean compareSortedSets(Collection<T> a, Collection<T> b) {
		if (a.size() != b.size())
		return false;
		for (T x : a) {
			if (!b.contains(x)) return false;
		}
		for (T x : b) {
			if (!a.contains(x)) return false;
		}
		Iterator<T> ita = a.iterator();
		Iterator<T> itb = b.iterator();
		while (ita.hasNext()) {
			if (!ita.next().equals(itb.next()))
			return false;
		}
		return true;
	}
}
