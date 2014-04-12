package listSimples;

public class ListSimpEnc<T> implements IListaSimpEnc<T> {

	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private int tam;

	public ListSimpEnc() {
		this.inicio = null;
		this.fim = null;
		// this.tam = 0;
	}

	@Override
	public NoSimpEnc<T> getInicio() {
		return this.inicio;
	}

	@Override
	public NoSimpEnc<T> getFim() {
		return this.fim;
	}

	@Override
	public void clear() {
		tam = 0;
		inicio = fim = null;

	}

	@Override
	public int size() {

		return tam;
	}

	@Override
	public boolean estaVazia() {
		if (tam == 0)
			return true;
		return false;
	}

	@Override
	public void InserirInicio(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);
		if (estaVazia()) {
			inicio = fim = novoNo;
		} else {
			novoNo.setProximo(inicio);
			inicio = novoNo;
		}
		tam++;
	}

	@Override
	public void InserirFim(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);
		if (inicio == null && tam == 0)
			inicio = fim = novoNo;
		else {
			fim.setProximo(novoNo);
			fim = novoNo;
		}
		tam++;
	}

	@Override
	public void Inserir(int pos, T elemento) {

		NoSimpEnc<T> novoEnc = inicio;
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);
		NoSimpEnc<T> anterior = null;
		if (pos > 0 && pos <= tam) {
			for (int i = 0; i < pos; i++) {
				anterior = novoEnc;
				novoEnc = novoEnc.getProximo();
			}
			anterior.setProximo(novoNo);
			novoNo.setProximo(novoEnc);
			tam++;
		}
	}

	public void Remover(int pos) {

		NoSimpEnc<T> atual = inicio;
		NoSimpEnc<T> anterior = null;

		if (pos == 1) {
			RemoverInicio();
		}
		if (pos < tam) {

			for (int i = 0; i < pos; i++) {
				anterior = atual;
				atual = atual.getProximo();
			}
		}
		anterior.setProximo(atual.getProximo());
		atual.setProximo(null);
		tam--;
	}

	@Override
	public boolean contem(T elemento) {
		NoSimpEnc<T> existente = inicio;
		for (int i = 0; i < tam; i++) {
			if (existente.getElemento().equals(elemento)) {
				return true;
			}
			existente = existente.getProximo();
		}
		return false;
	}

	@Override
	public void RemoverInicio() {
		if (tam > 0) {
			inicio = inicio.getProximo();
			tam--;
		}
	}

	@Override
	public void RemoverFim() {
		if (tam == 0) {
			throw new IllegalArgumentException();
		} else {
			NoSimpEnc<T> aux = inicio;
			// NoSimpEnc<T> anterior = new NoSimpEnc<>();
			// for (int i = 0; i < tam; i++)
			while (aux.getProximo() != null) {
				aux = aux.getProximo();
				if (aux.getProximo() == fim) {
					aux.setProximo(null);
				}
			}
		}
		this.tam--;
	}

	public int RetornaPos(T elemento) {
		NoSimpEnc<T> atual = inicio;
		for (int i = 0; i <= tam ; i++) {
			if (atual.getElemento().equals(elemento)) {
				return i;
			}
			atual = atual.getProximo();
		}
		return -1;
	}

	public T RetornaElementoPos(int pos) {
		if (pos == 0 && pos > tam) {
			return null;
		} else {
			NoSimpEnc<T> atual = inicio;
			for (int i = 0; i < pos - 1; i++) {
				atual = atual.getProximo();
			}
			return atual.getElemento();
		}
	}

	public String toString() {
		if (tam == 0)
			return "[]";
		String resultado = "[";
		NoSimpEnc<T> aux = inicio;
		for (int i = 0; i < tam; i++) {

			resultado += aux.getElemento();
			aux = aux.getProximo();
			if (i != tam - 1)
				resultado = resultado + ", ";
		}
		return resultado + "]";
	}

	public void Inserir(T objeto, T elemento) throws IndexOutOfBoundsException{
		NoSimpEnc<T> atual = inicio;
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);
		NoSimpEnc<T> proximo = atual.getProximo();
		if (contem(objeto)) {
			int posicao = RetornaPos(objeto);
			if (posicao == tam) {
				InserirFim((T) novoNo);
			} else {
				for (int i = 0; i < posicao; i++) {
					atual = atual.getProximo();
					// proximo = atual.getProximo();
				}
				novoNo.setProximo(proximo);
				atual.setProximo(novoNo);
			}
			tam++;
		} else {
			 new IndexOutOfBoundsException();
		}
	}

	public void Inserir(int pos, ListSimpEnc<T> lista) {
		NoSimpEnc<T> novoEnc = inicio;
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(lista);
		NoSimpEnc<T> anterior = null;
		if (pos > 0 && pos <= tam) {
			for (int i = 0; i <= pos; i++) {
				anterior = novoEnc;
				novoEnc = novoEnc.getProximo();
			}
			anterior.setProximo(novoNo);
			novoNo.setProximo(novoEnc);
			tam++;
		}

	}

}
