package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by searover on 3/26/16.
 */
public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(new TextFile("holding/src/holding/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
