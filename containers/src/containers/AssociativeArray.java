package containers;

import java.util.HashMap;

/**
 * Created by searover on 4/3/16.
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key){
        for (int i = 0; i < index; i++){
            if(key.equals(pairs[i][0])){
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
