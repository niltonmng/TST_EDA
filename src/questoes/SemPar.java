package questoes;

import java.util.Scanner;

class SemPar {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			String[] i = sc.nextLine().split(" ");
			System.out.println(semPar(i));
			
			
		}
		
		public static int semPar(String[] vetor){
			int saida = 0;
			for (int i = 0; i < vetor.length; i++) {
				int index = i;
				int cont = 1;
				for (int j = 0; j < vetor.length; j++) {
					if(i != j){
						if(Integer.parseInt(vetor[i]) == Integer.parseInt(vetor[j])){
							cont++;
						}
					}
				}
				if(cont == 1){
					saida = Integer.parseInt(vetor[index]);
				}
			}
			return saida;
		}
		
}
