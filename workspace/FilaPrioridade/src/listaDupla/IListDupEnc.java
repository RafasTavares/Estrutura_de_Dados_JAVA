package listaDupla;

import java.util.Iterator;

public interface IListDupEnc<T> {
	// Retorna a referencia do n� que encontra-se no inicio da lista
	public NoDupEnc<T> getInicio();

	// Retorna a referencia do n� que encontra-se no fim da lista
	public NoDupEnc<T> getFim();

	// Limpa toda a lista
	public void clear();

	// tamanho de elementos que a lista possui
	public int size();

	// Retorna se a lista est� ou n�o vazia
	public boolean estaVazia();

	// Inserir um elemento no in�cio da lista
	public void InserirInicio(T elemento);

	// Inserir um elemento no fim da lista
	public void InserirFim(T elemento);

	// Inserir um elemento na posi��o indicada pelo par�metro pos
	public void Inserir(int pos, T elemento);

	// Indica se a lista possui o elemento
	public boolean contem(T elemento);

	// Remove o primeiro elemento da lista
	public void RemoverInicio();

	// Remove o �ltimo elemento da lista
	public void RemoverFim();
	
	// Método toString
	public String toString();
	
	//Remove todos os elemento da lista
	public void RemoverTodos (T elemento);
}
