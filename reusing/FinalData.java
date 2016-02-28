// : reusing/FinalData.java
// The effect of final on fields.
import java.util.*;
import static net.mindview.util.Print.*;

class Value {
    int i; // Package access
    public Value(int i){
        this.i = i;
    }

    public class FinalData {
        private static Random rand = new Random(47);
        private String id;
        public FinalData(String id){
            this.id = id;
        }
        // Can be compile-time constants:
        private final int valueOne = 9;
        private static final int VALUE_TWO = 99;
        // Typical public constant:
        private  final int i4 = rand.nextInt(20);
        static final int INT_5 = rand.nextInt(20);




