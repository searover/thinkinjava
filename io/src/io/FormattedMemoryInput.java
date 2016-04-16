package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by searover on 4/16/16.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        BufferedInputFile.read("/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/FormattedMemoryInput.java").getBytes()
                )
        );

        byte[] bytes = BufferedInputFile.read("/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/FormattedMemoryInput.java").getBytes();
        System.out.println("length: " + bytes.length);
        int i = -1;
        try {
            while (true) {
                i++;
//                System.out.print((char) in.readByte());
                in.readByte();
            }
        }catch (EOFException e){
            System.out.println("End.");
        }
        System.out.println("i = " + i);
    }
}
