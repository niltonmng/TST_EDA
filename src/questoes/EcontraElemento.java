package questoes;

import java.util.Scanner;

class EcontraElemento {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int buscado = Integer.parseInt(sc.nextLine());
		String[] lista = sc.nextLine().split(" ");
		System.out.println(buscaElemento(lista, buscado));
		
	}
	
	public static String buscaElemento(String[] vetor, int elemento){
		for (int i = 0; i < vetor.length; i++) {
			if(Integer.parseInt(vetor[i]) == elemento){
				return "sim";
			}
		}
		return "não";
	}

}
