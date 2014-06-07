package hashTable;
import java.util.*;
public class PseudoRandomProbing<K,V> implements HashTable<K, V> {
	private HashTableNode<K,V>[] prob ;
	private int[] perm ;
	private boolean[] tombstone ;
	private int slotNumber , slotnumberfunction ;
	private int elemenetsNumber ;
	private final int initial_size = 10;
	private final double maxLoadFactor = 0.75;
	private final int increment_factor = 2;
	private int collisions ;


	public PseudoRandomProbing()
	{
		@SuppressWarnings("unchecked")
		HashTableNode<K,V>[] lists = (HashTableNode<K, V>[])new HashTableNode[slotNumber = initial_size ];
		prob = lists;
		tombstone = new boolean[initial_size];
		perm = new int[initial_size];
		generate_random_permutation(perm);
		elemenetsNumber = 0;
		slotnumberfunction = initial_size ;
		collisions = 0;
	}

	private void generate_random_permutation(int[] perm)
	{
		Random r = new Random();
		
		boolean[] checkperm = new boolean[perm.length];

		perm[0] = 0;
		int n , length = perm.length ; 
		for (int i=1;i<length;i++) {
			n = Math.abs(r.nextInt()%length);
			if(n!=0&!checkperm[n])
			{
				perm[i] = n;
				checkperm[n] = true;
			} else {
				i--;
			}
		}	
	}

	private boolean maxLoadFactorExceeded()
	{
		if((double)elemenetsNumber/(double)slotNumber<maxLoadFactor)
			return false;
		return true;
	}

	private void rehashing(HashTableNode<K,V>[] hashtable,int[] permutation)
	{
		Iterator<K> itr = keys().iterator();
		K key ;
		while(itr.hasNext())
		{
			key = itr.next();
			int position = rehashFunction(key);
			if(hashtable[position]==null)
			{
				hashtable[position] = new HashTableNode<K,V>(key,get(key));
			} else {
				int v ;
				for (int i=1;i<slotnumberfunction;i++) {
					v = ( permutation[i] + position ) % slotnumberfunction ;
					if(hashtable[v]==null)
					{
						hashtable[v] = new HashTableNode<K,V>(key,get(key));
						break;
					}
					++collisions;
				}
			}
		}	
	}

	@Override
	public void put(K key, V value) {
		if(maxLoadFactorExceeded())
		{
			//rehashing
			int newSize = slotNumber*increment_factor ;
			@SuppressWarnings("unchecked")
			HashTableNode<K,V>[] newlist = (HashTableNode<K, V>[])new HashTableNode[newSize];
			int[] newperm = new int[newSize];
			generate_random_permutation(newperm);
			slotnumberfunction = newSize ;
			rehashing(newlist,newperm);

			slotNumber = newSize;
			prob = newlist ;
			perm = newperm ;
			tombstone = new boolean[newSize];
			put(key,value);
		}
		else {
			int v , position = hashFunction(key);
			if(contains(key))
			{
				if(prob[position]!=null)
					if(prob[position].getKey().hashCode()==key.hashCode())
					{
						prob[position].setValue(value);
						return ;
					}
				++collisions;
				for (int i=1;i<slotNumber;i++) {
					v = ( perm[i] + position ) % slotNumber ;
					if(prob!=null)
						if(prob[v].getKey().hashCode()==key.hashCode())
						{
							prob[v].setValue(value);
							return ;
						}
					++collisions;
				}
			} else {
				if(prob[position]==null)
				{
					prob[position] = new HashTableNode<K,V>(key,value);
					tombstone[position] = false;
					++elemenetsNumber;
					return ;
				}
				for(int i=1;i<slotNumber;i++)
				{
					v = ( perm[i] + position ) % slotNumber ;
					if(prob[v]==null)
					{
						prob[v] = new HashTableNode<K,V>(key,value);
						tombstone[v] = false;
						++elemenetsNumber;
						return ;	
					}
					++collisions;
				}
			}
		}
	}

	@Override
	public V get(K key) {
		if(!contains(key)) return null;

		int v , position = hashFunction(key);
		
		if(prob[position]!=null)
		{
			if(prob[position].getKey().hashCode()==key.hashCode())
			{
				return prob[position].getValue();
			}

		} else {
			for(int i=0;i<slotNumber;i++)
			{
				v = ( position + perm[i] ) % slotNumber ;
				if(prob[v]!=null)
					if(prob[v].getKey().hashCode()==key.hashCode())
					{
						return prob[v].getValue();
					}
			}
		}



		return null;
	}

	@Override
	public void delete(K key) {
		if(!contains(key)) return ;
		
		int v , position = hashFunction(key);
		
		if(prob[position]!=null)
		{
			if(prob[position].getKey().hashCode()==key.hashCode())
			{
				prob[position] = null;
				tombstone[position] = true;
				--elemenetsNumber;
				return ;
			}
		} else {
			for(int i=0;i<slotNumber;i++)
			{
				v = ( position + perm[i] ) % slotNumber ;
				if(prob[v]!=null)
					if(prob[v].getKey().hashCode()==key.hashCode())
					{
						prob[v] = null;
						tombstone[v] = true;
						--elemenetsNumber;
						return ;
					}
			}
		}
	}

	@Override
	public boolean contains(K key) {
		int position , value = hashFunction(key);
		
		if(prob[value]!=null)
			if(prob[value].getKey().hashCode()==key.hashCode())
				return true;
		else if(prob[value]==null&!tombstone[value])
			return false;

		int length = slotNumber;

		for (int i=1;i<length;i++) {
			position = (value + perm[i]) % length ;
			if(prob[position]==null)
			{
				if(!tombstone[position])
					return false;
			}
			else {
				if(prob[position].getKey().hashCode()==key.hashCode())
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return elemenetsNumber==0?true:false;
	}

	@Override
	public int size() {
		return elemenetsNumber;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> allKeys = new LinkedList<K>();

		for(int i=0;i<slotNumber;i++)
		{
			if(prob[i]!=null)
				allKeys.add(prob[i].getKey());
		}

		return allKeys;
	}

	private int hashFunction(K key) {
		return key.hashCode()%slotNumber;
	}
	
	private int rehashFunction(K key) {
		return key.hashCode()%slotnumberfunction;
	}

	@Override
	public int collisonsNumber() {
		return collisions;
	}

	@Override
	public int getMemoryInfo() {
		return slotNumber;
	}

}
