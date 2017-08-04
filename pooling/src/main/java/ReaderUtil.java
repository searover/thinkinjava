import java.io.IOException;
import java.io.Reader;

/**
 * Created by searover on 8/18/16.
 */
public class ReaderUtil {
    public ReaderUtil() {
    }

    /**
     * Dumps the contents of the {@link java.io.Reader} to a String, closing the {@link java.io.Reader} when done.
     */
    public String readToString(Reader in) throws IOException {
        StringBuffer buf = new StringBuffer();
        try {
            for (int c = in.read(); c != -1; c = in.read()) {
                buf.append((char) c);
            }
            return buf.toString();
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
}
