package questoes;

public class RadixSort {


	public void radixSort(int vector[]){
		for(int digit = 0; digit < 3; digit ++){
			int power = (int) Math.pow(10, digit+1);

			int z[][] = new int[vector.length][10];
			int n[] = new int[10];

			for(int i = 0; i < vector.length; i ++){
				int num = vector[i];
				z[n[(num%power)/(power/10)]][(num%power)/(power/10)] = num;
				n[(num%power)/(power/10)]++;

			}
			int c = 0;
			for(int i = 0; i < 10; i ++){

				for(int j = 0; j < vector.length; j ++){
					if(j < n[i]){
						vector[c] = z[j][i];
						c++;
					}else{break;}
				}
			}
		}			
	}
	
	
	
	
	
}