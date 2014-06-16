package TesteVetor;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import vetor_2014.Vetor;

public class TesteVetor {

	private Vetor<Integer> lista;

	@Before
	public void Iniciar() {
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

	/*
	 * @Test public void IteratorTest() { lista.Adicionar(7);
	 * lista.Adicionar(5); lista.Adicionar(9);
	 * 
	 * Iterator<Integer> iterator = lista.iterator(); int resultado =
	 * iterator.next(); assertEquals(7, resultado); }
	 * 
	 * @Test public void Iterator2Test() { Iterator<Integer> iterator =
	 * lista.iterator();
	 * 
	 * assertFalse(iterator.hasNext()); }
	 */

	@Test
	public void InserirVetorPosTest() {

		Integer[] newlista = new Integer[3];
		newlista[0] = 4;
		newlista[1] = 5;
		newlista[2] = 6;

		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Adicionar(7);
		lista.Adicionar(8);
		System.out.println("Antes: " + lista.toString());
		System.out.println("Nova L: [4, 5, 6]");
		lista.Inserir(3, newlista);
		System.out.println("Depois: " + lista.toString());
	}

	@Test
	public void RemoverTodosTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Adicionar(4);
		lista.Adicionar(5);
		System.out.println("Vetor Inicial: " + lista.toString());
		Vetor<Integer> novoVetor = new Vetor<Integer>(3);	
		novoVetor.Adicionar(1);
		novoVetor.Adicionar(3);
		novoVetor.Adicionar(5);
		System.out.println("Novo Vetor: " + novoVetor.toString());
		lista.RemoverTodos(novoVetor);
		System.out.println("Depois de Remover todos: " + lista.toString());
		System.out.println("Tamanho: " + lista.contem(1));
	}

}
