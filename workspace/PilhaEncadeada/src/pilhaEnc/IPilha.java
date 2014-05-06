package pilhaEnc;

public interface IPilha<T> {
	public void empilhe(T objeto);
	public T desempilhe() throws PilhaVaziaException;
	public T getTopo() throws PilhaVaziaException;
	//Implementar um toString que ir� pegar o primeiro
	//elemento da pilha at� o �ltimo
	//A impress�o dever� ser da seguinte maneira
	//Ex: [5,3,2]
	public String toString();
	//Tamanho da pilha
	public int size();
	public boolean estaVazia();
	public boolean contem(T objeto);
}
