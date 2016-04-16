package io;

import java.io.*;

/**
 * Created by searover on 4/16/16.
 */
public class BasicFileOutput {
    static String inFilename = "/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/BasicFileOutput.java";
    static String outFilename = "/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/BasicFileOutput.java.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read(inFilename))
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outFilename)
                )
        );
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(outFilename));
    }
}
