package holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Iterator;

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

/**
 * Created by searover on 3/27/16.
 */
public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
