package generics;

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

/**
 * Created by searover on 4/2/16.
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("succeed.");
        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        System.out.println("succeed.");
    }
}
