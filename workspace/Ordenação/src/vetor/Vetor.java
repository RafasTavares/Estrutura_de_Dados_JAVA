package vetor;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Vetor<T extends Comparable<T>> implements IVetor<T> {
	private final short tamVetor = 3;
	private T[] elementos;
	private int tam = 0;
	private int tamInicial = 10;
	private int tamAumentar = 10;
	private Class<T> classe;

	public Vetor() {
		elementos = ((T[]) new Object[tamVetor]);
	}

	public Vetor(int tamInicial, Class<T> classe) {
		this.classe = classe;
		this.elementos = (T[]) (Array.newInstance(classe, tamInicial));
		this.tamInicial = tamInicial;
	}

	public void AumentarTamanho() {
		if (tam - 1 == elementos.length) {
			T[] temp = (T[]) (Array.newInstance(this.classe, elementos.length
					+ tamAumentar));
			// T[] temp = (T[]) new Object[elementos.length + tamAumentar];
			System.arraycopy(elementos, 0, temp, 0, elementos.length);
			elementos = temp;
		}
	}

	@Override
	public void Adicionar(T elemento) {
		this.Adicionar(tam, elemento);
	}

	public T getElemento(int posicao) {
		if (posicao < tam - 1)
			return elementos[posicao];
		return null;
	}

	@Override
	public void Adicionar(int posicao, T elemento) {
		if (posicao <= tam - 1) {
			AumentarTamanho();
			if (elementos[posicao] != null) {
				for (int i = tam - 1; i >= posicao; i--) {
					elementos[i + 1] = elementos[i];
				}
			}
		}
		elementos[posicao] = elemento;
		tam++;
	}

	@Override
	public void AdicionarInicio(T elemento) {
		this.Adicionar(0, elemento);
	}

	@Override
	public void Remover(int posicao) {
		if (tam == 0) {
			throw new IndexOutOfBoundsException("O vetor ja esta vazio");
		}
		if (posicao > tam - 1) {
			throw new IndexOutOfBoundsException("Posicao nao existe");
		}
		for (int i = posicao; i < tam - 1; i++) {
			elementos[i] = elementos[i + 1];
		}
		elementos[tam - 1] = null;
		tam--;
	}

	@Override
	public void Remover(T elemento) {
		Remover(indexOf(elemento));
	}

	@Override
	public void RemoverInicio() {
		this.Remover(0);
	}

	@Override
	public void RemoverFim() {
		if (tam == 0) {
			return;
		}
		this.elementos[this.tam - 1] = null;
		this.tam--;

	}

	@Override
	public int Tamanho() {
		return tam;
	}

	@Override
	public void Limpar() {
		for (int i = 0; i < tam; i++) {
			elementos[i] = null;
		}
	}

	@Override
	public boolean contem(T elemento) {
		for (int i = 0; i < tam; i++) {
			if (elementos[i].equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@Override
	public int indexOf(T elemento) {
		for (int i = 0; i < tam; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T elemento) {
		int posicao = -1;
		for (int i = 0; i < tam; i++) {
			if (elementos[i].equals(elemento))
				posicao = i;
		}
		return posicao;
	}

	public String toString() {
		if (this.tam == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < this.tam - 1; i++) {
			builder.append(this.elementos[i]);
			builder.append(", ");
		}

		builder.append(this.elementos[this.tam - 1]);
		builder.append("]");

		return builder.toString();
	}

	public T[] SortBuble() {
		// T[] ordenado = ((T[]) new Object[tam]);
		for (int i = 0; i < this.tam - 1; i++) {
			for (int j = i; j <= this.tam - 1; j++) {
				if ((elementos[i].compareTo(elementos[j]) > 0)) {
					T temp = elementos[i];
					elementos[i] = elementos[j];
					elementos[j] = temp;
				}
			}
		}
		return elementos;
	}

	public void insertionSort() {
		int i, j;
		T aux;
		for (i = 1; i < this.tam; i++) {
			aux = elementos[i];
			// int valor = (Integer) aux;
			j = i;
			while (j > 0 && elementos[j - 1].compareTo(aux) > 0) {
				elementos[j] = elementos[j - 1];
				j--;
			}
			elementos[j] = aux;
		}
	}

	public T[] SortSelection() {
		T aux;
		int min;
		for (int i = 0; i < this.tam; i++) {
			min = i;
			for (int j = i + 1; j < this.tam; j++) {
				if (elementos[j].compareTo(elementos[min]) < 0)
					min = j;
			}
			aux = this.elementos[min];
			elementos[min] = elementos[i];
			elementos[i] = aux;
		}
		return elementos;
	}

	// BUSCA BINARIA
	public int BuscaBinaria(int valor) {
		T aux;

		int min;
		for (int i = 0; i < this.tam; i++) {
			min = i;
			for (int j = i + 1; j < this.tam; j++) {
				if (elementos[j].compareTo(elementos[min]) < 0)
					min = j;
			}
			aux = this.elementos[min];
			elementos[min] = elementos[i];
			elementos[i] = aux;
		}
		// Comecando a busca depois de ordenar o vetor
		int esq = 0;
		int dir = elementos.length - 1;
		int valorMeio;

		while (esq <= dir) {
			valorMeio = esq + ((dir - esq) / 2);
			if ((Integer) elementos[valorMeio] < valor) {
				esq = valorMeio + 1;
			} else if ((Integer) elementos[valorMeio] > valor) {
				dir = valorMeio - 1;
			} else {
				return valorMeio;
			}
		}
		return -1;

	}

}