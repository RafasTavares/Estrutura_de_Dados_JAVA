package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pilhaEnc.Pilha;

public class PilhaEncTest {

	private Pilha<Integer> pilhaEnc;

	@Before
	public void Inicializar() {
		pilhaEnc = new Pilha();
	}

	@Test
	public void PilhaVaziaTest() {
		String resultado = pilhaEnc.toString();
		assertEquals("[]", resultado);
	}

	@Test
	public void EmpilharTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		String resultado = pilhaEnc.toString();
		assertEquals("[10,20,30]", resultado);
	}

	@Test
	public void EmpilharDesTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.desempilhe();
		pilhaEnc.empilhe(30);
		String resultado = pilhaEnc.toString();
		assertEquals("[10,30]", resultado);
	}

	@Test
	public void getTopoTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		int resultado = pilhaEnc.getTopo();
		assertEquals(30, resultado);
	}

	@Test
	public void getTopoTest2() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		pilhaEnc.desempilhe();
		pilhaEnc.empilhe(30);
		int resultado = pilhaEnc.getTopo();
		assertEquals(30, resultado);
	}

	@Test(expected = PilhaVaziaException.class)
	public void getTopoExTest() {
		pilhaEnc.getTopo();
	}

	@Test
	public void DesempilheTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		pilhaEnc.desempilhe();
		String resultado = pilhaEnc.toString();
		assertEquals("[10,20]", resultado);
	}

	@Test(expected = PilhaVaziaException.class)
	public void DesempilheExTest() {
		pilhaEnc.getTopo();
	}

	@Test(expected = PilhaVaziaException.class)
	public void DesempilheExTest2() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.desempilhe();
		pilhaEnc.desempilhe();
		pilhaEnc.desempilhe();
	}

	@Test
	public void EstaVaziaTest() {
		assertEquals(true, pilhaEnc.estaVazia());
	}

	@Test
	public void EstaVaziaTest2() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		assertEquals(false, pilhaEnc.estaVazia());
	}

	@Test
	public void EstaVaziaTest3() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.desempilhe();
		pilhaEnc.desempilhe();
		assertEquals(true, pilhaEnc.estaVazia());
	}

	@Test
	public void EstaVaziaTest4() {
		pilhaEnc.empilhe(10);
		pilhaEnc.desempilhe();
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		pilhaEnc.desempilhe();

		assertEquals(false, pilhaEnc.estaVazia());
	}

	@Test
	public void SizeTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.desempilhe();
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		pilhaEnc.desempilhe();

		assertEquals(1, pilhaEnc.size());
	}

	@Test
	public void SizeTest2() {
		assertEquals(0, pilhaEnc.size());
	}

	@Test
	public void SizeTest3() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);

		assertEquals(3, pilhaEnc.size());
	}

	@Test
	public void ContemTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);

		assertEquals(true, pilhaEnc.contem(20));
	}

	@Test
	public void ContemTest2() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);

		assertEquals(false, pilhaEnc.contem(40));
	}

	@Test
	public void ContemTest3() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.desempilhe();
		pilhaEnc.empilhe(30);

		assertEquals(false, pilhaEnc.contem(20));
	}

	@Test
	public void ToArrayTest() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		Object[] lista = pilhaEnc.toArray();
		assertEquals(3, lista.length);
	}

	@Test
	public void ToArrayTest2() {
		pilhaEnc.empilhe(10);
		pilhaEnc.empilhe(20);
		pilhaEnc.empilhe(30);
		Object[] lista = pilhaEnc.toArray();
		assertEquals(10, lista[0]);
	}
}