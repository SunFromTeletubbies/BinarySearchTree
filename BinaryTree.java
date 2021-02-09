package BTree;

public class BinaryTree {
	protected Node mRoot = null;

	public Node root() {
		return mRoot;
	}

	public void setRoot(Node t) {
		mRoot = t;
	}

	// Delete all nodes in this tree
	public void clear() {
	}

	// Number of nodes in this tree
	public int count() {
		return count(root());
	}

	public void printTree() {
		System.out.println("Node count:" + count());
		printNode(root());
		System.out.println();

	}
	
	public int getLevel(Node a, Node b, int lvl) {
		if (a == null || b == null)
			return 0;
		
		if (a.data() == b.data())
			return lvl;

		int newLvl = getLevel(a, b.left(), lvl+1);
		
		if(newLvl!=0)
			return newLvl;
		
		newLvl = getLevel(a, b.right(), lvl+1);
			return newLvl;
	}
	
	public int getDepth(Node n) {
		if (n == null)
			return 0;
		
			int leftDepth = getDepth(n.left());
			int rightDepth = getDepth(n.right());
			
			return leftDepth > rightDepth? leftDepth+1: rightDepth+1;
	}
	
	public boolean isComplete(Node n) {
		if (n == null || getLevel(n, root(), 1) == getDepth(n))
			return true;
		
		
		if (n.left() != null && n.right() != null) {
			return isComplete(n.left()) && isComplete(n.right());
		}
		else 
			return false;
	}


	// ------------------------------------
	// -- private
	// ------------------------------------
	private int count(Node n) {
		if (n == null)
			return 0;

		return count(n.left()) + count(n.right()) + 1;

	}

	//
	// a - L_tree
	// R_tree
	// (a (L_tree) (R_tree))
	// If a is leaf, print a
	private void printNode(Node t) {
		if (t == null)
			return;

		// If t is leaf node, print t
		if (t.left() == null && t.right() == null) {
			System.out.print(" " + t.data());
		} else { // else print ( t.data(), (t's left subtree) (t's right subtree))
			System.out.print(" (" + t.data());
			printNode(t.left());
			printNode(t.right());
			System.out.print(")");

		}

	}
}
