package questoes;

public class Pilha {

	private int[] pilha;
	private int capacidade;
	private int topo;
	
	public Pilha(int capacidade){
		this.capacidade = capacidade;
		this.topo = -1;
		this.pilha = new int[capacidade];
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
	
	public boolean push(int n){
		if(!this.isFull()){
			this.topo += 1;
			this.pilha[topo] = n;
			return true;
		}
		throw new RuntimeException("FullStackException");
	}
	
	public int pop(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		int valorTopo = this.pilha[topo];
		this.topo -= 1;
		return valorTopo;
	}
	
	public int peek(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		return this.pilha[topo];
	}
	
	public int size(){
		return this.topo + 1;
	}
	
	public int getIndexMax(){
		if(this.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		Pilha aux = new Pilha(this.size());
		int maior = this.pilha[topo];
		int indexMaior = topo;
		for (int i = this.topo; i >= 0; i--) {
			if(this.pilha[i] > maior){
				maior = pilha[i];
				indexMaior = i;
			}
			aux.push(this.pop());
		}
		
		for (int i = this.topo; i >= 0; i--) {
			this.push(aux.pop());
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
	
	/*public void inverte(){
		Pilha aux  = new Pilha(capacidade);
		for (int i = this.size()-1; i >= 0; i--) {
			aux.push(this.pop());
		}
		
		for (int i = 0; i < pilha.length; i++) {
			this.push(aux.getPilha()[i]);
		}
	}*/
	
	public String toString(){
		String saida = "";
		for (int i = topo; i >= 0; i--) {
			saida += this.pilha[i] + "\n";
		}
		return saida.trim();
	}
	
	public static void main(String[] args) {
		
		Pilha pilha = new Pilha(5);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;
    
        pilha.push(10);
        assert pilha.peek() == 10;
        assert pilha.size() == 1;
        assert !pilha.isEmpty();
    
        pilha.push(5);
        assert pilha.size() == 2;

        assert pilha.pop() == 5;

        pilha.push(7);
        assert pilha.peek() == 7;
        pilha.pop();

        assert !pilha.isEmpty();
    	assert pilha.getIndexMax() == 0;
		pilha.push(20);
		assert pilha.getIndexMax() == 2;
		pilha.push(3);
		pilha.push(4);
		pilha.pop();
		
		System.out.println(pilha);
		System.out.println();
		System.out.println(pilha.inverte());
	}
}
