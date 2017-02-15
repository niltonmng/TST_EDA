package questoes;

public class LinkedList2 {
	
	
	private Node head;
	
	public LinkedList2() {
		this.head = null;
	}

	public boolean isEmpty() {
		return this.head == null;	
	}
	
	public int sum() {
		return sum(this.head);
	}
	
	private int sum(Node node) {
		
		if(node == null) {
			return 0;
		} else {
			return node.value + sum(node.next);
		}
		
	}

	public void removeLast() {
		
		if (isEmpty()) return;
		
		if (this.head.next == null)
			this.head = null;
		else
			this.removeLast(this.head);
		
	}
	
	private void removeLast(Node node) {
		
		if (node.next == null) {
			node.previous.next = null;
		} else {
			removeLast(node.next);	
		}
		
		
	}

	
	public void addLast(int n) {
		if (isEmpty()) {
			this.head = new Node(n);
		} else {
			this.addLast(this.head, n);
		}
	}
	
	private void addLast(Node node, int n) {
		
		if (node.next == null) {
			Node newNode = new Node(n);
			node.next = newNode;
			newNode.previous = node;
			return;
		} else {
			addLast(node.next, n);
		}
	}
	
	public void insereOrdenado(int n){ 
		
		Node newNode = new Node(n);
		
		if(this.head.value >= n){
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
		}
		else{
			Node aux = this.head.next; // bugado! falta correção
			boolean inseriu = false;
			
			while(aux.next != null){
				if(n < aux.value){
					newNode.next = aux;
					newNode.previous = aux.previous;
					aux.previous.next = newNode;
					aux.previous = newNode;
					inseriu = true;
					break;
				}
				aux = aux.next;
			}
			
			if(inseriu == false){			
				aux.next = newNode;
			}			
		}
	}
	
	
	
	
	public String toString() {
		
		return this.toString(this.head);
	
	}

	private String toString(Node node) {
		if (node == null)
			return "";
		else {
			return node.value + " " + toString(node.next);
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList2 lista = new LinkedList2();
		Node no1 = new Node(10);
		lista.head = no1;
		
		lista.insereOrdenado(5);
		lista.insereOrdenado(3);
		lista.insereOrdenado(2);
		lista.insereOrdenado(100);
		lista.insereOrdenado(7);
		lista.insereOrdenado(5);
		lista.insereOrdenado(20);
		System.out.println(lista.toString());
		
	}
	
	
}
/*
class Node {
	
	int value;
	Node next;
	Node previous;
	
	Node(int value) {
		this.value = value;
		this.next = null;
		this.previous = null;
	}
}*/