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
}
