package com.lujiatao.dubbomockserver;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.concurrent.CountDownLatch;

public class DubboMockServer {

    public static void main(String[] args) throws InterruptedException {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("DubboMockServer");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        ServiceConfig<GenericService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setInterface("com.lujiatao.ims.service.GoodsService");
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setRef(new GenericServiceImpl());
        serviceConfig.export();
        new CountDownLatch(1).await();
    }

}
