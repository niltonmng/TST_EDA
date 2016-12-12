import static org.junit.Assert.*;

import org.junit.Test;

import questoes.Fila;

public class QueueTest {

	@Test
	public void test() {
		Fila fila = new Fila(10);
		assertTrue(fila.isEmpty());
		assertTrue(fila.add(2));
		assertTrue(fila.add(5));
		assertTrue(fila.add(7));
		assertTrue(fila.head() == 2);
		assertTrue(fila.remove() == 2);
		assertTrue(fila.head() == 5);
		assertTrue(fila.add(3));
		assertTrue(fila.add(1));
		assertTrue(fila.add(10));
		assertTrue(fila.add(9));
		assertTrue(fila.add(4));
		assertTrue(fila.add(6));

		assertTrue(fila.remove() == 5);
		assertTrue(fila.head() == 7);

		assertTrue(fila.add(2));
		assertFalse(fila.isFull());
		assertTrue(fila.add(14));
		assertTrue(fila.add(29));
		assertTrue(fila.isFull());
	}
	
	
	@Test
	public void isEmpty_Full(){
		Fila fila = new Fila(5);
		assertTrue(fila.isEmpty());
		fila.add(10);
		assertFalse(fila.isEmpty());
		assertFalse(fila.isFull());
		fila.add(20);
		fila.add(30);
		fila.add(40);
		fila.add(50);
		assertFalse(fila.isEmpty());
		assertTrue(fila.isFull());
		
		fila.remove();
		fila.remove();
		fila.remove();
		fila.remove();
		fila.remove();
		
		assertTrue(fila.isEmpty());
		assertFalse(fila.isFull());
	}
	
	
	@Test
	public void head(){
		Fila fila = new Fila(5);
		fila.add(10);
		assertEquals(fila.head(),10);
		fila.add(20);
		assertEquals(fila.head(),10);
		fila.add(30);
		assertEquals(fila.head(),10);
		fila.add(40);
		assertEquals(fila.head(),10);
		fila.add(50);
		assertEquals(fila.head(),10);
		fila.remove();
		assertEquals(fila.head(),20);
		fila.remove();
		assertEquals(fila.head(),30);
		fila.remove();
		assertEquals(fila.head(),40);
		fila.remove();
		assertEquals(fila.head(),50);
	}

}
