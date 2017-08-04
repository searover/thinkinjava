import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by searover on 8/18/16.
 */
public class ThreadScope implements Scope{

    private final ThreadLocal threadLocal = new ThreadLocal();

    protected Object initialValue(){
        return new HashMap();
    }

    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map scope = (Map) threadLocal.get();
        Object object = scope.get(name);
        if(object == null){
            object = objectFactory.getObject();
            scope.put(name,object);
        }
        return object;
    }

    public Object remove(String name) {
        Map scope = (Map) threadLocal.get();
        return scope.remove(name);
    }

    public void registerDestructionCallback(String name, Runnable callback) {

    }

    public Object resolveContextualObject(String key) {
        return null;
    }

    public String getConversationId() {
        return null;
    }
}
