package hash;


public class HashTable<K,V> 
{
	private final int INITIAL_TABLE_SIZE = 128;
	private HashNode[] hashTable;
	private int tableSize = INITIAL_TABLE_SIZE;
	private int size = 0;
	private static int numCollisions = 0;
	private static int numResizes = 0;
	
	public HashTable()
	{
		hashTable = new HashNode[INITIAL_TABLE_SIZE];
	}
	
	private int hashFunction(K key)
	{
		int hash = Math.abs(key.hashCode());
		return hash % tableSize;
	}
	
	public float loadFactor()
	{
		return size/(float)tableSize;
	}
	
	public void put(K key, V value)
	{
		int hash = hashFunction(key);
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		
		//check if load factor is about 0.4
		if(loadFactor() > 0.40f)
		{
			numResizes++;
			//double the size of the table
			HashNode[] oldHashTable = this.hashTable;
			this.hashTable = new HashNode[tableSize*2];
			tableSize = tableSize*2;
			
			//remap values to new table
			for(int i=0; i<oldHashTable.length; i++)
			{
				HashNode<K,V> node = oldHashTable[i];
				while(node != null)
				{
					put(node.getKey(), node.getValue());
					node = node.getNext();
				}
			}
		}
		
		
		if(hashTable[hash] != null)
		{
			System.out.println("COLLISION!!!");
			numCollisions++;
			//append to linked list
			hashTable[hash].setNext(newNode);
		}
		else
		{
			hashTable[hash] = newNode;
		}
		size++;
	}
	
	public V get(K key)
	{
		int hash = hashFunction(key);
		HashNode<K,V> hashNode = hashTable[hash];
		while(hashNode != null)
		{
			if(hashNode.getKey().equals(key))
				break;
			else
				hashNode = hashNode.getNext();
		}
		
		if(hashNode == null)
			return null;
		else
			return hashNode.getValue();
	}
	
	public void delete(K key)
	{
		int hash = hashFunction(key);
		hashTable[hash] = null;
	}

	public int getSize() 
	{
		return size;
	}
	
	public int getNumCollisions()
	{
		return numCollisions;
	}
	
	public int getNumResizes()
	{
		return numResizes;
	}
}
