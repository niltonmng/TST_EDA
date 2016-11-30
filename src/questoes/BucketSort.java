package questoes;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {

		int[] v = new int[]{5,2,1,4,3};
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		bucketSort(v);
		System.out.println();
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();

	}


	public static void bucketSort(int[] a) {

		int maior = a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i] > maior){
				maior = a[i];
			}
		}
		int [] bucket = new int[maior+1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}

		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}

		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				a[outPos++]=i;
			}
		}
	}

}
