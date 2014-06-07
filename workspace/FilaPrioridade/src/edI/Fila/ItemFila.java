package edI.Fila;

public class ItemFila<T> {
	private T elemento;
	private int prioridade;
	
	public ItemFila(T elemento, int prioridade)
	{
		this.elemento = elemento;
		this.prioridade = prioridade;
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public T getElemento() {
		return elemento;
	}
}
