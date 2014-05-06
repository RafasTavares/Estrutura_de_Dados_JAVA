package pilhaEnc;


public interface IListaSimpEnc<T> {
	// Retorna a referencia do n� que encontra-se no inicio da lista
	public NoSimpEnc<T> getInicio();

	// Retorna a referencia do n� que encontra-se no fim da lista
	public NoSimpEnc<T> getFim();

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
	
	//Transforma uma lista encadeada em uma String como o exemplo
	//[3, 4, 6]
	public String toString();
	
	//Inverter a Lista
	public void inverterLista();
	
	public boolean CompararLista(ListSimpEnc lista);
	
}
