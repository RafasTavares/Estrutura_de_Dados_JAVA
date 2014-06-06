package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaVetorTest {

	private FilaVetor<Integer> filaVetor; 
	
	@Before
	public void Iniciar() {
		filaVetor = new FilaVetor<Integer>(Integer.class);
	}

	@Test
	public void FilaVaziaTest() {
		String resultado = filaVetor.toString();
		assertEquals("[]", resultado);
	}
	
	@Test
	public void Enfileirar() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		String resultado = filaVetor.toString();
		assertEquals("[10,20,30]", resultado);
	}
	
	@Test
	public void EnfileirarTest() throws FilaVaziaException {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Remover();
		filaVetor.Enfileirar(30);
		String resultado = filaVetor.toString();
		assertEquals("[20,30]", resultado);
	}
	
	@Test
	public void getInicioTest() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		int resultado = filaVetor.getInicio();
		assertEquals(10, resultado);
	}
	
	@Test
	public void getInicioTest2() throws FilaVaziaException {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.Remover();
		filaVetor.Enfileirar(30);
		int resultado = filaVetor.getInicio();
		assertEquals(20, resultado);
	}
	
	@Test
	public void getInicioVazioTest() {
		assertNull( filaVetor.getInicio());
	}
	
	@Test
	public void getFimTest() throws FilaVaziaException{
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		int resultado = filaVetor.getFim();
		assertEquals(30, resultado);
	}
	
	@Test
	public void getFimTest2() throws FilaVaziaException{
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.Remover();
		int resultado = filaVetor.getFim();
		assertEquals(30, resultado);
	}
	
	@Test
	public void getFimTestVazio() throws FilaVaziaException {
		assertNull(filaVetor.getFim());
	}
	
	@Test
	public void LimparTest() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.limpar();
		
		assertEquals(false, filaVetor.contem(10));
	}
	
	@Test(expected=FilaVaziaException.class)
	public void LimparExTest() throws FilaVaziaException {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.limpar();
		filaVetor.Remover();
	}
	
	@Test
	public void RemoverTest() throws FilaVaziaException{
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.Remover();
		String resultado = filaVetor.toString();
		assertEquals("[20,30]", resultado);
	}
	
	@Test(expected=FilaVaziaException.class)
	public void RemoverExTest2() throws FilaVaziaException{
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Remover();
		filaVetor.Remover();
		filaVetor.Remover();
	}

	@Test
	public void ContemTest() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		
		assertEquals(true, filaVetor.contem(20));
	}
	
	@Test
	public void ContemTest2() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		
		assertEquals(false, filaVetor.contem(40));
	}

	@Test
	public void ContemTest3() throws FilaVaziaException{
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Remover();
		filaVetor.Enfileirar(30);
		
		assertEquals(true, filaVetor.contem(20));
	}
	
	@Test
	public void ToArrayTest() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		Object[] lista = filaVetor.toArray();
		assertEquals(3, lista.length);
	}
	
	@Test
	public void ToArrayTest2() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		Object[] lista = filaVetor.toArray();
		assertEquals(20, lista[1]);
	}
	
	@Test
	public void IteratorTest() {
		boolean resultado = filaVetor.iterator().hasNext();
		assertEquals(false, resultado);
	}
	
	@Test
	public void IteratorTest2() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		
		boolean resultado = filaVetor.iterator().hasNext();
		assertEquals(true, resultado);
	}
	
	@Test
	public void IteratorTest3() {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		
		int resultado = filaVetor.iterator().next();
		assertEquals(10, resultado);
	}
	
	@Test
	public void IteratorTest4() throws FilaVaziaException {
		filaVetor.Enfileirar(10);
		filaVetor.Enfileirar(20);
		filaVetor.Enfileirar(30);
		filaVetor.Remover();
		int resultado = filaVetor.iterator().next();
		assertEquals(20, resultado);
	}

}
