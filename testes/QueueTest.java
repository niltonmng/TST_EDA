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

}
