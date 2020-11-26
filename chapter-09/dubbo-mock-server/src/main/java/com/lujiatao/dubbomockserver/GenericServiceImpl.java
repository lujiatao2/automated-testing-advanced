package com.lujiatao.dubbomockserver;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GenericServiceImpl implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if (method.equals("search")) {
            if (parameterTypes.length == 3) {
                if (parameterTypes[0].equals("int") && parameterTypes[1].equals("java.lang.String") && parameterTypes[2].equals("java.lang.String")) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("goodsCategoryId", 1);
                    map.put("createTime", "2020-04-22 11:52:01.5928");
                    map.put("model", "iPhone 11");
                    map.put("updateTime", "2020-04-22 11:52:01.5928");
                    map.put("id", 1);
                    map.put("isInStock", true);
                    map.put("class", "com.lujiatao.ims.common.entity.Goods");
                    map.put("brand", "Apple");
                    map.put("desc", "XR继任者");
                    return Collections.singletonList(map);
                }
            }
        }
        throw new IllegalArgumentException("未提供该方法的Mock实现！");
    }

}
