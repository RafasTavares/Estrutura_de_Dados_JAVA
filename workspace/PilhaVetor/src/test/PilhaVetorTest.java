package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pilhaVet.Pilha;
import pilhaVet.PilhaVaziaException;

public class PilhaVetorTest {

	private Pilha<Integer> pilhaVetor;
	
	@Before
	public void Inicializar(){
		pilhaVetor = new Pilha<Integer>();
	}
	
	@Test
	public void PilhaVaziaTest() {
		String resultado = pilhaVetor.toString();
		assertEquals("[]", resultado);
	}
	
	@Test
	public void EmpilharTest() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		String resultado = pilhaVetor.toString();
		assertEquals("[30, 20, 10]", resultado);
	}
	
	@Test
	public void EmpilharDesTest() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.desempilhe();
		pilhaVetor.empilhe(30);
		String resultado = pilhaVetor.toString();
		assertEquals("[30, 10]", resultado);
	}
	
	@Test
	public void getTopoTest() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		int resultado = (int) pilhaVetor.getTopo();
		assertEquals(30, resultado);
	}
	
	@Test
	public void getTopoTest2() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		pilhaVetor.desempilhe();
		pilhaVetor.empilhe(30);
		int resultado = (int) pilhaVetor.getTopo();
		assertEquals(30, resultado);
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void getTopoExTest() throws PilhaVaziaException {
		pilhaVetor.getTopo();
	}
	
	@Test
	public void DesempilheTest() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		pilhaVetor.desempilhe();
		String resultado = pilhaVetor.toString();
		assertEquals("[20, 10]", resultado);
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void DesempilheExTest() throws PilhaVaziaException {
		pilhaVetor.getTopo();
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void DesempilheExTest2() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.desempilhe();
		pilhaVetor.desempilhe();
		pilhaVetor.desempilhe();
	}
	
	@Test
	public void EstaVaziaTest() {
		assertEquals(true, pilhaVetor.estaVazia());
	}
	
	@Test
	public void EstaVaziaTest2() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		assertEquals(false, pilhaVetor.estaVazia());
	}
	
	@Test
	public void EstaVaziaTest3() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.desempilhe();
		pilhaVetor.desempilhe();
		assertEquals(true, pilhaVetor.estaVazia());
	}
	
	@Test
	public void EstaVaziaTest4() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.desempilhe();
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		pilhaVetor.desempilhe();
		
		assertEquals(false, pilhaVetor.estaVazia());
	}
	
	@Test
	public void SizeTest() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.desempilhe();
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		pilhaVetor.desempilhe();
		
		assertEquals(1, pilhaVetor.size());
	}
	
	@Test
	public void SizeTest2() {
		assertEquals(0, pilhaVetor.size());
	}
	
	@Test
	public void SizeTest3() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		
		assertEquals(3, pilhaVetor.size());
	}
	
	@Test
	public void ContemTest() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		
		assertEquals(true, pilhaVetor.contem(20));
	}
	
	@Test
	public void ContemTest2() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		
		assertEquals(false, pilhaVetor.contem(40));
	}

	@Test
	public void ContemTest3() throws PilhaVaziaException {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.desempilhe();
		pilhaVetor.empilhe(30);
		
		assertEquals(false, pilhaVetor.contem(20));
	}
	/*
	@Test
	public void ToArrayTest() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		Object[] lista = pilhaVetor.toArray();
		assertEquals(3, lista.length);
	}
	
	@Test
	public void ToArrayTest2() {
		pilhaVetor.empilhe(10);
		pilhaVetor.empilhe(20);
		pilhaVetor.empilhe(30);
		Object[] lista = pilhaVetor.toArray();
		assertEquals(10, lista[0]);
	}
	*/
}
