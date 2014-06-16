package fila;

import java.util.Iterator;

import listSimples.ListSimpEnc;
import listSimples.NoSimpEnc;

public class FilaEnc<T> implements IFila<T> {
	ListSimpEnc<T> listaElementos;

	public class MyIterator implements Iterator<T> {
		NoSimpEnc<T> noAux = listaElementos.getInicio();

		@Override
		public boolean hasNext() {
			return listaElementos.size() == 0 ? false : noAux.getProximo() != null;
		}

		@Override
		public T next() {
			T temp = null;
			if (hasNext()) {
				temp = noAux.getElemento();
				noAux = noAux.getProximo();
			}

			return temp;
		}

		@Override
		public void remove() {

		}
	}

	public FilaEnc() {
		listaElementos = new ListSimpEnc<T>();
	}

	@Override
	public void Enfileirar(T objeto) {
		listaElementos.InserirFim(objeto);
	}

	@Override
	public T Remover() throws FilaVaziaException {
		T temp = null;
		try {
			temp = listaElementos.getInicio().getElemento();
			listaElementos.RemoverInicio();
		} catch (Exception ex) {
			throw new FilaVaziaException("Fila vazia");
		}
		return temp;
	}

	@Override
	public T getInicio() {
		return listaElementos.getInicio().getElemento();
	}

	@Override
	public T getFim() {
		return listaElementos.getFim().getElemento();
	}

	@Override
	public void limpar() {
		listaElementos.clear();
	}

	@Override
	public boolean contem(T objeto) {
		return listaElementos.contem(objeto);
	}

	@Override
	public String toString() {
		return listaElementos.toString();
	}

	@Override
	public T[] toArray() {
		NoSimpEnc<T> noAux = listaElementos.getInicio();
		T[] array = ((T[]) new Object[listaElementos.size()]);
		for (int i = 0; i < listaElementos.size(); i++) {
			array[i] = noAux.getElemento();
			noAux = noAux.getProximo();
		}
		return array;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	public int PosicaoFila(T elemento){
		return listaElementos.RetornaPos(elemento);
		
	}
}
