package listSimples;

public class ListSimpEnc<T> implements IListaSimpEnc<T>{

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
		if (inicio == null)
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
			NoSimpEnc<T> anterior = new NoSimpEnc<>();
			for (int i = 0; i < tam; i++) {
				if (aux.getProximo().equals(fim))
					;
				anterior.setProximo(fim);
			}
			aux = aux.getProximo();
		}
	}
	
	public String toString() {
		String resultado = "( ";
		NoSimpEnc<T> aux = inicio;
		for (int i = 0; i < tam; i++) {

			resultado += aux.getElemento() + ", ";
			aux = aux.getProximo();
		}
		return resultado + " )";
	}

}
