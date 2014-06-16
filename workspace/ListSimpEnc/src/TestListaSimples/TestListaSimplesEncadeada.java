package TestListaSimples;

import static org.junit.Assert.*;
import listSimples.ListSimpEnc;

import org.junit.Before;
import org.junit.Test;

public class TestListaSimplesEncadeada {

	ListSimpEnc<Integer> lista;
	ListSimpEnc<Integer> listaDois;

	@Before
	public void Iniciar() {
		lista = new ListSimpEnc<Integer>();
		listaDois = new ListSimpEnc<Integer>();
	}

	@Test
	public void InserirNoInicioTest() {
		lista.InserirInicio(9);
		assertEquals(1, lista.size());
	}

	@Test
	public void ContemTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals(true, lista.contem(2));
	}

	@Test
	public void NaoContemTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals(false, lista.contem(10));
	}

	@Test
	public void InserirVariosInicioTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals("[1, 2, 6, 9]", lista.toString());
	}

	@Test
	public void InserirVariosFimTest() {
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);
		lista.InserirFim(9);
		assertEquals("[1, 2, 6, 9]", lista.toString());
	}

	@Test
	public void InserirDoisFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		assertEquals("[9, 2]", lista.toString());
	}

	@Test
	public void InserirTresFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		assertEquals("[9, 2, 1]", lista.toString());
	}

	@Test
	public void InserirPosTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.Inserir(1, (Integer) 6);
		assertEquals("[9, 6, 2, 1]", lista.toString());
	}

	@Test
	public void InserirPosFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.Inserir(3, (Integer) 6);
		assertEquals("[9, 2, 1, 6]", lista.toString());
	}

	@Test
	public void RemoverInicioTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.RemoverInicio();
		assertEquals("[2, 1]", lista.toString());
	}

	@Test
	public void RemoverUnicoTest() {
		lista.InserirFim(9);
		lista.RemoverInicio();
		System.out.println(lista.toString());
		assertEquals("[]", lista.toString());
	}

	@Test
	public void RemoverTresTest() {
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.InserirInicio(9);
		lista.RemoverInicio();
		assertEquals("[2, 1]", lista.toString());
	}

	@Test
	public void RemoverFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.RemoverFim();
		// assertEquals("[9, 2]", lista.toString());
		System.out.println(lista.toString());
	}

	@Test
	public void RemoverFimUnicoTest() {
		lista.InserirFim(9);
		lista.RemoverFim();
		assertEquals("[]", lista.toString());
	}

	@Test
	public void InserirElementoTest() {
		lista.InserirFim(9);
		lista.Inserir((Integer) 9, (Integer) 3);
		assertEquals("[9, 3]", lista.toString());
	}

	@Test
	public void InserirElementoFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(3);
		lista.Inserir((Integer) 3, (Integer) 6);
		assertEquals("[9, 3, 6]", lista.toString());
	}

	@Test
	public void InserirElementoMeioTest() {
		lista.InserirFim(9);
		lista.InserirFim(3);
		lista.Inserir((Integer) 9, (Integer) 8);
		assertEquals("[9, 8, 3]", lista.toString());
		System.out.println(lista.toString());
	}

	@Test
	public void InserirElementoIguaisTest() {
		lista.InserirFim(9);
		lista.InserirFim(3);
		lista.InserirFim(9);
		lista.Inserir((Integer) 9, (Integer) 8);
		assertEquals("[9, 8, 3, 9]", lista.toString());
	}

	@Test
	/* (expected = IndexOutOfBoundsException.class) */
	public void InserirElementoNaoEncontradoTest() {
		lista.InserirFim(9);
		lista.InserirFim(3);
		lista.Inserir((Integer) 15, (Integer) 8);
		assertEquals("[9, 3]", lista.toString());
	}

	@Test
	public void CompararListas() {
		lista.InserirInicio(3);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		listaDois.InserirInicio(3);
		listaDois.InserirInicio(2);
		listaDois.InserirInicio(1);

		System.out.println(lista.toString());
		System.out.println(listaDois.toString());
		System.out.println(lista.CompararLista(listaDois));
		assertEquals(true, lista.CompararLista(listaDois));
	}

	@Test
	public void CompararListas1() {
		lista.InserirInicio(1);
		lista.InserirInicio(2);
		lista.InserirInicio(3);

		listaDois.InserirInicio(3);
		listaDois.InserirInicio(2);
		listaDois.InserirInicio(1);

		System.out.println(lista.toString());
		System.out.println(listaDois.toString());
		System.out.println(lista.CompararLista(listaDois));
		assertEquals(false, lista.CompararLista(listaDois));
	}

	@Test
	public void CompararListas3() {
		lista.InserirInicio(1);

		listaDois.InserirInicio(3);
		listaDois.InserirInicio(2);
		listaDois.InserirInicio(1);

		System.out.println(lista.toString());
		System.out.println(listaDois.toString());
		System.out.println(lista.CompararLista(listaDois));
		assertEquals(false, lista.CompararLista(listaDois));
	}

	/*
	 * @Test public void InverterLista() { lista.InserirInicio(3);
	 * lista.InserirInicio(2); lista.InserirInicio(1);
	 * System.out.println("Antes " + lista.toString()); lista.inverterLista();
	 * System.out.println("Depois " + lista.toString()); }
	 */

	@Test
	public void InserirPosicao() {
		lista.Inserir(0, (Integer) 1);
		lista.Inserir(1, (Integer) 2);
		lista.Inserir(2, (Integer) 3);
		System.out.println(lista.toString());

	}

	@Test
	public void RetornaElementosFaixaTest() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		lista.InserirFim(4);
		lista.InserirFim(5);
		lista.InserirFim(6);
		lista.InserirFim(7);
		lista.InserirFim(8);
		lista.InserirFim(9);
		lista.InserirFim(10);

		System.out.println(lista.toString());
		ListSimpEnc<Integer> novaLista = new ListSimpEnc<Integer>();
		novaLista = lista.subLista(3, 7);
		System.out.println("Tamanho da lista: " + lista.size());
		System.out.println("Elementos entre a faixa: " + novaLista.toString());
	}
	
	@Test
	public void RetornaElementosFaixa1Test() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		lista.InserirFim(4);
		lista.InserirFim(5);
		lista.InserirFim(6);
		lista.InserirFim(7);
		lista.InserirFim(8);
		lista.InserirFim(9);
		lista.InserirFim(10);

		System.out.println(lista.toString());
		ListSimpEnc<Integer> novaLista = new ListSimpEnc<Integer>();
		novaLista = lista.subLista(3, 15);
		System.out.println("Tamanho da lista: " + lista.size());
		System.out.println("Elementos entre a faixa: " + novaLista.toString());
	}

	@Test
	public void RetornaElementosFaixa3Test() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		lista.InserirFim(4);
		lista.InserirFim(5);
		lista.InserirFim(6);
		lista.InserirFim(7);
		lista.InserirFim(8);
		lista.InserirFim(9);
		lista.InserirFim(10);

		System.out.println(lista.toString());
		ListSimpEnc<Integer> novaLista = new ListSimpEnc<Integer>();
		novaLista = lista.subLista(-1, 7);
		System.out.println("Tamanho da lista: " + lista.size());
		System.out.println("Elementos entre a faixa: " + novaLista.toString());
	}
	@Test
	public void RetornaElementosFaixa4Test() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		lista.InserirFim(4);
		lista.InserirFim(5);
		lista.InserirFim(6);
		lista.InserirFim(7);
		lista.InserirFim(8);
		lista.InserirFim(9);
		lista.InserirFim(10);

		System.out.println(lista.toString());
		ListSimpEnc<Integer> novaLista = new ListSimpEnc<Integer>();
		novaLista = lista.subLista(-2, 16);
		System.out.println("Tamanho da lista: " + lista.size());
		System.out.println("Elementos entre a faixa: " + novaLista.toString());
	}
	
}


