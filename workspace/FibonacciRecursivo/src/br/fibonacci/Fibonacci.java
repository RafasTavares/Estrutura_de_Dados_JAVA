package br.fibonacci;

public class Fibonacci {
	public int fibRecursivo(int n) {
		if (n <= 2)
			return 1;
		return fibRecursivo(n - 1) + fibRecursivo(n - 2);
	}

	public int fibInterativo(int numero) {
		int anterior = 0;
		int posterior = 1;
		int soma = 0;
		while (anterior < numero) {
			soma = anterior + posterior;
			anterior = posterior;
			posterior = soma;
		}
		return soma;
	}

	public int Potencia(int x, int y) {
		if (y == 0)
			return 1;
		return x * Potencia(x, y - 1);
	}

	public int PotenciaInterativa(int x, int y) {
		final int aux = x;
		while (y > 1) {
			x *= aux;
			y--;
		}
		return x;
	}
}
