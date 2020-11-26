package com.lujiatao.c09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DubboMockTest {

    private GenericService genericService;
    private Gson gson;

    @BeforeClass
    public void setUpAll() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("DubboMockTest");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface("com.lujiatao.ims.service.GoodsService");
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGeneric(true);
        genericService = referenceConfig.get();
        gson = new GsonBuilder().create();
    }

    @Test
    public void testCase_001() {
        String expected = "\\[\\{\"goodsCategoryId\":1,\"createTime\":\".{24}\",\"model\":\"iPhone 11\",\"updateTime\":\".{24}\",\"id\":1,\"isInStock\":true,\"class\":\"com.lujiatao.ims.common.entity.Goods\",\"brand\":\"Apple\",\"desc\":\"XR继任者\"}]";
        Object goods = genericService.$invoke("search", new String[]{"int", "java.lang.String", "java.lang.String"}, new Object[]{1, "Apple", "iPhone 11"});
        String actual = gson.toJson(goods);
        System.out.println(expected);
        System.out.println(actual);
        assertTrue(actual.matches(expected));
    }

}
