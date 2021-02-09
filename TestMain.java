package BTree;

public class TestMain {

	private static void printLeaves(Node n) {
		if (n == null)
			return;

		// if n is leaf, print n and return
		if (n.left() == null && n.right() == null) {
			System.out.print(" " + n.data());
			return;
		}
		// else printLeaves(n.left())
		// printLeaves(n.right())
		printLeaves(n.left());
		printLeaves(n.right());

	}
	
	private static void printNonLeaves(Node n) {
		if (n == null)
			return;

		// if n is leaf, print n and return
		if (!(n.left() == null && n.right() == null)) {
			System.out.print(" " + n.data());
			return;
		}
		// else printLeaves(n.left())
		// printLeaves(n.right())
		printNonLeaves(n.left());
		printNonLeaves(n.right());

	}
	
	private static void printNodeAtLevel(BinaryTree t, Node n, int level) {
		if (n == null)
			return;

		// if n is leaf, print n and return
		if (t.getLevel(n, t.root(), 1) == level) {
			System.out.print(" " + n.data());
			return;
		}
		// else printLeaves(n.left())
		// printLeaves(n.right())
		printNodeAtLevel(t, n.left(), level);
		printNodeAtLevel(t, n.right(), level);

	}
	
	public static void printNonLeaves(BinaryTree t) {
		System.out.print("Non-Leaves:");
		printNonLeaves(t.root());
		System.out.println();

	}

	public static void printLeaves(BinaryTree t) {
		System.out.print("Leaves:");
		printLeaves(t.root());
		System.out.println();
	}
	
	public static void printNodeAtLevel(BinaryTree t, int level) {
		System.out.print("Nodes At Level " + level + ":");
		printNodeAtLevel(t, t.root(), level);
		System.out.println();
	}
	
	public static void printTreeDepth(BinaryTree t) {
		System.out.print("Tree depth: " + t.getDepth(t.root()));
		System.out.println();
	}
	
	public static void isCompleteTree(BinaryTree t) {
		if(t.isComplete(t.root()))
			System.out.print("Tree is complete");
		else
			System.out.print("Tree is not complete");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BSTree bst = new BSTree();
		bst.insert("4");
		/*Node n = bst.root();
		Node b = n.setLeft(new Node("b"));
		Node c = n.setRight(new Node("c"));
		b.setLeft(new Node("d"));
		b.setRight(new Node("e"));
		c.setLeft(new Node("f"));
		//c.setRight(new Node("g"));*/
		bst.insert("3");
		bst.insert("2");
		bst.insert("1");
		bst.insert("8");
		bst.insert("5");
		bst.insert("6");
		bst.insert("10");
		bst.printTree();
		bst.remove("6");
		bst.printTree();
		bst.checkIfExists("3");

		printLeaves(bst);
		
		// Print all non-leaves node-> a b
		printNonLeaves(bst);
		// Print nodes at level 1-> b c
		printNodeAtLevel(bst, 3);
		
		// tree depth
		printTreeDepth(bst);
		
		// all nodes has two children except bottom level nodes
		isCompleteTree(bst);
		
		bst.clear();
		
	}

}
