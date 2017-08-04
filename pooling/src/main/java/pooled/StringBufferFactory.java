package pooled;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * Created by searover on 8/18/16.
 */
public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {
    @Override
    public StringBuffer create() throws Exception {
        return new StringBuffer();
    }

    /**
     * Use the default PooledObject implementation.
     *
     * @param stringBuffer
     * @return
     */
    @Override
    public PooledObject<StringBuffer> wrap(StringBuffer stringBuffer) {
        return new DefaultPooledObject<StringBuffer>(stringBuffer);
    }

    /**
     * When an object is returned to the pool, clear the buffer.
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject<StringBuffer> pooledObject) throws Exception {
        pooledObject.getObject().setLength(0);
    }
}
