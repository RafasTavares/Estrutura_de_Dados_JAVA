package br.recursao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author 8467
 */
public class FatorialTest {

	@Test
	public void FatorialTest() {
		Util util = new Util();
		int resultado = util.fatorial(5);
		assertEquals(resultado, 120);
	}

	@Test
	public void SomaTest() {
		Util util = new Util();
		int resultado = util.soma(5);
		assertEquals(resultado, 15);
	}

	@Test
	public void InversoTest() {
		Util util = new Util();
		String resultado = util.imprimirInverso(38259);
		assertEquals(resultado, "95283");
	}
}