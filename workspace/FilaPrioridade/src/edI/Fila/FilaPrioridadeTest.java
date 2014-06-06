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
	
	@Test (expected = PilhaCheiaException.class)
	public void EnfileirarTestSeis() throws PilhaCheiaException, FilaVaziaException {
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
	
	//PilhaCheiaException
	
	
	/*
	 * @Test public void getTopoTest() { filaVetor.Enfileirar(10);
	 * filaVetor.Enfileirar(20); filaVetor.Enfileirar(30); int resultado = (int)
	 * filaVetor.getInicio(); assertEquals(10, resultado); }
	 * 
	 * @Test public void getInicioTest2() throws FilaVaziaException {
	 * filaVetor.Enfileirar(10); filaVetor.Enfileirar(20); filaVetor.Remover();
	 * filaVetor.Enfileirar(30); int resultado = (int) filaVetor.getInicio();
	 * assertEquals(20, resultado); }
	 * 
	 * @Test public void getInicioNullTest() { filaVetor.getInicio();
	 * assertEquals(null, filaVetor.getInicio()); }
	 * 
	 * @Test public void RemoverTest() throws FilaVaziaException {
	 * filaVetor.Enfileirar(10); filaVetor.Enfileirar(20);
	 * filaVetor.Enfileirar(30); filaVetor.Remover(); String resultado =
	 * filaVetor.toString(); assertEquals("[20, 30]", resultado); }
	 * 
	 * @Test(expected = FilaVaziaException.class) public void RemoverExTest()
	 * throws FilaVaziaException { filaVetor.Remover(); }
	 * 
	 * @Test(expected = FilaVaziaException.class) public void RemovereExTest2()
	 * throws FilaVaziaException { filaVetor.Enfileirar(10);
	 * filaVetor.Enfileirar(20); filaVetor.Enfileirar(30); filaVetor.Remover();
	 * filaVetor.Remover(); filaVetor.Remover(); filaVetor.Remover();
	 * 
	 * }
	 * 
	 * @Test public void ContemTest() { filaVetor.Enfileirar(10);
	 * filaVetor.contem(10); assertEquals(true, filaVetor.contem(10)); }
	 * 
	 * @Test public void ContemTest2() { filaVetor.Enfileirar(10);
	 * filaVetor.Enfileirar(20); filaVetor.Enfileirar(30); assertEquals(false,
	 * filaVetor.contem(40)); }
	 * 
	 * @Test public void ContemTest3() throws FilaVaziaException {
	 * filaVetor.Enfileirar(10); filaVetor.Enfileirar(20); filaVetor.Remover();
	 * filaVetor.Enfileirar(30);
	 * 
	 * assertEquals(false, filaVetor.contem(10)); } /*
	 * 
	 * @Test public void ToArrayTest() { pilhaVetor.empilhe(10);
	 * pilhaVetor.empilhe(20); pilhaVetor.empilhe(30); Object[] lista =
	 * pilhaVetor.toArray(); assertEquals(3, lista.length); }
	 * 
	 * @Test public void ToArrayTest2() { pilhaVetor.empilhe(10);
	 * pilhaVetor.empilhe(20); pilhaVetor.empilhe(30); Object[] lista =
	 * pilhaVetor.toArray(); assertEquals(10, lista[0]); }
	 */
}
