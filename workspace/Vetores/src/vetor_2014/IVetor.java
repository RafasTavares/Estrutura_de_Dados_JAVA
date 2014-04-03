package vetor_2014;

public interface IVetor<T> {
	
	public void Adicionar(T elemento);
	
	public void Adicionar(int posicao, T elemento) throws ArrayIndexOutOfBoundsException;
	
	public void AdicionarInicio(T elemento);
	
	public void Remover(int posicao) throws ArrayIndexOutOfBoundsException;
	
	public void Remover(T elemento);
	
	public void RemoverInicio();
	
	public void RemoverFim();
	
	public int Tamanho();
	
	public void Limpar();
	
	public boolean contem(T elemento);
}