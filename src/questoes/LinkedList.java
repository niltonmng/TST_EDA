package questoes;

public class LinkedList {
	
	private Node head;
	private int size;
	
	public LinkedList(){
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	public void addLast(int n){
		Node newNode = new Node(n);
		
		if(this.isEmpty()){
			this.head = newNode;
		}else{
			Node aux = head;
			while(aux.next != null){
				aux = aux.next;
			}
			aux.next = newNode;
		}
		this.size += 1;
	}
	
	private Node search(int n){
		Node aux = head;
		while(aux.next != null && aux.value != n){
			aux = aux.next;
		}
		return aux;
	}
	
	public boolean remove(int n){
		if(!isEmpty()){
			
			if(this.head.value == n){
				this.head = this.head.next;
				this.size -= 1;
				return true;
			}
			
			Node prev = null;
			Node aux = this.head;
			
			while(aux.next != null && aux.value != n){
				prev = aux;
				aux = aux.next;
			}
			
			if(aux == null){
				return false;
			}
			else{
				prev.next = aux.next;
				size -= 1;
				return true;
			}
		}
		return false;
	}
	
	
	public boolean removeLast(){
		if(!isEmpty()){
			if(this.head.next == null){
				this.head = null;
				this.size -= 1;
				return true;
			}
			else{
				Node aux = head;
				Node prev = null;
				
				while(aux.next != null){
					prev = aux;
					aux = aux.next;
				}
				if(prev != null && aux == null){
					prev.next = null;
					this.size -= 1;
					return true;
				}
			}
		}
		return false;
	}
	
	public int size(){
		return this.size;
	}
	
	public String toString(){
		String saida = "";
		Node aux = head;
		while(aux.next != null){
			saida += aux.value + " ";
			aux = aux.next;
		}
		return saida.trim();
	}

}
/*
class Node {
	
	Node next;
	int valor;
	
	public Node(int valor){
		this.next = null;
		this.valor = valor;
	}
}*/