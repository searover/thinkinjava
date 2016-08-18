package com.searover.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import service.qc.vxnet.VxnetResponse;
import service.qc.vxnet.VxnetThrift;
import service.serror.SError;
import shared.SharedStruct;
import tutorial.Calculator;
import tutorial.InvalidOperation;
import tutorial.Operation;
import tutorial.Work;

/**
 * Created by searover on 6/9/16.
 */
public class JavaClient {
    public static void main(String[] args) {
        args = new String[]{"simple"};
        if (args.length != 1) {
            System.out.println("Please enter 'simple' or 'secure'");
            System.exit(0);
        }
        try {
            TTransport transport = null;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
//            Calculator.Client client2 = new Calculator.Client(protocol);
//            perform(client2);
            TMultiplexedProtocol vxnetProtocol = new TMultiplexedProtocol(protocol, "VxnetService");
            TMultiplexedProtocol calculatorProtocol = new TMultiplexedProtocol(protocol, "Calculator");
            Calculator.Client client = new Calculator.Client(calculatorProtocol);
//            perform(client);
            VxnetThrift.Client client2 = new VxnetThrift.Client(vxnetProtocol);
//            VxnetRequest request = new VxnetRequest("ac2", "测试中文字符", "1", 3);
//            VxnetResponse response = client2.create(request, 1, 1);
//            System.out.println(response);
            transport.close();
//        } catch (SError sError) {
//            System.out.println(sError.code + "\t" + sError.message);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void perform(Calculator.Client client) throws TException {
        client.ping();
        System.out.println("ping()");
        int sum = client.add(1, 1);
        System.out.println("1+1=" + sum);
        Work work = new Work();
        work.op = Operation.DIVIDE;
        work.num1 = 1;
        work.num2 = 0;
        try {
            int quotient = client.calculate(1, work);
            System.out.println("Whoa, we can divide by 0");
        } catch (InvalidOperation io) {
            System.out.println("Invalid operation: " + io.why);
        }

        work.op = Operation.SUBTRACT;
        work.num1 = 15;
        work.num2 = 10;
        try {
            int diff = client.calculate(1, work);
            System.out.println("15 - 10 = " + diff);
        } catch (InvalidOperation io) {
            System.out.println("Invalid operation: " + io.why);
        }
        SharedStruct log = client.getStruct(1);
        System.out.println("Check log: " + log.value);
    }
}
