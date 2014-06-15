package br.ed.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ed.bbinaria.Sort;

public class Teste {

	@Test
	public void testAddOrdenado() {
		Sort<Integer> sort = new Sort<Integer>(Integer.class);
		for (int i = 1; i < 1000; i++) {
			sort.Adicionar(i);			
		}

		int resultado = sort.contem(201);
		assertEquals(200, resultado);
	}
	
	@Test
	public void testAdd() {
		Sort<Integer> sort = new Sort<Integer>(Integer.class);
		sort.Adicionar(5);
		sort.Adicionar(4);
		sort.Adicionar(3);
		sort.Adicionar(2);
		sort.Adicionar(1);
		System.out.println(sort.toString());
	}

}
