package questoes;

import java.util.Scanner;
public class Parenteses {

	public String parenteses(String entrada){
		String[] str = entrada.split("");
		Stack p = new Stack(str.length/2);

		if(str[0].equals(")")){
			return "N";
		}
		else{
			for (int i = 0; i < str.length; i++) {
				if(p.isEmpty()){
					return "N";
				}
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


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		Parenteses p = new Parenteses();
		System.out.println(p.parenteses(entrada));
	}

}

class Stack {

	private String[] pilha;
	private int capacidade;
	private int topo;

	public Stack(int capacidade){
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
}