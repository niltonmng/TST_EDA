package questoes;

public class CountingSort {


	public static void main(String[] args) {

		int[] v = new int[]{5,2,1,4,3};
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < countingSort(v).length; i++) {
			System.out.print(countingSort(v)[i] + " ");
		}
		System.out.println();

	}

	public static int[] countingSort(int[] a) {

		int maior = a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i]>maior){
				maior = a[i];
			}
		}


		int[] c = new int[maior];

		// frequência
		for (int i = 0; i < a.length; i++) {
			c[a[i] - 1] += 1;
		}

		// cumulativa
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i-1];
		}

		int[] b = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {
			b[c[a[i] - 1] -1] = a[i];
			c[a[i] - 1] -= 1;
		}

		return b;

	}
}