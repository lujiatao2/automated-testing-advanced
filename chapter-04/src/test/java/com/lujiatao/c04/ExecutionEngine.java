package com.lujiatao.c04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lujiatao.c04.FrameworkUtil.keywordToMethod;
import static com.lujiatao.c04.FrameworkUtil.readExcel;

public class ExecutionEngine {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object[][] testcase = readExcel("testcase.xlsx", "Sheet1");
        List<String> srcMethodNames = new ArrayList<>();
        List<Object[]> srcMethodParams = new ArrayList<>();
        for (Object[] objects : testcase) {
            srcMethodNames.add(keywordToMethod(String.valueOf(objects[0])));
            Object[] srcMethodParam = new String[objects.length - 1];
            System.arraycopy(objects, 1, srcMethodParam, 0, objects.length - 1);
            srcMethodParams.add(srcMethodParam);
        }
        Method[] methods = Keywords.class.getDeclaredMethods();
        List<String> methodNames = new ArrayList<>();
        List<Integer> methodParamNums = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add(method.getName());
            methodParamNums.add(method.getParameters().length);
        }
        for (int i = 0; i < srcMethodNames.size(); i++) {
            if (methodNames.contains(srcMethodNames.get(i))) {
                if (srcMethodParams.get(i).length == methodParamNums.get(methodNames.indexOf(srcMethodNames.get(i)))) {
                    Class<?>[] methodParams = new Class<?>[srcMethodParams.get(i).length];
                    Arrays.fill(methodParams, String.class);
                    Method method = Keywords.class.getDeclaredMethod(srcMethodNames.get(i), methodParams);
                    method.invoke(Keywords.class, srcMethodParams.get(i));
                } else {
                    throw new IllegalArgumentException("关键字的参数不匹配！");
                }
            } else {
                throw new IllegalArgumentException("关键字不存在！");
            }
        }
    }

}
