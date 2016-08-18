package com.searover.demo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * Created by searover on 7/21/16.
 */
public class ZKDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.9.21:2181", 3000, null);
        List<String> list = zooKeeper.getChildren("/brokers/ids", false);
        byte data[] = data = zooKeeper.getData("/brokers/ids/0", false, null);
        String d = new String(data);
        System.out.println(d);
    }
}
