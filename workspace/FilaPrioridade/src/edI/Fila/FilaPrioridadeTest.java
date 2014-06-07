package edI.Fila;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FilaPrioridadeTest {

	private FilaPrioridade<Integer> filaVetor;

	@Before
	public void Inicializar() {
		// pilhaVetor = new PilhaVetor<Integer>(8, Integer.class);
		filaVetor = new FilaPrioridade<Integer>();
	}

	/*
	 * @Test public void FilaVaziaTest() { String resultado =
	 * filaVetor.toString(); assertEquals("[]", resultado); }
	 */

	@Test
	public void EnfileirarTest() throws PilhaCheiaException {
		filaVetor.Enfileirar(20, 0);
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(30, 2);
		System.out.println(filaVetor.toString());

		// assertEquals("[10, 30, 20]", filaVetor.toString());
		assertEquals(3, filaVetor.Tamanho());
	}

	@Test
	public void EnfileirarTestDois() throws PilhaCheiaException {
		filaVetor.Enfileirar(20, 0);
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(30, 2);

		assertEquals("[20, 10, 30]", filaVetor.toString());
	}

	@Test
	public void EnfileirarTestTres() throws PilhaCheiaException {
		filaVetor.Enfileirar(20, 3);
		filaVetor.Enfileirar(70, 2);
		filaVetor.Enfileirar(30, 0);
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(80, 5);
		filaVetor.Enfileirar(39, 4);

		assertEquals("[30, 10, 70, 20, 39, 80]", filaVetor.toString());
	}

	@Test
	public void EnfileirarTestQuatro() throws PilhaCheiaException {
		filaVetor.Enfileirar(20, 0);
		filaVetor.Enfileirar(8, 1);
		filaVetor.Enfileirar(11, 2);

		assertEquals("[20, 8, 11]", filaVetor.toString());
	}

	@Test
	public void RemoverTest() throws PilhaCheiaException, FilaVaziaException {
		filaVetor.Enfileirar(20, 0);
		filaVetor.Enfileirar(8, 1);
		filaVetor.Enfileirar(11, 2);
		filaVetor.Remover();

		assertEquals("[8, 11]", filaVetor.toString());
	}

	// Testar com prioridade iguais.

	@Test
	public void RemoverTestDois() throws FilaVaziaException,
			PilhaCheiaException {
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(20, 0);
		filaVetor.Enfileirar(30, 2);
		filaVetor.Remover(); // assertEquals("[20, 10, 30]",
		assertEquals(2, filaVetor.Tamanho());
	}

	@Test
	public void RemoverTestTres() throws FilaVaziaException,
			PilhaCheiaException {
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(8, 0);
		filaVetor.Enfileirar(6, 2);
		filaVetor.Remover(); // assertEquals("[20, 10, 30]",
		assertEquals(2, filaVetor.Tamanho());
	}

	@Test
	public void EnfileirarRemoverTest() throws FilaVaziaException,
			PilhaCheiaException {
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(20, 0);
		filaVetor.Remover();
		filaVetor.Enfileirar(30, 2);

		String resultado = filaVetor.toString();
		assertEquals("[10, 30]", resultado);
	}

	@Test
	public void EstaVazia() throws PilhaCheiaException, FilaVaziaException {
		filaVetor.Enfileirar(10, 1);
		filaVetor.Enfileirar(20, 0);
		filaVetor.Remover();
		filaVetor.Enfileirar(30, 2);
		filaVetor.Remover();
		filaVetor.Remover();
		assertEquals(true, filaVetor.estaVazia());
	}

	@Test(expected = PilhaCheiaException.class)
	public void EnfileirarTestSeis() throws PilhaCheiaException,
			FilaVaziaException {
		filaVetor.Enfileirar(30, 0);
		filaVetor.Enfileirar(30, 1);
		filaVetor.Enfileirar(30, 2);
		filaVetor.Enfileirar(30, 3);
		filaVetor.Enfileirar(30, 4);
		filaVetor.Enfileirar(30, 5);
		filaVetor.Enfileirar(30, 6);
		filaVetor.Enfileirar(30, 7);
		filaVetor.Enfileirar(30, 8);
		filaVetor.Enfileirar(30, 9);
		filaVetor.Enfileirar(30, 10);
	}

	@Test
	public void EnfileirarOrdenacao() throws PilhaCheiaException,
			FilaVaziaException {
		filaVetor.Enfileirar(5, 5);
		filaVetor.Enfileirar(4, 2);
		filaVetor.Enfileirar(3, 3);
		filaVetor.Enfileirar(2, 1);
		filaVetor.Enfileirar(1, 1);
		System.out.println(filaVetor.toString());
	}

	@Test
	public void getMenorPrioridade() throws PilhaCheiaException,
			FilaVaziaException {
		filaVetor.Enfileirar(5, 1);
		filaVetor.Enfileirar(4, 2);
		filaVetor.Enfileirar(3, 3);
		filaVetor.Enfileirar(2, 4);
		filaVetor.Enfileirar(1, 5);
		System.out.println(filaVetor.toString());
		System.out.println(filaVetor.getMenorPrioridade());
	}

	@Test(expected = FilaVaziaException.class)
	public void getMenorPrioridadeException() throws PilhaCheiaException,
			FilaVaziaException {
		/*
		 * filaVetor.Enfileirar(5, 1); filaVetor.Enfileirar(4, 2);
		 * filaVetor.Enfileirar(3, 3); filaVetor.Enfileirar(2, 4);
		 * filaVetor.Enfileirar(1, 5);
		 */
		System.out.println(filaVetor.getMenorPrioridade());
	}

	@Test
	public void getMaiorPrioridade() throws PilhaCheiaException,
			FilaVaziaException {
		filaVetor.Enfileirar(5, 1);
		filaVetor.Enfileirar(4, 2);
		filaVetor.Enfileirar(3, 3);
		filaVetor.Enfileirar(2, 4);
		filaVetor.Enfileirar(1, 5);
		System.out.println(filaVetor.toString());
		System.out.println(filaVetor.getMaiorPrioridade());
	}

	@Test(expected = FilaVaziaException.class)
	public void getMaiorPrioridadeException() throws FilaVaziaException,
			FilaVaziaException {
		/*
		 * filaVetor.Enfileirar(5, 1); filaVetor.Enfileirar(4, 2);
		 * filaVetor.Enfileirar(3, 3); filaVetor.Enfileirar(2, 4);
		 * filaVetor.Enfileirar(1, 5);
		 */
		System.out.println(filaVetor.getMaiorPrioridade());
	}

	@Test
	public void FilaVazia() {
		assertEquals("[]", filaVetor.toString());
		System.out.println(filaVetor.toString());
	}

	@Test(expected = PilhaCheiaException.class)
	public void FilaCheiaExc() throws PilhaCheiaException {
		  filaVetor.Enfileirar(11, 1); 
		  filaVetor.Enfileirar(10, 1); 
		  filaVetor.Enfileirar(9, 2);
		  filaVetor.Enfileirar(8, 3); 
		  filaVetor.Enfileirar(7, 4);
		  filaVetor.Enfileirar(6, 5);
		  filaVetor.Enfileirar(5, 1); 
		  filaVetor.Enfileirar(4, 2);
		  filaVetor.Enfileirar(3, 3); 
		  filaVetor.Enfileirar(2, 4);
		  filaVetor.Enfileirar(1, 5);
	}
}
