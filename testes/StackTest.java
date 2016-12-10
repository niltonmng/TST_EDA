import static org.junit.Assert.*;

import org.junit.Test;

import questoes.Pilha;

public class StackTest {

	@Test
	public void test() {
		Pilha pilha = new Pilha(5);
		
		assertTrue(pilha.isEmpty());
		assertTrue(!pilha.isFull());
		assertTrue(pilha.size() == 0);

		pilha.push(10);
		assertTrue(pilha.peek() == 10);
		assertTrue(pilha.size() == 1);
		assertTrue(!pilha.isEmpty());

		pilha.push(5);
		assertTrue(pilha.size() == 2);

		assertTrue(pilha.pop() == 5);

		pilha.push(7);
		assertTrue(pilha.peek() == 7);
		pilha.pop();

		assertTrue(!pilha.isEmpty());
		assertTrue(pilha.getIndexMax() == 0);
		//pilha.push(20);
		System.out.println(pilha.toString());
		//assertTrue(pilha.getIndexMax() == 1);
	}

}
