package questoes;

public class Node {

	
	Node left;
	Node right;
	Node parent;
	int value;
	
	public Node(int value){
		this.parent = null;
		this.left = null;
		this.right = null;
		this.value = value;
	}
	
	
	public boolean isEmpty(){
		return this == null;
	}
	
	
	public boolean isLeaf(){
		return this.value == (Integer) null && this.left.isEmpty() && this.right.isEmpty();
	}
}
