package br.ed.sortSelection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sort<T extends Comparable<T>> implements IVetor<T> {

	private final int tamVetor = 10;
	private T[] listElementos;
	private int total;
	private int size = 0;

	public Sort(Class<T> classe) {
		listElementos = (T[]) Array.newInstance(classe, tamVetor);
	}

	@Override
	public void Adicionar(T elemento) {
		listElementos[total] = elemento;
		total++;
	}

	public T[] Ordenar() {
		T[] lista = listElementos;
		int min;
		for (int i = 0; i < lista.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[j] != null && ((lista[j]).compareTo(lista[min])) < 0) {
					min = j;
				}
			}
			T temp = listElementos[i];
			listElementos[i] = listElementos[min];
			listElementos[min] = temp;
		}
		return listElementos;
	}

	@Override
	public void Adicionar(int posicao, T elemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AdicionarInicio(T elemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Remover(int posicao) {
		if (listElementos[posicao] != null && posicao < tamVetor) {
			listElementos[posicao] = null;
		}
	}

	@Override
	public void Remover(T elemento) {
		int posicao = buscarElemento(elemento);
		Remover(posicao);
	}

	@Override
	public void RemoverInicio() {
		Remover(0);

	}

	@Override
	public void RemoverFim() {
		Remover(tamVetor);

	}

	@Override
	public int Tamanho() {
		return total;
	}

	@Override
	public void Limpar() {
		for (int i = 0; i < listElementos.length; i++) {
			listElementos[i] = null;
		}

	}

	@Override
	public boolean contem(T elemento) {
		boolean achou = false;
		for (int i = 0; i < listElementos.length; i++) {
			if (listElementos[i] == elemento) {
				achou = true;
			}
		}
		return achou;
	}

	@Override
	public Iterator<T> iterator() {
		return ArrayIterator;
	}

	private Iterator<T> ArrayIterator = new Iterator<T>() {

		@Override
		public boolean hasNext() {
			if (size < total)
				return true;
			return false;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException("Não há proximo elementos");
			return listElementos[size++];

		}

		@Override
		public void remove() {
			listElementos[size--] = null;
		}
	};

	@Override
	public int indexOf(T elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int buscarElemento(T elemento) {
		int posicao = -1;
		for (int i = 0; i < listElementos.length; i++) {
			if (listElementos[i] == elemento) {
				return posicao;
			}
			posicao++;
		}
		return posicao;
	}
	public String toString() {
		StringBuilder element = new StringBuilder("[");
		int j = 0;
		for (int i = 0; i < listElementos.length; i++) {
			if (listElementos[i] != null)
				element.append(listElementos[i]);
			if (listElementos[++j] != null)
				element.append(", ");
			else
				break;
		}
		element.append("]");
		return element.toString();
	}
	
}
