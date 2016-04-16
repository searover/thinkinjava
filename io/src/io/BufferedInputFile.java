package io;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by searover on 4/16/16.
 * 缓冲输入文件
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException{
        // Reading input by line
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + '\n');
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/searover/Documents/temp/java-demo/thinkinjava/io/src/io/BufferedInputFile.java"));
    }
}
