package prototype;

/**
 * Created by searover on 4/16/16.
 */
public class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // delegate to
        component.sampleOperation();
    }
}
