package questoes;

import java.util.Scanner;

public class Fila {

	private int capacidade;
	private int head;
	private int tail;
	private int[] fila;
	//private int elementos;

	public Fila(int capacidade){
		this.capacidade = capacidade;
		this.head = -1;
		this.tail = -1;
		//this.elementos = 0;
		this.fila = new int[capacidade];
	}

	public boolean isEmpty(){
		if(this.head == -1 && this.tail == -1){
			return true;
		}
		return false;
	}

	public boolean isFull(){
		//if(this.elementos == this.capacidade){
		//	return true;
		//}
		return ((this.tail + 1) % capacidade) == this.head;
		//return false;
	}

	public boolean add(int n){
		if(this.isFull()){
			throw new RuntimeException("FullQueueException!");			
		}
		
		//this.elementos += 1;
		
		if(this.isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.fila[tail] = n;
		}else{
			this.tail = (this.tail + 1) % capacidade;
			this.fila[tail] = n;
		}
		
		return true;
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
		//this.elementos -= 1;
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

		Scanner sc = new Scanner(System.in);
		
		String tamanho = sc.nextLine();
		Fila fila = new Fila(Integer.parseInt(tamanho));
		
		String[] entrada = sc.nextLine().split(" ");
		
		while(true){
			if(entrada[0].toUpperCase().equals("END")){
				break;
			}
			if(entrada[0].toUpperCase().equals("PRINT")){
				if(fila.isEmpty()){
					System.out.println("empty");
				}else{
					System.out.println(fila.toString());
				}
			}
			else if(entrada[0].toUpperCase().equals("REMOVE")){
				if(fila.isEmpty()){
					System.out.println("empty");
				}else{
					fila.remove();					
				}
			}
			else if(entrada[0].toUpperCase().equals("ADD")){
				if(fila.isFull()){
					System.out.println("full");
				}else{
					fila.add(Integer.parseInt(entrada[1]));					
				}
			}
			else if(entrada[0].toUpperCase().equals("ELEMENT")){
				System.out.println(fila.head());
			}
			entrada = sc.nextLine().split(" ");
		}
	}
}