package com.searover.thrift.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import tutorial.Calculator;

/**
 * Created by searover on 6/9/16.
 */
public class JavaServer {
    public static CalculatorHandler handler;
    public static Calculator.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new CalculatorHandler();
            processor = new Calculator.Processor(handler);
            Runnable simple = new Runnable() {
                @Override
                public void run() {
                    simple(processor);
                }
            };
            new Thread(simple).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void simple(Calculator.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9091);
            TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();
            multiplexedProcessor.registerProcessor("Calculator", new Calculator.Processor<>(handler));
//            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(multiplexedProcessor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
