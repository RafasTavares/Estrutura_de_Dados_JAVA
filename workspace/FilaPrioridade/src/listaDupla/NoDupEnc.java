package listaDupla;

public class NoDupEnc<T> {
	private T elemento;
	private NoDupEnc<T> proximo;
	private NoDupEnc<T> anterior;

	public NoDupEnc()
	{
	}
	
	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NoDupEnc<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoDupEnc<T> proximo) {
		this.proximo = proximo;
	}

	public NoDupEnc<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDupEnc<T> anterior) {
		this.anterior = anterior;
	}

	public NoDupEnc(T elemento)
	{
		this.elemento = elemento;
		this.proximo = null;
		this.anterior = null;
	}
	
	public NoDupEnc(T elemento, NoDupEnc<T> prox, NoDupEnc<T> anterior)
	{
		this.elemento = elemento;
		this.proximo = prox;
		this.anterior = anterior;
	}
	
}
