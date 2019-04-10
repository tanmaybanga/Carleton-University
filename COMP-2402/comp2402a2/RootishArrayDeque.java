package comp2402a2;

import java.util.*;

/**
 */
public class RootishArrayDeque<T> extends AbstractList<T> {
	//Two ArrayDeques to store elements
	public List<T> front;
	public List<T> back;
	public Factory<T> f;

	public void balance() {
		int n = size();
		if (3*front.size() < back.size()) {
			int s = n/2 - front.size();
			List<T> l1 = new RootishArrayStack<>(f.type());
			List<T> l2 = new RootishArrayStack<>(f.type());
			l1.addAll(back.subList(0,s));
			Collections.reverse(l1);
			l1.addAll(front);
			l2.addAll(back.subList(s, back.size()));
			front = l1;
			back = l2;
		}
		else if (3*back.size() < front.size()) {
			int s = front.size() - n/2;
			List<T> l1 = new RootishArrayStack<>(f.type());
			List<T> l2 = new RootishArrayStack<>(f.type());
			l1.addAll(front.subList(s, front.size()));
			l2.addAll(front.subList(0, s));
			Collections.reverse(l2);
			l2.addAll(back);
			front = l1;
			back = l2;
		}
	}

	public RootishArrayDeque(Class<T> t) {
		// Put your own code here
		front = new RootishArrayStack<>(t);
		back = new RootishArrayStack<>(t);
		f = new Factory(t);
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
		else if (i < front.size()) {
			front.add((front.size()-i), x);
		}
		else {
			back.add(i-front.size(), x);
		}
		balance();
	}

	public T remove(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		// Put your own code here
		// throw new UnsupportedOperationException("size(i) not yet implemented");
		T x;
		if (i < front.size()) {
			x = front.remove(front.size()-i-1);
		}
		else {
			x = back.remove(i-front.size());
		}
		balance();
		return x;
	}

	public int size() {
		// Put your own code here
		return front.size() + back.size();
	}

	public static void main(String[] args) {
		//List<Integer> rad = new ArrayDeque<Integer>(Integer.class);
		List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);
		int K = 1000000;
		Stopwatch s = new Stopwatch();
		System.out.print("Appending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			rad.add(i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Prepending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			rad.add(0, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the back...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			rad.remove(rad.size()-1);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the front...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			rad.remove(0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
	}
}
