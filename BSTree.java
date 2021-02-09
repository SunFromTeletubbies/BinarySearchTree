package BTree;

public class BSTree extends BinaryTree{
	public void insert(String data) { 
	   mRoot = insert(mRoot, data); 
	} 
	
	private Node insert(Node r, String data) { 
		  
       
        if (r == null) { 
            r = new Node(data); 
            return r; 
        } 

        if (Integer.valueOf(data) < Integer.valueOf(r.data())) {
            r.setLeft(insert(r.left(), data)); 
        }
        else if (Integer.valueOf(data) > Integer.valueOf(r.data())) {
        	r.setRight(insert(r.right(), data)); 
        }
  
        return r; 
    }
	
	public void checkIfExists(String data) {
		if(exists(mRoot, data))
			System.out.println(data + " exists in tree");
		else
			System.out.println(data + " doesn't exist in tree");
	}
	
	private boolean exists(Node r, String data) { 
	    if (r==null)
	    	return false;
	    	
	    if (r.data()==data) 
	        return true; 
	  
	    if (Integer.valueOf(r.data()) > Integer.valueOf(data)) 
	        return exists(r.left(), data); 
	  
	    return exists(r.right(), data); 
	} 
	
	void remove(String data) 
    { 
        mRoot = remove(mRoot, data); 
    } 
	
	private Node remove(Node r, String data) { 
		  if(r==null)
			  return r;
		  
		  if(Integer.valueOf(r.data()) > Integer.valueOf(data)) {
			  r.setLeft(remove(r.left(), data));
		  }
		  else if(Integer.valueOf(r.data()) < Integer.valueOf(data)) {
			  r.setRight(remove(r.right(), data));
		  }
		  else {
			  if(r.right()==null) {
				  return r.left();
			  }
			  if(r.left()==null) {
				  return r.right();
			  }
			  
			  r.setData(Integer.toString(minimumValue(r.right())));
			  
			  r.setRight(remove(r.right(), r.data()));
		  }
		  
		  return r;
    }
	
	private int minimumValue(Node r) {
		int min = Integer.valueOf(r.data()); 
        while (r.left() != null) 
        { 
            min = Integer.valueOf(r.data()); 
            r = r.left(); 
        } 
        return min;
	}
}
