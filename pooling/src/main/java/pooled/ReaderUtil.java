package pooled;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by searover on 8/18/16.
 */
public class ReaderUtil {
    private ObjectPool<StringBuffer> pool;

    public ReaderUtil(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    /**
     * Dumps the contents of the {@link java.io.Reader} to a String, closing the {@link java.io.Reader} when done.
     */
    public String readToString(Reader in) throws IOException {
        StringBuffer buf = null;
        try {
            buf = pool.borrowObject();
            for (int c = in.read(); c != -1; c = in.read()) {
                buf.append((char) c);
            }
            return buf.toString();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to borrow buffer from poll " + e.toString());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
            try {
                if (buf != null) {
                    pool.returnObject(buf);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ReaderUtil readerUtil = new ReaderUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
        String message = "Hello pooling.";
        Reader reader = new StringReader(message);
        System.out.println(readerUtil.readToString(reader));
    }
}
