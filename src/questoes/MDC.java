package questoes;

public class MDC {
	
	
	public static void main(String[] args) {
		System.out.println(mdc(7,50));
	}
	
	public static int mdc(int a, int b){
		if(b == 0){
			return a;
		}
		System.out.println(a + " " +a%b);
		return mdc(a,a%b);
	}

}
