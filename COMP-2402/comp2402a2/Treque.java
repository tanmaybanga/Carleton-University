package comp2402a2;

import java.util.*;


/**
 */
public class Treque<T> extends AbstractList<T> {

	/**
	 * You decide on the instance variables you need.
	 */

	//Two ArrayDeques to store elements
	public List<T> front;
	public List<T> back;

	public void rebalance() {
		while (back.size() > front.size()+1) {
			front.add(0, back.remove(0));
		}
		while (front.size() > back.size() + 1) {
			back.add(0, front.remove(0));
		}
	}

		public Treque(Class<T> t) {
			// Put your own code here
			front = new ArrayDeque<>(t);
			back = new ArrayDeque<>(t);
		}

		public T get(int i) {
			if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
			// Put your own code here instead of throwing this exception
			// throw new UnsupportedOperationException("get(i) not yet implemented");
			if (i < front.size()) {
				return front.get(front.size()-i-1);
			}
			else {
				return back.get(i-front.size());
			}
		}

		public T set(int i, T x) {
			if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
			// Put your own code here instead of throwing this exception
			// throw new UnsupportedOperationException("set(i,x) not yet implemented");
			if (i < front.size()) {
				return front.set(front.size()-i-1, x);
			}
			else {
				return back.set(i-front.size(), x);
			}
		}

		public void add(int i, T x) {
			if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
			// Put your own code here
			// throw new UnsupportedOperationException("add(i,x) not yet implemented");
			if (i < front.size()) {
				front.add((front.size()-i), x);
			}
			else {
				back.add(i-front.size(), x);
			}
			rebalance();
		}

		public T remove(int i) {
			if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
			// Put your own code here
			// throw new UnsupportedOperationException("remove(i) not yet implemented");
			T x;
			if (i < front.size()) {
				x = front.remove(front.size()-i-1);
			}
			else {
				x = back.remove(i-front.size());
			}
			rebalance();
			return x;
		}

		public int size() {
			// Put your own code here
			// throw new UnsupportedOperationException("size() not yet implemented");
			return front.size() + back.size();
		}
		

	public static void main(String[] args) {
		//List<Integer> tr = new ArrayDeque<Integer>(Integer.class);
		List<Integer> tr = new Treque<Integer>(Integer.class);
		int K = 1000000;
		Stopwatch s = new Stopwatch();
		System.out.print("Appending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Prepending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(0, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Midpending(?!) " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(tr.size()/2, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");


		System.out.print("Removing " + K + " items from the back...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(tr.size()-1);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the front...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the middle...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.remove(tr.size()/2);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
	}



}
