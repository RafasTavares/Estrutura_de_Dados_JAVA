package TestlistaDupla;

import static org.junit.Assert.*;

import java.util.Iterator;

import listaDupla.ListDupEnc;

import org.junit.Before;
import org.junit.Test;

public class TesteListaDupla {

	private ListDupEnc<Integer> lista;

	@Before
	public void Iniciar() {

		lista = new ListDupEnc<Integer>();
		lista.InserirInicio(8);
	}

	@Test
	public void ListaComElemento() {

		assertEquals("[8]", lista.toString());
	}

	@Test
	public void ListaComDois() {
		lista.InserirInicio(9);
		assertEquals("[9, 8]", lista.toString());
	}

	@Test
	public void ListaComTres() {
		lista.InserirInicio(9);
		lista.InserirInicio(2);
		assertEquals("[2, 9, 8]", lista.toString());
		System.out.println(lista.toString());
	}

	@Test
	public void ListaFimComDois() {
		lista.InserirFim(2);
		assertEquals("[8, 2]", lista.toString());
	}

	@Test
	public void ListaFimComTres() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals("[8, 2, 9]", lista.toString());
	}

	@Test
	public void ListaPos() {
		lista.Inserir(0, 2);
		assertEquals("[2, 8]", lista.toString());
	}

	@Test
	public void ListaPosDois() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.Inserir(1, 6);
		assertEquals("[8, 6, 2, 9]", lista.toString());
	}

	@Test
	public void ListaPosFim() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.Inserir(2, 6);
		assertEquals("[8, 2, 6, 9]", lista.toString());
	}

	@Test
	public void ListaContem() {
		assertEquals(true, lista.contem(8));
	}

	@Test
	public void ListaContemUltimo() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(true, lista.contem(9));
	}

	@Test
	public void ListaContemMeio() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(true, lista.contem(2));
	}

	@Test
	public void ListaNaoContem() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(false, lista.contem(19));
	}

	@Test
	public void ListaRemoverInicio() {
		lista.RemoverInicio();
		assertEquals("[]", lista.toString());
	}

	@Test
	public void ListaRemoverUm() {
		lista.InserirFim(2);
		lista.RemoverInicio();
		assertEquals("[2]", lista.toString());
	}

	@Test
	public void ListaRemoverDois() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.RemoverInicio();
		assertEquals("[2, 9]", lista.toString());
	}

	@Test
	public void ListaRemoverTres() {
		lista.InserirFim(2);
		lista.InserirFim(7);
		lista.InserirInicio(9);
		lista.RemoverInicio();
		assertEquals("[8, 2, 7]", lista.toString());
	}

	@Test
	public void ListaRemoverFim() {
		lista.RemoverFim();
		assertEquals("[]", lista.toString());
	}

	@Test
	public void ListaRemoverFimDois() {
		lista.InserirFim(2);
		lista.RemoverFim();
		assertEquals("[8]", lista.toString());
	}

	@Test
	public void ListaRemoverFimTres() {
		lista.InserirFim(2);
		lista.InserirFim(7);
		lista.InserirInicio(9);
		lista.RemoverFim();
		assertEquals("[9, 8, 2]", lista.toString());
	}

	@Test
	public void ListaRemoverFimVarios() {
		lista.InserirInicio(2);
		lista.RemoverFim();
		assertEquals("[2]", lista.toString());
	}

	@Test
	public void RemoverNaPos() {
		lista.InserirInicio(3);
		lista.InserirInicio(2);
		lista.InserirInicio(1);
		System.out.println(lista.toString());
		lista.RemoverPos(1);
		lista.RemoverPos(2);
		System.out.println(lista.toString());
	}

	@Test
	public void RemoverTodos() {
		lista.InserirInicio(5);
		lista.InserirInicio(8);
		lista.InserirInicio(10);
		lista.InserirInicio(5);
		lista.InserirInicio(2);
		lista.InserirInicio(4);
		lista.InserirInicio(3);
		lista.InserirInicio(2);
		System.out.println(lista.toString());
		lista.RemoverTodos(8);
		System.out.println(lista.toString());
		lista.RemoverTodos(2);
		System.out.println(lista.toString());
	}

	@Test
	public void RemoverTodosII() {
	
	
	}

	@Test
	public void retornaPosicao() {
		lista.InserirInicio(3);
		lista.InserirInicio(9);
		lista.InserirInicio(1);
		System.out.println(lista.toString());
		System.out.println("9 posição: " + lista.RetornaPos(9));
		System.out.println("8 Posição: " + lista.RetornaPos(8));
	}
}

/*
 * @Test public void TestInterator() { Iterator<Integer> i = lista.iterator();
 * int valor = i.next(); assertEquals(8, valor); }
 * 
 * @Test public void TestTerceiroInterator() { lista.InserirFim(2);
 * lista.InserirFim(4); lista.InserirFim(6); Iterator<Integer> i =
 * lista.iterator(); int valor = i.next(); valor = i.next(); valor = i.next();
 * assertEquals(4, valor); }
 * 
 * @Test public void TestUltimoInterator() { lista.InserirFim(2);
 * lista.InserirFim(4); lista.InserirFim(6); Iterator<Integer> i =
 * lista.iterator(); int valor = i.next(); valor = i.next(); valor = i.next();
 * valor = i.next(); assertEquals(6, valor); } }
 */