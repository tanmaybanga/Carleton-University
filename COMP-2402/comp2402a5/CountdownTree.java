package comp2402a5;

import java.util.*;
import java.lang.reflect.Array;



/**
* An unfinished implementation of an Countdown tree (for exercises)
* @author morin
*
* @param <T>
*/
public class CountdownTree<T> extends
BinarySearchTree<CountdownTree.Node<T>, T> implements SSet<T> {

	// countdown delay factor
	double d;

	public static class Node<T> extends BSTNode<Node<T>,T> {
		int timer;  // the height of the node
	}

	public CountdownTree(double d) {
		this.d = d;
		sampleNode = new Node<T>();
		c = new DefaultComparator<T>();
	}

	public boolean add(T x) {
		Node<T> u = new Node<T>();
		u.timer = (int)Math.ceil(d);
		u.x = x;
		if (super.add(u)) {
			// add some code here
			Node<T> w = u.parent;
			while (w != nil) {
				w.timer--;
				if (w.timer == 0) {
					explode(w);
				}
				w = w.parent;
			}
			return true;
		}
		return false;
	}

	public void splice(Node<T> u) {
		Node<T> w = u.parent;
		super.splice(u);
		// add some code here (we just removed u from the tree
		while (w != nil) {
			w.timer--;
			if (w.timer == 0) {
				explode(w);
			}
			w = w.parent;
		}
	}

	protected void explode(Node<T> u) {
		// Write this code to explode u
		// Make sure to update u.parent and/or r (the tree root) as appropriate

		//Here we have the size of the subtree that we have developed
		//Then we have created an Array to store all of the nodes within the subtree
		//This will place the nodes into the array amd determin 
		// If the u was a root
		// If the u was on the parent right 
		// or what else it was 
		int nodeSize = size(u);

		Node<T> p = u.parent;

		Node<T>[] array = (Node<T>[]) Array.newInstance(Node.class, nodeSize);

		fillMyArray(u, array, 0);

		if (p == nil) {
			r = equallyBuilt(array, 0, nodeSize);
			r.parent = nil;
		}

		else if (p.right == u) {
			p.right = equallyBuilt(array, 0, nodeSize);
			p.right.parent = p;
		}

		else {
			p.left = equallyBuilt(array, 0, nodeSize);
			p.left.parent = p;
		}
	}

	// Once we have reached the location of the tree, stop!
	private int fillMyArray(Node<T> u, Node<T>[] arrayCreated, int i) {
		if (u == nil) return i;

		i = fillMyArray(u.left, arrayCreated, i);

		arrayCreated[i++] = u;

		return fillMyArray(u.right, arrayCreated, i);
	}

	// When checking the list, if it is found empty, return null
	// otherwise return the middle node
	private Node<T> equallyBuilt(Node<T>[] arrayCreated, int h, int size) {
		if (size == 0) return nil;

		int k = size/2;
		arrayCreated[h + k].left = equallyBuilt(arrayCreated, h, k);

		if (arrayCreated[h + k].left != nil) {
			arrayCreated[h + k].left.parent = arrayCreated[h + k];
		}

		arrayCreated[h + k].right = equallyBuilt(arrayCreated, h + k + 1, size - k - 1);

		if (arrayCreated[h + k].right != nil) {
			arrayCreated[h + k].right.parent = arrayCreated[h + k];
		}

		arrayCreated[h+k].timer = (int) Math.ceil(d * size(arrayCreated[h+k]));

		return arrayCreated[h+k];
	}

	// Here is some test code you can use
	public static void main(String[] args) {
		Testum.sortedSetSanityTests(new SortedSSet<Integer>(new CountdownTree<Integer>(1)), 1000);
		Testum.sortedSetSanityTests(new SortedSSet<Integer>(new CountdownTree<Integer>(2.5)), 1000);
		Testum.sortedSetSanityTests(new SortedSSet<Integer>(new CountdownTree<Integer>(0.5)), 1000);

		java.util.List<SortedSet<Integer>> ell = new java.util.ArrayList<SortedSet<Integer>>();
		ell.add(new java.util.TreeSet<Integer>());
		ell.add(new SortedSSet<Integer>(new CountdownTree<Integer>(1)));
		ell.add(new SortedSSet<Integer>(new CountdownTree<Integer>(2.5)));
		ell.add(new SortedSSet<Integer>(new CountdownTree<Integer>(0.5)));
		Testum.sortedSetSpeedTests(ell, 1000000);
	}
}
