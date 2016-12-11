package questoes;

public class Fila {

	private int capacidade;
	private int head;
	private int tail;
	private int[] fila;

	public Fila(int capacidade){
		this.capacidade = capacidade;
		this.head = -1;
		this.tail = -1;
		this.fila = new int[capacidade];
	}

	public boolean isEmpty(){
		if(this.head == -1 && this.tail == -1){
			return true;
		}
		return false;
	}

	public boolean isFull(){
		return ((this.tail + 1) % capacidade) == this.head;
	}

	public boolean add(int n){
		if(this.isFull()){
			throw new RuntimeException("FullQueueException!");			
		}
		if(this.isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.fila[tail] = n;
			return true;
		}else{
			this.tail = (this.tail + 1) % capacidade;
			this.fila[tail] = n;
			return true;
		}
	}

	public int remove(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyQueueException!");
		}

		int removido = fila[head];

		if(this.head == this.tail){ // para o caso de ter removido o ultimo elemento e o valor do head tornou-se igual ao valor do tail. resetamos os dois às posições iniciais.
			this.head = -1;
			this.tail = -1;
		}else{
			this.head = ((this.head + 1) % capacidade); // a cabeça anda uma posição, partindo de sua posição atual.(claramente, a primeira remoção parte da posição inicial).
		}
		return removido;
	}

	public int head(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyQueueException!");
		}
		return this.fila[head];
	}
	
	public String toString(){
		String saida = "";
		for (int i = this.head; i < this.tail; i++) {
			saida += fila[i] + " ";
		}
		return saida.trim();
	}
}