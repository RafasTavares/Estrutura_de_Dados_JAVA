package listaDupla;

public class ListDupEnc<T> implements IListDupEnc<T> {

	NoDupEnc<T> noCabeca;
	int tam;

	public ListDupEnc() {
		noCabeca = new NoDupEnc<>();
		tam = 0;
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
		tam = 0;
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
		NoDupEnc<T> novoNo = new NoDupEnc<>(elemento);
		if (noCabeca.getProximo() == null) {
			noCabeca.setProximo(novoNo);
			novoNo.setProximo(noCabeca);
			noCabeca.setAnterior(novoNo);
			novoNo.setAnterior(noCabeca);
		} else {
			novoNo.setAnterior(noCabeca);
			novoNo.setProximo(noCabeca.getProximo());
			noCabeca.getProximo().setAnterior(novoNo);
			noCabeca.setProximo(novoNo);
		}
		tam++;
	}

	@Override
	public void InserirFim(T elemento) {
		NoDupEnc<T> novoNo = new NoDupEnc<>();
		if (noCabeca.getProximo() == null) {
			noCabeca.setAnterior(novoNo);
			noCabeca.setProximo(novoNo);
			novoNo.setAnterior(noCabeca);
			novoNo.setProximo(noCabeca);
		} else {
			novoNo.setAnterior(noCabeca.getAnterior());
			noCabeca.getAnterior().setProximo(novoNo);
			novoNo.setProximo(noCabeca);
			noCabeca.setAnterior(novoNo);
		}
		tam++;
	}

	@Override
	public void Inserir(int pos, T elemento) {
		NoDupEnc<T> atual = null;
		NoDupEnc<T> novoNo = new NoDupEnc<>(elemento);

		if (pos == 0) {
			InserirInicio(elemento);
		} else if (pos == this.tam) {
			InserirFim(elemento);
		} else {
			if (pos <= tam) {
				for (int i = 0; i < pos; i++) {
					atual = atual.getProximo();
				}
				novoNo.setAnterior(atual.getAnterior());
				novoNo.setProximo(atual);
				atual.getAnterior().setProximo(novoNo);
				atual.setAnterior(novoNo);
			}
		}
		tam++;
	}

	@Override
	public boolean contem(T elemento) {
		NoDupEnc<T> atual = noCabeca;
		for (int i = 0; i < tam; i++) {
			atual = atual.getProximo();
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void RemoverInicio() {

		if (noCabeca.getProximo() != null) {
			noCabeca.getProximo().getProximo().setAnterior(noCabeca);
			noCabeca.setProximo(noCabeca.getProximo().getProximo());
		} else if (tam == 1) {
			noCabeca.setAnterior(null);
			noCabeca.setProximo(null);
		}
		tam--;
	}

	@Override
	public void RemoverFim() {

		if (noCabeca.getAnterior() != null) {

			noCabeca.getAnterior().getAnterior().setProximo(noCabeca);
			noCabeca.setAnterior(noCabeca.getAnterior().getAnterior());

		} else if (tam == 1) {
			noCabeca.setAnterior(null);
			noCabeca.setProximo(null);
		}
		tam--;
	}
	//TO STRING
	public String toString() {
		String resultado = "( ";
		NoDupEnc<T> aux = noCabeca;
		for (int i = 0; i < tam; i++) {
			aux = aux.getProximo();
			resultado += aux.getElemento() + ", ";
		}
		return resultado + " )";
	}

}
