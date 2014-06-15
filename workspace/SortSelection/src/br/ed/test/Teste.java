package br.ed.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ed.sortSelection.Sort;

public class Teste {

	@Test
	public void testAddOrdenado() {
		Sort<Integer> sort = new Sort<Integer>(Integer.class);
		sort.Adicionar(5);
		sort.Adicionar(4);
		sort.Adicionar(3);
		sort.Adicionar(2);
		sort.Adicionar(1);
		sort.Ordenar();
		System.out.println("Ordenado " + sort.toString());
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
