package com.anchnet.demo;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;

/**
 * Created by searover on 3/29/16.
 */
public class MyEurekaService {
    public static void main(String[] args) {
        DynamicPropertyFactory configInstance = DynamicPropertyFactory.getInstance();
        ApplicationInfoManager applicationInfoManager = ApplicationInfoManager.getInstance();
        DiscoveryManager.getInstance().initComponent(
                new MyDataCenterInstanceConfig(),
                new DefaultEurekaClientConfig()
        );
        EurekaClient eurekaClient = DiscoveryManager.getInstance().getEurekaClient();
        EurekaServiceBase eurekaServiceBase = new EurekaServiceBase(applicationInfoManager, eurekaClient, configInstance);
        try {
            eurekaServiceBase.start();
        }finally {
            eurekaServiceBase.stop();
        }
    }
}
