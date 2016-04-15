package generics;

import net.mindview.util.Generator;

import java.util.*;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    // A method to produce Generator objects:
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller{
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){
    }

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}

/**
 * Created by searover on 4/2/16.
 */
public class BankTeller {
    public static void serve(Teller t, Customer c){
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line,Customer.generator(),10);
        List tellers = new ArrayList<>();
        Generators.fill(tellers,Teller.generator,4);
        for (Customer c : line){
            System.out.println(tellers.get(rand.nextInt(tellers.size())) + " serves " + c);
        }
    }
}
