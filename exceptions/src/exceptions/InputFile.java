package exceptions;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by searover on 3/28/16.
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception{
        try {
            in = new BufferedReader(new FileReader(fname));
        }catch (FileNotFoundException e){
            System.out.println("Could not open " + fname);
            // Wasn't open, so don't close it.
            throw e;
        }catch (Exception e){
            // All other exceptions must close it
            try {
                in.close();
            }catch (IOException e1){
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        }finally {
            // Don't close it here!!!
        }
    }

    public String getLine(){
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose(){
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed.");
        }
    }
}
