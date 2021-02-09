package BTree;

public class Node {
	private String mData;
	private Node mLeft = null;
	private Node mRight = null;

	public Node(String s) {
		mData = s;
	}

//---- Get -----
	public String data() {
		return mData;
	}

	public Node left() {
		return mLeft;
	}

	public Node right() {
		return mRight;
	}
	

//--- Set ----
	public void setData(String s) {
		mData = s;
	}

	public Node setLeft(Node n) {
		mLeft = n;
		return n;
	}

	public Node setRight(Node n) {
		mRight = n;
		return n;
	}

}
