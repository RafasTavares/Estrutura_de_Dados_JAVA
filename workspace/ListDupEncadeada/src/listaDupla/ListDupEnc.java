package listaDupla;

import java.util.Iterator;

public class ListDupEnc<T> implements IListDupEnc<T> {

	private NoDupEnc<T> noCabeca;
	private int tamLista;

	private Iterator<T> iterator = new Iterator<T>() {
		private NoDupEnc<T> noAux;

		@Override
		public boolean hasNext() {
			if (noAux == null) {
				noAux = noCabeca.getAnterior();
			}

			return !(noAux == noCabeca);
		}

		@Override
		public T next() {
			if (noAux == null)
				noAux = noCabeca.getAnterior();
			
			NoDupEnc<T> noTemp;
			noTemp = noAux;
			noAux = noAux.getAnterior();
			return noTemp.getElemento();

		}

		@Override
		public void remove() {
		}
	};

	public ListDupEnc() {
		noCabeca = new NoDupEnc<T>();
	}

	@Override
	public NoDupEnc<T> getInicio() {
		return noCabeca.getProximo();
	}

	@Override
	public NoDupEnc<T> getFim() {
		return noCabeca.getAnterior();
	}

	@Override
	public void clear() {
		noCabeca.setAnterior(null);
		noCabeca.setProximo(null);
		tamLista = 0;
	}

	@Override
	public int size() {
		return tamLista;
	}

	@Override
	public boolean estaVazia() {
		return tamLista == 0;
	}

	@Override
	public void InserirInicio(T elemento) {
		NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);
		if (noCabeca.getProximo() == null) {
			noCabeca.setProximo(novoNo);
			noCabeca.setAnterior(novoNo);
			novoNo.setAnterior(noCabeca);
			novoNo.setProximo(noCabeca);
		} else {
			noCabeca.getProximo().setAnterior(novoNo);
			novoNo.setProximo(noCabeca.getProximo());
			noCabeca.setProximo(novoNo);
			novoNo.setAnterior(noCabeca);
		}
		tamLista++;
	}

	@Override
	public void InserirFim(T elemento) {
		NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);
		if (noCabeca.getProximo() == null) {
			noCabeca.setProximo(novoNo);
			noCabeca.setAnterior(novoNo);
			novoNo.setAnterior(noCabeca);
			novoNo.setProximo(noCabeca);
		} else {
			noCabeca.getAnterior().setProximo(novoNo);
			novoNo.setAnterior(noCabeca.getAnterior());
			novoNo.setProximo(noCabeca);
			noCabeca.setAnterior(novoNo);
		}
		tamLista++;
	}

	@Override
	public void Inserir(int pos, T elemento) {
		if (pos > tamLista)
			throw new IndexOutOfBoundsException("Posi��o Inv�lida");
		int cont = 0;

		for (NoDupEnc<T> item = noCabeca.getProximo(); item != noCabeca; item = item
				.getProximo()) {
			if (cont == pos) {
				NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento, item,
						item.getAnterior());
				item.getAnterior().setProximo(novoNo);
				item.setAnterior(novoNo);
				tamLista++;
				break;
			}
			cont++;
		}
	}

	@Override
	public boolean contem(T elemento) {
		for (NoDupEnc<T> item = noCabeca.getProximo(); item != noCabeca; item = item
				.getProximo()) {
			if (item.getElemento().equals(elemento))
				return true;
		}
		return false;
	}

	@Override
	public void RemoverInicio() {
		this.noCabeca.getProximo().setAnterior(null);
		this.noCabeca.setProximo(noCabeca.getProximo().getProximo());
		this.noCabeca.getProximo().getAnterior().setProximo(null);
		this.noCabeca.getProximo().setAnterior(noCabeca);

		tamLista--;
	}

	@Override
	public void RemoverFim() {
		this.noCabeca.getAnterior().setProximo(null);
		this.noCabeca.setAnterior(noCabeca.getAnterior().getAnterior());
		this.noCabeca.getAnterior().getProximo().setAnterior(null);
		this.noCabeca.getAnterior().setProximo(noCabeca);

		tamLista--;
	}

	public Iterator<T> descendingIterator() {
		return this.iterator;
	}

	public String toString() {
		if (this.tamLista == 0) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (NoDupEnc<T> item = noCabeca.getProximo(); item != noCabeca
				.getAnterior(); item = item.getProximo()) {
			sb.append(item.getElemento());
			sb.append(", ");
		}

		sb.append(noCabeca.getAnterior().getElemento());
		sb.append("]");
		return sb.toString();
	}
}
