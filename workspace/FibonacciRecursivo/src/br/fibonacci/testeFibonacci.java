package br.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class testeFibonacci {

	@Test
	public void testFibonacci() {
		Fibonacci fib = new Fibonacci();
		int resultado = fib.fibRecursivo(6);
		System.out.println("6° elemento: " + resultado);
		assertEquals(resultado, 8);
	}

	@Test
	public void testFibonacciInterativo() {
		Fibonacci fib = new Fibonacci();
		int resultado = fib.fibInterativo(7);
		System.out.println("7° elemento: " + resultado);
		assertEquals(resultado, 13);
	}

	@Test
	public void testPotencia() {
		Fibonacci fib = new Fibonacci();
		long resultado = fib.Potencia(5, 5);
		System.out.println("Potencia Recursiva: " + resultado);
		assertEquals(resultado, 3125);
	}

	@Test
	public void testPotenciaInterativa() {
		Fibonacci fib = new Fibonacci();
		long resultado = fib.PotenciaInterativa(5, 5);
		System.out.println("Potencia Interativa: " + resultado);
		assertEquals(resultado, 3125);
	}
}