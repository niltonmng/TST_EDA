package questoes;

public class CountingSort {


	public static void main(String[] args) {

		//Integer[] v = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,31 };
		//Integer[] v = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,11, 18, 36 };
		int[] v = new int[] { -1, 9, 3, -10, 0, 5, 1, 4 };
		//Integer[] v = new Integer[] { 6, 6, 6, 6, 6, 6 };

		//int[] v = new int[]{5,2,1,4,3};
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();
		countingComNegativos(v);
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();

	}


	public static void countingComNegativos(int[] a) {
		if(a.length > 0){
			// achamos menor elemento da lista
			int menor = a[0];
			for (int i = 0; i < a.length; i++) {
				if(a[i] < menor){
					menor = a[i];
				}
			}

			// achamos maior elemento da lista
			int maior = a[0];
			for (int i = 0; i < a.length; i++) {
				if(a[i] > maior){
					maior = a[i];
				}
			}

			int[] c = new int[maior - menor + 1];
			// frequencia de numeros
			for (int e : a) {
				c[e - menor]++;
			}
			// cumulativa de elementos
			for (int i = 1; i < c.length; i++) {
				c[i] += c[i - 1];
			}

			// colocamos os elementos na ordem respectiva
			int[] aux = new int[a.length];
			for (int i = a.length - 1; i >= 0; i--){
				aux[c[a[i]-menor]-1] = a[i];
				c[a[i]-menor]--;
			}

			//os elementos d0 vetor passado sao alterados para ficarem ordenados
			for (int i = 0; i < aux.length; i++) {
				a[i] = aux[i];
			}
		}
	}

	public static int[] countingSort(int[] v) {

		int maior = v[0];
		for (int i = 1; i < v.length; i++) {
			if(v[i]>maior){
				maior = v[i];
			}
		}


		int[] c = new int[maior];

		// frequência
		for (int i = 0; i < v.length; i++) {
			if(v[i] == 0){
				c[v[i]] += 1;
			}else{
				c[v[i] - 1] += 1;				
			}
		}

		// cumulativa
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i-1];
		}

		int[] b = new int[v.length];

		for (int i = v.length - 1; i >= 0; i--) {
			if(v[i] == 0){
				b[c[v[i]] -1] = v[i];
				c[v[i]] -= 1;
			}else{
				b[c[v[i] - 1] -1] = v[i];
				c[v[i] - 1] -= 1;				
			}
		}

		return b;

	}



}