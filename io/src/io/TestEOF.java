package io;

import java.io.*;

/**
 * Created by searover on 4/16/16.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/TestEOF.java")
                )
        );
        while (in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }
}
