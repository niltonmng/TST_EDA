package questoes;

import java.util.Scanner;

import javax.swing.SwingConstants;

public class Pilha {

	private String[] pilha;
	private int capacidade;
	private int topo;

	public Pilha(int capacidade){
		this.capacidade = capacidade;
		this.topo = -1;
		this.pilha = new String[capacidade];
	}


	public boolean isEmpty(){
		if(this.topo == -1){
			return true;
		}
		return false;
	}


	public boolean isFull(){
		if(this.topo == (capacidade - 1)){
			return true;
		}
		return false;
	}

	public boolean push(String n){
		if(!this.isFull()){
			this.topo += 1;
			this.pilha[topo] = n;
			return true;
		}
		throw new RuntimeException("FullStackException");
	}

	public String pop(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		String valorTopo = this.pilha[topo];
		this.topo -= 1;
		return valorTopo;
	}

	public String peek(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		return this.pilha[topo];
	}

	public int size(){
		return this.topo + 1;
	}

	/*public int getIndexMax(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		int maior = this.pilha[topo];
		int indexMaior = topo;
		for (int i = pilha.length-1; i >= 0; i--) {
			if(pilha[i] > maior){
				maior = pilha[i];
				indexMaior = i;
			}
		}
		return indexMaior;
	}

	public Pilha inverte(){
		Pilha aux  = new Pilha(capacidade);
		for (int i = this.size()-1; i >= 0; i--) {
			aux.push(this.pop());
		}
		return aux;
	}

	public int[] getPilha(){
		return this.pilha;
	}

	public String toString(){
		String saida = "";
		for (int i = 0; i < topo+1; i++) {
			saida += this.pilha[i] + " ";
		}
		return saida.trim();
	}*/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String parenteses = sc.nextLine();
		Parenteses p = new Parenteses();
		System.out.println(p.parenteses(parenteses));
		
		/*String tamanho = sc.nextLine();
		Pilha pilha = new Pilha(Integer.parseInt(tamanho));
		
		String[] entrada = sc.nextLine().split(" ");
		
		while(true){
			if(entrada[0].toUpperCase().equals("END")){
				break;
			}
			if(entrada[0].toUpperCase().equals("PRINT")){
				if(pilha.isEmpty()){
					System.out.println("empty");
				}else{
					System.out.println(pilha.toString());
				}
			}
			else if(entrada[0].toUpperCase().equals("POP")){
				if(pilha.isEmpty()){
					System.out.println("empty");
				}else{
					pilha.pop();					
				}
			}
			else if(entrada[0].toUpperCase().equals("PUSH")){
				if(pilha.isFull()){
					System.out.println("full");
				}else{
					pilha.push(Integer.parseInt(entrada[1]));					
				}
			}
			else if(entrada[0].toUpperCase().equals("PEEK")){
				System.out.println(pilha.peek());
			}
			entrada = sc.nextLine().split(" ");
		}*/
	}
}

class Parenteses{
	
	public String parenteses(String entrada){
		String[] str = entrada.split("");
		Pilha p = new Pilha(str.length/2);
		
		if(str[0].equals(")")){
			return "N";
		}
		else{
			for (int i = 0; i < str.length; i++) {
				if(str[i].equals("(")){
					p.push(str[i]);
				}else{
					p.pop();
				}
			}
		}
		if(p.isEmpty()){
			return "S";
		}else{			
			return "N";
		}
	}
}
