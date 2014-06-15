package br.ed.teste;

import static org.junit.Assert.*;

import org.junit.Test;
import br.ed.hashingEnc.HashSimpEnc;

public class Teste {

	@Test
	public void test() {
		HashSimpEnc<Integer> hash = new HashSimpEnc<Integer>(10);
		hash.add(3254);
		hash.add(3245);
		hash.add(3231);
		hash.add(3289);
		hash.add(5234);
		hash.add(8945);
		hash.remove(8945);
		hash.add(2345);
		int resultado = hash.size();
		assertEquals(4, resultado);
	}

	@Test
	public void testContem() {
		HashSimpEnc<Integer> hash = new HashSimpEnc<Integer>(10);
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
		HashSimpEnc<Integer> hash = new HashSimpEnc<Integer>(10);
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
		HashSimpEnc<Integer> hash = new HashSimpEnc<Integer>(10);
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
}