package fila;

import java.lang.reflect.Array;
import java.util.Iterator;

import vetor_2014.Vetor;

public class FilaVetor<T extends Comparable<T>> implements IFila<T> {

	private Vetor<T> vetor;
	private Class classe;

	public FilaVetor(Class<T> classe) {
		vetor = new Vetor<T>(classe);
		this.classe = classe;
	}

	@Override
	public void Enfileirar(T objeto) {
		vetor.Adicionar(objeto);
	}

	@Override
	public T Remover() throws FilaVaziaException {
		T temp = null;
		temp =  vetor.getElemento(0);
		vetor.RemoverInicio();
		return temp;
	}

	@Override
	public T getInicio() {
		if (vetor.Tamanho() != 0)
			return vetor.getElemento(0);

		return null;
	}

	@Override
	public T getFim() {
		if (vetor.Tamanho() != 0)
			return vetor.getElemento(vetor.Tamanho() - 1);

		return null;
	}

	@Override
	public void limpar() {
		vetor.Limpar();
	}

	@Override
	public boolean contem(T objeto) {
		return vetor.contem(objeto);
	}

	@Override
	public String toString() {
		return vetor.toString();
	}

	@Override
	public T[] toArray() {
		T[] temp = (T[]) Array.newInstance(classe, vetor.Tamanho());
		for (int i = 0; i < vetor.Tamanho() - 1; i++) {
			temp[i] = vetor.getElemento(i);
		}

		return temp;
	}

	@Override
	public Iterator<T> iterator() {
		return vetor.iterator();
	}
}
