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
		for (int i = this.head; i <= this.tail; i++) {
			saida += fila[i] + " ";
		}
		return saida.trim();
	}

	public static void main(String[] args) {
		Fila fila = new Fila(10);
		assert fila.isEmpty();
		fila.add(2);
		fila.add(5);
		fila.add(7);
		assert fila.head() == 2;
		assert fila.remove() == 2;
		assert fila.head() == 5;
		fila.add(3);
		fila.add(1);
		fila.add(10);
		fila.add(9);
		fila.add(4);
		fila.add(6);

		assert fila.remove() == 5;
		assert fila.head() == 7;

		fila.add(2);
		assert fila.isFull() == false;

		fila.add(14);
		fila.add(29);
		System.out.println(fila);
		assert fila.isFull();
	}

}
