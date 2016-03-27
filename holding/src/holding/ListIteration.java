package holding;

import typeinfo.pets.*;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by searover on 3/15/16.
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()){
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ";");
            System.out.println(it.hasNext());
        }
        System.out.println();
        // Backwards:
        while (it.hasPrevious()){
            System.out.println(it.previous().id());
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()){
            Pet p = it.next();
            System.out.println(p);
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}
