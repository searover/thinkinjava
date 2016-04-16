package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by searover on 4/16/16.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read(
                        "/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/BufferedInputFile.java"
                )
        );
        int c;
        while ((c = in.read()) != -1){
//            System.out.print(c);
            System.out.print((char)c);
        }
    }
}
