import static org.junit.Assert.*;

import org.junit.Test;

import questoes.Pilha;

public class StackTest {

	@Test
	public void test() {
		Pilha pilha = new Pilha(5);

		pilha.push(10);
		assertTrue(pilha.peek() == 10);
		assertTrue(pilha.size() == 1);

		pilha.push(5);
		assertTrue(pilha.size() == 2);

		assertTrue(pilha.pop() == 5);

		pilha.push(7);
		assertTrue(pilha.peek() == 7);
		pilha.pop();

		assertTrue(!pilha.isEmpty());
		assertTrue(pilha.getIndexMax() == 0);
		pilha.push(20);
		assertTrue(pilha.getIndexMax() == 1);
	}
	
	@Test
	public void testGetIndexMax_Peek_Size() {
		Pilha pilha = new Pilha(5);
		assertEquals(pilha.size(),0);
		
		pilha.push(0);
		assertTrue(pilha.getIndexMax() == 0);
		assertTrue(pilha.peek() == 0);
		assertEquals(pilha.size(),1);
		
		pilha.push(1);
		assertTrue(pilha.getIndexMax() == 1);
		assertTrue(pilha.peek() == 1);
		assertEquals(pilha.size(),2);
		
		pilha.push(2);
		assertTrue(pilha.getIndexMax() == 2);
		assertTrue(pilha.peek() == 2);
		assertEquals(pilha.size(),3);
		
		pilha.push(3);
		assertTrue(pilha.getIndexMax() == 3);
		assertTrue(pilha.peek() == 3);
		assertEquals(pilha.size(),4);
		
		pilha.push(4);
		assertTrue(pilha.getIndexMax() == 4);
		assertTrue(pilha.peek() == 4);
		assertEquals(pilha.size(),5);
	}
	
	@Test
	public void testIsEmpty_Full() {
		Pilha pilha = new Pilha(5);
		assertTrue(pilha.isEmpty());
		assertFalse(pilha.isFull());
		pilha.push(2);
		pilha.push(2);
		pilha.push(2);
		pilha.push(2);
		pilha.push(2);
		assertFalse(pilha.isEmpty());
		assertTrue(pilha.isFull());
		pilha.pop();
		pilha.pop();
		pilha.pop();
		pilha.pop();
		pilha.pop();
		assertTrue(pilha.isEmpty());
		assertFalse(pilha.isFull());
	}

}
