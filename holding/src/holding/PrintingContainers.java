package holding;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * Created by searover on 3/12/16.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args) {
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new TreeSet<String>()));
        print(fill(new LinkedHashSet<String>()));
        print(fill(new HashMap<String, String>()));
        print(fill(new TreeMap<String, String>()));
        print(fill(new LinkedHashMap<String, String>()));
        HashMap map = (HashMap) fill(new HashMap<String, String>());
        System.out.println("==");
        System.out.println(map.toString());
    }
}
