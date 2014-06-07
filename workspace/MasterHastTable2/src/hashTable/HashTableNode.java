package hashTable;

public class HashTableNode <K,V>{
	private K key;
	private V value;
	public HashTableNode(K key,V value)
	{
		this.key = key;
		this.value = value;
	}

	public void setValue(V value)
	{
		this.value = value;
	}

	public K getKey()
	{
		return key;
	}

	public V getValue()
	{
		return value;
	}
}
