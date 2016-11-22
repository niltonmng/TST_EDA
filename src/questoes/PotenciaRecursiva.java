package questoes;

import java.util.*;
class PotenciaRecursiva {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int i = Integer.parseInt(sc.nextLine());
			int j = Integer.parseInt(sc.nextLine());
			System.out.println(potenciaIaJ(i,j));
			
		}
		
		public static int potenciaIaJ(int i, int j){
			if(j == 0){
				return 1;
			}
			if(j == 1){
				return i;
			}
			return i*potenciaIaJ(i, j-1);
		}
}
