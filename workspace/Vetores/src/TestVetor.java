import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import vetor_2014.Vetor;


public class TestVetor {

	@Test
	public void TesteInserir() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		System.out.println(vetor.Tamanho());		
	}
	
	@Test /* 10 , 1 , 9*/
	public void TesteToString() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		vetor.Remover(2);
		vetor.Adicionar(1, 9);
		vetor.RemoverInicio();
		vetor.RemoverFim();
		vetor.AdicionarInicio(1);
		vetor.Adicionar(0, 10);
		System.out.println(vetor.toString());		
	}
	/* 9 , 2 */
	@Test
	public void TesteToString1() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		vetor.Remover(2);
		vetor.Adicionar(1, 9);
		vetor.RemoverInicio();
		System.out.println(vetor.toString());		
	}
	
	@Test /* 1 */
	public void TesteToString2() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(3);
		vetor.Adicionar(1, 9);
		vetor.RemoverInicio();
		vetor.RemoverInicio();
		vetor.RemoverFim();
		vetor.AdicionarInicio(1);
		System.out.println(vetor.toString());		
	}
	@Test /* 0 ,1 , 2 , 3*/
	public void TesteToString3() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(2);
		vetor.Adicionar(1, 1);
		vetor.AdicionarInicio(9);
		System.out.println(vetor.toString());		
	}
	@Test
	public void TesteToString4() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		vetor.Adicionar(4);
		vetor.Adicionar(5);
		vetor.Adicionar(6);
		vetor.Adicionar(7);
		vetor.Adicionar(8);
		vetor.Adicionar(9);
		System.out.println(vetor.toString());		
	}
	@Test
	public void TesteToString5() {
		Vetor<Integer> vetor = new Vetor<Integer>();
		vetor.Adicionar(1);
		vetor.Adicionar(2);
		vetor.Adicionar(3);
		vetor.Remover(2);
		vetor.Adicionar(1, 9);
		vetor.RemoverInicio();
		vetor.RemoverFim();
		vetor.AdicionarInicio(1);
		vetor.Adicionar(0, 10);
		System.out.println(vetor.toString());		
	}
	
}
