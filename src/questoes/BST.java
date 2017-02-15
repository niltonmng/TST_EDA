package questoes;

public class BST {

	private Node root;
	
	
	
	public boolean isEmpty(){
		return this.root == null;
	}
	
	
	public boolean add(int value){
		if(!isEmpty()){
			return this.add(this.root, value);
		}else{
			Node n = new Node(value);
			this.root = n;
			return true;
		}
	}
	
	
	private boolean add(Node node, int value){
		if(value < node.value){
			
		}
	}
	
}


class Node {
	
	Node left;
	Node right;
	int value;
	
	public Node(int value){
		this.left = null;
		this.right = null;
		this.value = value;
	}
	
}