package generics;

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by searover on 4/1/16.
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople){}

    public static void main(String[] args){
        f(New.map());
        f(New.<Person,List<? extends Pet>>map());
    }
}
