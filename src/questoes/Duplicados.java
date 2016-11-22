package questoes;

import java.util.*;

class Duplicados {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] entrada = sc.nextLine().split(" ");
		System.out.println(achaRepeditos(entrada));
		
	}
	
	public static boolean achaRepeditos(String[] entrada){
		for(int i = 0; i < entrada.length; i++){
			for (int j = 0; j < entrada.length; j++) {
				if(j!=i){
					if(Integer.parseInt(entrada[i]) == Integer.parseInt(entrada[j])){
						return true;
					}
				}
			}
		}
		return false;
	}
	

}
