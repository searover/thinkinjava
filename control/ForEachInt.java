import static net.mindview.util.Range.*;
import static net.mindview.util.Print.*;

public class ForEachInt {
    
    public static void main(String[] args){
        for(int i : range(10)) // 0..9
            printnb(i + " ");
        print();
        for(int i : range(5, 10)) // 5..9
            printnb(i + " ");
        print();
        for(int i : range(1, 10, 2)) // 5..20 step 3
            printnb(i + " ");
        print();
    }
}
