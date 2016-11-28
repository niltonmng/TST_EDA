package questoes;

public class MDC {
	
	
	public int mdc(int a, int b){
		if(a % 2 == 0 && b % 2 == 0)
			return 2;
		if(a % 3 == 0 && b % 3 == 0)
			return 3;
		if(a % 5 == 0 && b % 5 == 0)
			return 2;
		return 0;
	}

}
