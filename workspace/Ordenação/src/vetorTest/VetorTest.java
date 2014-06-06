package vetorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import vetor.Vetor;

public class VetorTest {
	Vetor<Integer> vetor;

	public VetorTest() {
		vetor = new Vetor<Integer>(10, Integer.class);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInserir() {
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.AdicionarInicio(0);
		System.out.println("Vetor inserir: " + vetor.toString());
		vetor.Adicionar(9999, 3);
		vetor.Adicionar(-23, 4);
	}

	@Test
	public void TesteRemoverFim() {
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.AdicionarInicio(0);
		vetor.RemoverFim();
		System.out.println("Vetor remover fim: " + vetor.toString());
	}

	@Test
	public void TesteRemoverPos() {
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.AdicionarInicio(0);
		vetor.Remover(1);
		System.out.println("Vetor remover posicao: " + vetor.toString());
	}

	@Test
	public void TestTamanho() {
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.AdicionarInicio(0);
		System.out.println("Vetor tamanho: " + vetor.Tamanho());
	}

	@Test
	public void TestContem() {
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.AdicionarInicio(0);
		assertEquals(true, vetor.contem(2));

		System.out.println("Teste Contem: ");
		System.out.println("Vetor tamanho: " + vetor.toString());
	}

	@Test
	public void TestBuble() {
		vetor.Adicionar(6);
		vetor.Adicionar(3);
		vetor.Adicionar(1);
		vetor.Adicionar(4);
		vetor.Adicionar(9);
		vetor.Adicionar(7);
		vetor.Adicionar(8);
		vetor.Adicionar(5);
		vetor.Adicionar(10);
		vetor.Adicionar(2);
		System.out.println(vetor.toString());
		vetor.SortBuble();
		System.out.println(vetor.toString());
	}

	@Test
	public void TestInsetionShort() {
		vetor.Adicionar(6);
		vetor.Adicionar(3);
		vetor.Adicionar(1);
		vetor.Adicionar(4);
		vetor.Adicionar(9);
		vetor.Adicionar(7);
		vetor.Adicionar(8);
		vetor.Adicionar(5);
		vetor.Adicionar(10);
		vetor.Adicionar(2);
		System.out.println(vetor.toString());
		vetor.insertionSort();
		System.out.println(vetor.toString());
	}

	@Test
	public void TestSelectionShort() {
		vetor.Adicionar(6);
		vetor.Adicionar(3);
		vetor.Adicionar(1);
		vetor.Adicionar(4);
		vetor.Adicionar(9);
		vetor.Adicionar(7);
		vetor.Adicionar(8);
		vetor.Adicionar(5);
		vetor.Adicionar(10);
		vetor.Adicionar(2);
		System.out.println(vetor.toString());
		vetor.SortSelection();
		System.out.println(vetor.toString());
	}

	@Test
	public void TesteBuscaBinaria() {
		vetor.Adicionar(6);
		vetor.Adicionar(3);
		vetor.Adicionar(1);
		vetor.Adicionar(4);
		vetor.Adicionar(9);
		vetor.Adicionar(7);
		vetor.Adicionar(8);
		vetor.Adicionar(5);
		vetor.Adicionar(10);
		vetor.Adicionar(2);
		System.out.println(vetor.toString());
		vetor.SortSelection();
		System.out.println(vetor.toString());
		System.out.println(vetor.BuscaBinaria(2));
		assertEquals(-1, vetor.BuscaBinaria(111));
		assertEquals(0, vetor.BuscaBinaria(1));
		assertEquals(1, vetor.BuscaBinaria(2));
		assertEquals(2, vetor.BuscaBinaria(3));
		assertEquals(3, vetor.BuscaBinaria(4));
		assertEquals(4, vetor.BuscaBinaria(5));
		assertEquals(5, vetor.BuscaBinaria(6));
		assertEquals(6, vetor.BuscaBinaria(7));

	}
}
