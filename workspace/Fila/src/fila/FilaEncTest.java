package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaEncTest {

	private FilaEnc<Integer> filaEncadeada;

	@Before
	public void Iniciar() {
		filaEncadeada = new FilaEnc<Integer>();
	}

	@Test
	public void FilaVaziaTest() {
		String resultado = filaEncadeada.toString();
		assertEquals("[]", resultado);
	}

	@Test
	public void Enfileirar() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		String resultado = filaEncadeada.toString();
		assertEquals("[10,20,30]", resultado);
	}

	@Test
	public void EnfileirarTest() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Remover();
		filaEncadeada.Enfileirar(30);
		String resultado = filaEncadeada.toString();
		assertEquals("[20,30]", resultado);
	}

	@Test
	public void getInicioTest() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		int resultado = filaEncadeada.getInicio();
		assertEquals(10, resultado);
	}

	@Test
	public void getInicioTest2() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.Remover();
		filaEncadeada.Enfileirar(30);
		int resultado = filaEncadeada.getInicio();
		assertEquals(20, resultado);
	}

	@Test
	public void getInicioVazioTest() {
		assertNull(filaEncadeada.getInicio());
	}

	@Test
	public void getFimTest() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		int resultado = filaEncadeada.getFim();
		assertEquals(30, resultado);
	}

	@Test
	public void getFimTest2() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.Remover();
		int resultado = filaEncadeada.getFim();
		assertEquals(30, resultado);
	}

	@Test
	public void getFimTestVazio() {
		assertNull(filaEncadeada.getFim());
	}

	@Test
	public void LimparTest() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.limpar();

		assertEquals(false, filaEncadeada.contem(10));
	}

	@Test(expected = FilaVaziaException.class)
	public void LimparExTest() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.limpar();
		filaEncadeada.Remover();
	}

	@Test
	public void RemoverTest() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.Remover();
		String resultado = filaEncadeada.toString();
		assertEquals("[20,30]", resultado);
	}

	@Test(expected = FilaVaziaException.class)
	public void RemoverExTest2() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Remover();
		filaEncadeada.Remover();
		filaEncadeada.Remover();
	}

	@Test
	public void ContemTest() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);

		assertEquals(true, filaEncadeada.contem(20));
	}

	@Test
	public void ContemTest2() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);

		assertEquals(false, filaEncadeada.contem(40));
	}

	@Test
	public void ContemTest3() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Remover();
		filaEncadeada.Enfileirar(30);

		assertEquals(true, filaEncadeada.contem(20));
	}

	@Test
	public void ToArrayTest() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		Object[] lista = filaEncadeada.toArray();
		assertEquals(3, lista.length);
	}

	@Test
	public void ToArrayTest2() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		Object[] lista = filaEncadeada.toArray();
		assertEquals(20, lista[1]);
	}

	@Test
	public void IteratorTest() {
		boolean resultado = filaEncadeada.iterator().hasNext();
		assertEquals(false, resultado);
	}

	@Test
	public void IteratorTest2() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);

		boolean resultado = filaEncadeada.iterator().hasNext();
		assertEquals(true, resultado);
	}

	@Test
	public void IteratorTest3() {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);

		int resultado = filaEncadeada.iterator().next();
		assertEquals(10, resultado);
	}

	@Test
	public void IteratorTest4() throws FilaVaziaException {
		filaEncadeada.Enfileirar(10);
		filaEncadeada.Enfileirar(20);
		filaEncadeada.Enfileirar(30);
		filaEncadeada.Remover();
		int resultado = filaEncadeada.iterator().next();
		assertEquals(20, resultado);
	}

	
	@Test
	public void RetornPosicao () throws FilaVaziaException{
	filaEncadeada.Enfileirar(1);
	filaEncadeada.Enfileirar(2);
	filaEncadeada.Enfileirar(3);
	filaEncadeada.Enfileirar(4);
	filaEncadeada.Enfileirar(5);
	System.out.println(filaEncadeada.toString());
	System.out.println(filaEncadeada.PosicaoFila(1));
	System.out.println(filaEncadeada.PosicaoFila(2));
	System.out.println(filaEncadeada.PosicaoFila(3));
	System.out.println(filaEncadeada.PosicaoFila(4));
	System.out.println(filaEncadeada.PosicaoFila(5));
	System.out.println(filaEncadeada.PosicaoFila(6));
	filaEncadeada.Enfileirar(6);
	filaEncadeada.Remover();
	System.out.println(filaEncadeada.PosicaoFila(1));
	System.out.println(filaEncadeada.PosicaoFila(6));	
		
	}
}
