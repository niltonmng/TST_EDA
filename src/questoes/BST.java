package questoes;

public class BST {

	private Node root;
	
	@SuppressWarnings("null")
	public BST(){
		this.root = new Node((Integer) null);
	}
		
	public boolean isEmpty(){
		return this.root == null;
	}

	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node) {
		int esquerda = -1;
		int direita = -1;
		
		if(!isEmpty()){
			esquerda = 1 + this.height(node.left);
			direita = 1 + this.height(node.right);
		}
		
		if(esquerda > direita){
			return esquerda;
		}
		else
			return direita;
	}

	public boolean add(int value){
		if(value == (Integer) null){
			return this.add(this.root, value);
		}
		return false;
	}
		
	@SuppressWarnings("null")
	private boolean add(Node node, int value){
		if(node == null){
			node.value = value;
			
			node.left = new Node((Integer) null);
			node.left.parent = node;
			
			node.right = new Node((Integer) null);
			node.right.parent = node;
			return true;
		}
		else if(node.value < value) 
			return this.add(node.left, value);
		else
			return this.add(node.right, value);
	}
	
	
	public void remove(int value){
		Node node = this.search(value);
		if(!node.isEmpty() && value != (Integer) null){
			this.remove(node);
		}
	}
	
	@SuppressWarnings("null")
	private void remove(Node node) {
		if(node.isLeaf()){
			node.value = (Integer) null;
			node.left = null;
			node.right = null;
		}
		else if(node.left.isEmpty()){ // caso nao possua filho esquerdo
			node.value = node.right.value; // recebe o valor do da direita
			node.left = node.right.left; // aponto para o esquerda do meu filho á direita
			node.right = node.right.right; // minha direita se torna o filho da direita do meu filho á direita
			node.right.parent = node; // me defino como pai do meu novo filho á direita
			node.left.parent = node; // me defino como novo pai do meu novo fiho á esquerda
		}
		else if(node.right.isEmpty()){ // caso nao possua filho direito
			node.value = node.left.value;
			node.right = node.left.right;
			node.left = node.left.left;
			node.left.parent = node; 
			node.right.parent = node; 
		}
		else{ // caso possua os dois filhos
			int aux = node.value;
			Node sucessor = this.sucessor(aux); // faço uma troca de valores com o sucessor do no. recursivamente
			node.value = sucessor.value; // no qual ele vai trocando de valores entre os nós e seus sucessores
			sucessor.value = aux; //  ate encontrar um elemento no qual se encaixe em algum dos ifs acima.
			this.remove(sucessor);
		}
		
	}

	public Node minimum(){
		if(this.isEmpty()){
			return null;
		}
		else return this.minimum(this.root);
	}

	private Node minimum(Node node) {
		if(node.left == null){
			return node;
		}
		return this.minimum(node.left);
	}
		
	public Node maximum(){
		if(!this.isEmpty()){
			return this.maximum(this.root);
		}
		return null;
	}

	private Node maximum(Node node) {
		if(node.right == null){
			return node;
		}
		return this.maximum(node.right);
	}
	
	public Node search(int value){
		if(!isEmpty() && value != (Integer) null){
			return this.search(this.root, value);
		}
		return null;
	}

	private Node search(Node node, int value) {
		if(node == null){
			return null;
		}
		if(node.value < value){
			return this.search(node.left, value);
		}else if (node.value > value){
			return this.search(node.right, value);
		}
		else
			return node;
	}

	public Node sucessor(int value){
		Node node = this.search(value);
		
		if(value > 0 && node != null){
			return this.minimum(node.right);
		}else{
			return this.sucessor(node, node.parent);
		}
	}

	private Node sucessor(Node node, Node parent) {
		if(parent == null){
			return null;
		}else if(parent.value > node.value){
			return parent;
		}
		return this.sucessor(node, parent.parent);
	}
	
	public Node predecessor(int value){
		Node node = this.search(value);
		
		if(value != (Integer) null && node != null){
			return this.maximum(node);
		}else{
			return this.predecessor(node, node.parent);
		}
	}

	private Node predecessor(Node node, Node parent) {
		if(parent == null) {
			return null;
		}
		if(parent.value < node.value) {
			return parent;
		}else{
			return this.predecessor(node, parent.parent);
		}
	}

	public int[] preOrder(){
		int[] saida = new int[this.size()];
		this.preOrder(this.root, saida, 0);
		return saida;
	}

	private int preOrder(Node node, int[] array, int index) {
		
		if(node != null){
			array[index] = node.value;
			index++;
			index = this.preOrder(node.left, array, index);
			index = this.preOrder(node.right, array, index);
		}
		
		return index;
	}

	public int[] order(){
		int[] saida = new int[this.size()];
		this.order(this.root, saida, 0);
		return saida;
	}

	private int order(Node node, int[] array, int index) {
		
		if(node != null){
			index = this.order(node.left, array, index);
			array[index] = node.value;
			index++;
			index = this.order(node.right, array, index);
		}
		
		return index;
	}

	public int[] posOrder(){
		int[] saida = new int[this.size()];
		this.posOrder(this.root, saida, 0);
		return saida;
	}

	private int posOrder(Node node, int[] array, int index) {
		
		if(node != null){
			index = this.posOrder(node.left, array, index);
			index = this.posOrder(node.right, array, index);
			array[index] = node.value;
			index++;
		}
		
		return index;
	}
	
	public int size() {
		return this.size(this.root);
	}

	private int size(Node node) {
		int saida = 0;
		
		if(!this.isEmpty()){
			saida = 1 + this.size(node.left) + this.size(node.right);
		}
		return saida;
	}
}