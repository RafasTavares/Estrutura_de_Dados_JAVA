package TesteVetor;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import vetor_2014.Vetor;

public class TesteVetor {

	private  Vetor<Integer> lista;

	@Before
	public  void Iniciar() {
		lista = new Vetor<Integer>(3);
	}

	@Test
	public void VetorTest() {
		lista.Adicionar(7);
		assertEquals(1, lista.Tamanho());
	}

	@Test
	public void VetorIncrementoTest() {
		lista.Adicionar(7);
		lista.Adicionar(5);
		lista.Adicionar(9);
		assertEquals(3, lista.Tamanho());
	}

	@Test
	public void ContemTest() {
		lista.Adicionar(5);
		boolean resultado = lista.contem(5);
		assertEquals(true, resultado);
	}

	@Test
	public void NaoContemTest() {
		boolean resultado = lista.contem(76);
		assertEquals(false, resultado);
	}

	@Test
	public void AdicionarPosicaoTest() {
		lista.Adicionar(7);
		lista.Adicionar(5);
		lista.Adicionar(9);
		lista.Adicionar(3, 1);
		assertEquals(4, lista.Tamanho());
	}

	@Test
	public void Contem2Test() {
		lista.Adicionar(7);
		lista.Adicionar(5);
		lista.Adicionar(9);
		boolean resultado = lista.contem(9);
		assertEquals(true, resultado);
	}

	@Test
	public void RemoverTest() {
		lista.Adicionar(7);
		lista.Adicionar(5);
		lista.Adicionar(9);
		
		lista.Remover(2);
		boolean resultado = lista.contem(9);
		assertEquals(false, resultado);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void RemoverExTest() {
		lista.Remover(7);
	}
	
	@Test
	public void IteratorTest() {
		lista.Adicionar(7);
		lista.Adicionar(5);
		lista.Adicionar(9);
		
		Iterator<Integer> iterator = lista.iterator();
		int resultado = iterator.next();
		assertEquals(7, resultado);
	}
	
	@Test
	public void Iterator2Test() {
		Iterator<Integer> iterator = lista.iterator();
		
		assertFalse(iterator.hasNext());
	}
}