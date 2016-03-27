package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by searover on 3/27/16.
 */
public class CollectionSequece extends AbstractCollection<Pet>{
    private Pet[] pets = Pets.createArray(8);
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index ++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequece c = new CollectionSequece();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
