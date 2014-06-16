package br.ed.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ed.hashingOpen.HashSimpEnc;

public class Teste {

	private HashSimpEnc<Integer> hash;

	@Before
	public void iniciar() {
		hash = new HashSimpEnc<Integer>(10);
	}

	@Test
	public void Size() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(23);
		hash.add(54);
		hash.add(45);
		hash.add(31);
		hash.add(89);
		hash.add(34);
		hash.add(94);
		hash.add(2);
		hash.add(3);
		hash.add(4);
		hash.add(1);
		hash.add(8);
		hash.add(5);
		hash.add(9);
		hash.add(234);
		hash.add(99);
		hash.add(98);
		hash.add(97);
		hash.add(96);
		hash.add(95);
		hash.add(94);
		hash.add(93);
		hash.remove(2);
		System.out.println(hash.toString());
		int resultado = hash.size();
		assertEquals(8, resultado);
	}

	@Test
	public void testContem() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		boolean resultado = hash.contains(8945);
		assertEquals(false, resultado);
	}

	@Test
	public void Clear() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		hash.clear();
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void Contains() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		boolean resultado = hash.contains(3245);
		assertEquals(true, resultado);
	}

	@Test
	public void ContainsElement() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		boolean resultado = hash.contains(8945);
		assertEquals(false, resultado);
	}

	@Test
	public void testClear1() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.clear();
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testClear2() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.remove(8945);
		hash.clear();
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testClear3() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		hash.clear();
		int resultado = hash.size();
		hash.add(2345);
		assertEquals(0, resultado);
	}

	@Test
	public void testClear4() {
		hash.clear();
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testClear5() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.remove(3254);
		hash.remove(3245);
		hash.remove(3231);
		hash.remove(3289);
		hash.remove(5234);
		hash.clear();
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testAdd1() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		int resultado = hash.size();
		assertEquals(4, resultado);
	}

	@Test
	public void testAdd2() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.remove(8945);
		int resultado = hash.size();
		assertEquals(4, resultado);
	}

	@Test
	public void testAdd3() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		hash.add(2345);
		int resultado = hash.size();
		assertEquals(4, resultado);
	}

	@Test
	public void testAdd4() {
		hash.add(3245);
		hash.remove(3245);
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testAdd5() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.remove(3254);
		hash.remove(3245);
		hash.remove(3231);
		hash.remove(3289);
		hash.remove(5234);
		int resultado = hash.size();
		assertEquals(0, resultado);
	}

	@Test
	public void testAdd6() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(23);
		hash.add(54);
		hash.add(45);
		hash.add(31);
		hash.add(89);
		hash.add(34);
		hash.add(94);
		hash.add(2);
		hash.add(3);
		hash.add(4);
		hash.add(1);
		hash.add(8);
		hash.add(5);
		hash.add(9);
		hash.add(234);
		hash.add(99);
		hash.add(98);
		hash.add(97);
		// O numero 96 não esta adicionando porque todos os pontos de colisão
		// estão em uso {0,4,8,12,16,20,24,28}
		// O fator de carga é 71,875
		hash.add(96);
		hash.add(95);
		hash.add(94);
		hash.add(93);
		int resultado = hash.size();
		assertEquals(9, resultado);
	}

	@Test
	public void testRemover1() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.clear();
		boolean resultado = hash.remove(3289);
		assertEquals(false, resultado);
	}

	@Test
	public void testRemover2() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.remove(8945);
		boolean resultado = hash.add(2345);
		assertEquals(true, resultado);
	}

	@Test
	public void testRemover3() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		hash.add(2345);
		hash.remove(2345);
		int resultado = hash.size();
		assertEquals(4, resultado);
	}

	@Test
	public void testRemover4() {
		boolean resultado = hash.remove(3245);
		assertEquals(false, resultado);
	}

	@Test
	public void testRemover5() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.remove(3254);
		hash.remove(3245);
		hash.remove(3231);
		hash.remove(3289);
		hash.remove(5234);
		hash.remove(2345);
		boolean resultado = hash.remove(3254);
		assertEquals(false, resultado);
	}

	@Test
	public void testRemover6() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(23);
		hash.add(54);
		hash.add(45);
		hash.add(31);
		hash.add(89);
		hash.add(34);
		hash.add(94);
		hash.add(2);
		hash.add(3);
		hash.add(4);
		hash.add(1);
		hash.add(8);
		hash.add(5);
		hash.add(9);
		hash.add(234);
		hash.add(99);
		hash.add(98);
		hash.add(97);
		hash.add(96);
		hash.add(95);
		hash.add(94);
		hash.add(93);
		hash.remove(9);
		hash.remove(31);
		hash.remove(93);
		hash.remove(234);
		hash.remove(3254);
		int resultado = hash.size();
		assertEquals(9, resultado);
	}

	@Test
	public void testContem1() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		System.out.println(hash.toString());
		boolean resultado = hash.contains(8945);
		assertEquals(false, resultado);
	}

	@Test
	public void testContem2() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.add(2345);
		hash.remove(8945);
		boolean resultado = hash.contains(8975);
		assertEquals(false, resultado);
	}

	@Test
	public void testContem3() {
		hash.add(3254);
		hash.remove(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		hash.add(2345);
		boolean resultado = hash.contains(3254);
		assertEquals(false, resultado);
	}

	@Test
	public void testContem4() {
		boolean resultado = hash.contains(3245);
		assertEquals(false, resultado);
	}

	@Test
	public void testContem5() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.remove(3254);
		hash.remove(3245);
		hash.remove(3289);
		hash.remove(5234);
		boolean resultado = hash.contains(3231);
		assertEquals(true, resultado);
	}

	@Test
	public void testContem6() {
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(23);
		hash.add(54);
		hash.add(45);
		hash.add(31);
		hash.add(89);
		hash.add(34);
		hash.add(94);
		hash.add(2);
		hash.add(3);
		hash.add(4);
		hash.add(1);
		hash.add(8);
		hash.add(5);
		hash.add(9);
		hash.add(234);
		hash.add(99);
		hash.add(98);
		hash.add(97);
		// O numero 96 não esta adicionando porque todos os pontos de colisão
		// estão em uso {0,4,8,12,16,20,24,28}
		// O fator de carga é 71,875
		hash.add(96);
		hash.add(95);
		hash.add(94);
		hash.add(93);
		System.out.println(hash.toString());
		boolean resultado = hash.contains(96);
		assertEquals(true, resultado);
	}

	@Test
	public void testeIterator() {
		hash.add(11);
		hash.add(271);
		hash.add(391);
		
		System.out.println(hash.Iterator().hasNext());


		while (hash.Iterator().hasNext()) {
			String resultado = hash.Iterator().next().toString();
			System.out.println(resultado);
		}
		// boolean resultado = hash.contains(3245);
//		assertEquals(true, resultado);
	}
}