package typeinfo.pets;

import java.util.ArrayList;

/**
 * Created by searover on 3/15/16.
 */
public class Pets {
    public static final PetCreator CREATOR = new LiteralPetCreator();

    public static Pet randomPet(){
        return CREATOR.randomPet();
    }

    public static Pet[] createArray(int size){
        return CREATOR.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size){
        return CREATOR.arrayList(size);
    }
}
