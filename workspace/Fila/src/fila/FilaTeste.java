package fila;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilaTeste {

	FilaEnc fila = new FilaEnc<Integer>();
	FilaVetor<Integer> filaVetor = new FilaVetor<Integer>(Integer.class);

	
	@Test
	public void testeAdd(){
		fila.Enfileirar(1);
		fila.Enfileirar(2);
		fila.Enfileirar(3);
		
		assertEquals(true, fila.contem(2));
	}
	
	@Test
	public void remover() throws FilaVaziaException{
		fila.Enfileirar(1);
		fila.Enfileirar(2);
		fila.Enfileirar(3);
		
		assertEquals(2, fila.Remover());
	}
	
	@Test
	public void testeAddVetor(){
		fila.Enfileirar(1);
		fila.Enfileirar(2);
		fila.Enfileirar(3);
		
		assertEquals(true, fila.contem(2));
	}
	
	@Test
	public void testeRemoverVetor() throws FilaVaziaException{
		fila.Enfileirar(1);
		fila.Enfileirar(2);
		fila.Enfileirar(3);
		
		assertEquals(1, fila.Remover());
	}
}
