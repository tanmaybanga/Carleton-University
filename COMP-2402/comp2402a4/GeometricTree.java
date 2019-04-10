package comp2402a4;

import java.util.Random;
import java.util.*;


public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}
	
	/**
	 * Set the x and y-coordinates of each node such that it is between the 
	 * x-coordinate of its two children, no two nodes have the same
	 * x-coordinate, and each level of the tree is drawn on separate y-coordinates.
	 */

	public void inorderDraw() {
		assignLevels();
		// TODO: use your code here instead
		GeometricTreeNode node = firstNode();
		int current_x = 0;
		while (node != nil) {
			node.position.x = current_x;
			node = nextNode(node);
			current_x++;
		}
	}
	
	
	/**
	 * Set the x- and y-coordinates of each node such that each node
	 * has an x-coordinate as small as possible without overlapping 
	 * any other node at the same level and each level of the tree is 
	 * drawn on separate y-coordinates
	 */

	public void leftistDraw() {
		assignLevels();
		// TODO: use your code here instead
    Queue<GeometricTreeNode> temp = new LinkedList<GeometricTreeNode>();
		GeometricTreeNode serchNode = r;

    if (r != nil) {
			temp.add(r);
			r.position.x = 0;
		}
    while (!temp.isEmpty()) {
    	GeometricTreeNode exitNode = temp.remove();
			if ((exitNode.position.y == serchNode.position.y) && (exitNode != r)) {
				exitNode.position.x = serchNode.position.x + 1;
				serchNode = exitNode;
			}
			else {
				exitNode.position.x = 0;
				serchNode = exitNode;
			}
      if (exitNode.left != nil) {
				temp.add(exitNode.left);
			}

      if (exitNode.right != nil) {
				temp.add(exitNode.right);
			}
    }
	}
	
	public HashMap<GeometricTreeNode, Integer> subtrees = new HashMap<GeometricTreeNode, Integer>();

	/**
	 * Set the x- and y-coordinate of each node such that the smaller 
	 * of a node's two subtrees is drawn directly below the node, and the
	 * larger is drawn directly to the right, but far enough away that 
	 * it does not intersect with the smaller subtree.
	 */

	public void balancedDraw() {
		assignLevels();
		// TODO: use your code here instead
		GeometricTreeNode secondSerch = r;
		if (secondSerch == nil) return;
		Queue<GeometricTreeNode> temp = new LinkedList<GeometricTreeNode>();
		Stack<GeometricTreeNode> result = new Stack<>();
		temp.add(secondSerch);
		while (!temp.isEmpty()) {
			GeometricTreeNode node = temp.remove();
			if (node.left != nil) {
				temp.add(node.left);
				result.push(node.left);
			}
			if (node.right != nil) {
				temp.add(node.right);
				result.push(node.right);
			}
		}
		while (!result.empty()) {
			GeometricTreeNode replacedWithResultNode = result.pop();
			if (replacedWithResultNode.left == nil && replacedWithResultNode.right == nil) {
				subtrees.put(replacedWithResultNode, 0);
			}
			else if (replacedWithResultNode.left == nil && replacedWithResultNode.right != nil) {
				subtrees.put(replacedWithResultNode, subtrees.get(replacedWithResultNode.right)+1);
			}
			else if (replacedWithResultNode.right == nil && replacedWithResultNode.left != nil) {
				subtrees.put(replacedWithResultNode, subtrees.get(replacedWithResultNode.left)+1);
			}
			else {
				subtrees.put(replacedWithResultNode, subtrees.get(replacedWithResultNode.left)+subtrees.get(replacedWithResultNode.right) + 2);
			}
		}
		place(r, 0, 0);
	}

	public int metric_X = 0;

	public void place(GeometricTreeNode node, int x, int y) {
		if (node == nil) return;

		metric_X = x;

		node.position.x = x;
		node.position.y = y;


		if (node.left != nil && node.right != nil) {
			if (subtrees.get(node.left) > subtrees.get(node.right)) {
				place(node.right, metric_X, y+1);
				place(node.left, metric_X + 1, y);
			}
			else {
				place(node.left, metric_X, y+1);
				place(node.right, metric_X + 1, y);
			}
		}
		else if (node.left == nil && node.right != nil) {
			place(node.right, metric_X + 1, y);
		}
		else if (node.right == nil && node.left != nil) {
			place(node.left, metric_X + 1, y);
		}

		else {
			return;
		}
	}

	
	/**This function randomly assign's x values to each node in the tree. 
	It is for demonstration purposes only*/

	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}
	
		
	/**This function sets the y values for all nodes in the tree according to their depth*/
	protected void assignLevels() {
		assignLevels(r, 0);
	}

	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}

	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}

}