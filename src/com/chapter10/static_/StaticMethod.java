package com.chapter10.static_;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/15 13:08.
 */
public class StaticMethod {
    public static void main(String[] args) {
        //new C();

//        LinkedHashMap<String,String> nodeMap = new LinkedHashMap<String,String>();
//        nodeMap.put("1", "节点1");
//        nodeMap.put("2", "节点2");
//        nodeMap.put("7", "节点77");
//        nodeMap.put("6", "节点66");
//        nodeMap.put("3", "节点3");
//        nodeMap.put("4", "节点4");
//        nodeMap.put("5", "节点5");
//        nodeMap.put("4", "节点44");
//        nodeMap.put("3", "节点33");
//        nodeMap.put("2", "节点22");
//        List<String> nodeIds = nodeMap.keySet().stream().collect(Collectors.toList());
//        List<String> nodeNames = new ArrayList<>(nodeMap.values());
////        System.out.println(nodeIds);
////        System.out.println(nodeMap.values());
////        System.out.println(D.i);
//        for (Map.Entry<String, String> entry : nodeMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

//        Map<String,List<String>> appIdToNodeIdsMap = new HashMap<>();
//        List<String> nodeIds = new ArrayList<>();
//        nodeIds.add("node1");
//        appIdToNodeIdsMap.put("app1", nodeIds);
//        List<String> nodeIds1 = appIdToNodeIdsMap.get("app1");
//        if(nodeIds1 == null){
//            System.out.println("nodeIds == null");
//        } else{
//            System.out.println(nodeIds1);
//            nodeIds1.add("node2");
//        }
//        System.out.println(appIdToNodeIdsMap);

//        List<String> quotaHeaderList = new ArrayList<>(10);
//        System.out.println(Integer.valueOf(quotaHeaderList.get(0)) + Integer.valueOf("5").toString());//报错，null无法解析成Integer

        //转置二维列表
//        List<List<String>> quotaListList = new ArrayList<>();
//        quotaListList.add(Arrays.asList("1", "2", "3"));
//        quotaListList.add(Arrays.asList("4", "5", "6"));
//        List<String> quotaIdList = Arrays.asList("3", "2", "1");
//
//        List<List<String>> newquotaListList = new ArrayList<>();
//        List<String> singelNodeQuotaList = quotaListList.get(0);
//        for (int j = 0; j < singelNodeQuotaList.size(); j++) {
//            newquotaListList.add(new ArrayList<>());
//        }
//        for (int i = 0; i < quotaListList.size(); i++) {
//            singelNodeQuotaList = quotaListList.get(i);
//            for (int j = 0; j < singelNodeQuotaList.size(); j++) {
//                newquotaListList.get(j).add(singelNodeQuotaList.get(j));
//            }
//        }
//        List<String> quotaSum = new ArrayList<>();
//        for (int i = 0; i < quotaIdList.size(); i++) {
//            System.out.println(newquotaListList.get(i));
//            System.out.println(quotaIdList.get(i));
//        }

//        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
//        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        Map<String, List<String>> nodeIdToOrgIdsMap = new HashMap<>();
        nodeIdToOrgIdsMap.put("businessNode1", Arrays.asList("Mhr6Vcq8", "Mhr6Vcq9"));
        nodeIdToOrgIdsMap.put("businessNode2", Arrays.asList("Mhr6Vcq22", "Mhr6Vcq33"));
        System.out.println(nodeIdToOrgIdsMap.entrySet().iterator().next().getKey());
        System.out.println(nodeIdToOrgIdsMap.entrySet().iterator().next().getValue());


    }

}

abstract class D{
    public static int i =10;
}
class A {//继承子Object
    static int staticA = funA1();
    static {System.out.println("2.A类的静态代码块");};
    {System.out.println("7.A类的非静态代码块");};
    int a = funA2();
    public static int funA1(){
        System.out.println("1.A类的静态方法");
        return 10;
    }
    public int funA2(){
        System.out.println("8.13.A类的非静态方法");
        return 20;
    }

    public A() {
        //隐藏的执行要求：
        //(1) super();————Object的构造方法
        //(2) 调用A的非静态初始化
        System.out.println("9.A类的构造方法");
    }
}

class B extends A {
    static {System.out.println("3.B类的静态代码块");};
    static int staticB = funB1();
    int b = funB2();
    {System.out.println("11.B类的非静态代码块");};

    public static int funB1(){
        System.out.println("4.6.B类的静态方法");
        return 30;
    }
    public int funB2(){
        System.out.println("10.B类的非静态方法");
        return 40;
    }

    public B() {
        //隐藏的执行要求：
        //(1) super();————A的构造方法
        //(2) 调用B的非静态代码块
        System.out.println("12.B类的构造方法");
    }
}

class C extends B {
    static {System.out.println("5.C类的静态代码块");};
    static int staticC = funB1();
    int c = funA2();
    {System.out.println("14.C类的非静态代码块");};

    public static int funC1(){
        System.out.println("6.C类的静态方法");
        return 30;
    }
    public int funC2(){
        System.out.println("8.C类的非静态方法");
        return 40;
    }

    public C() {
        //隐藏的执行要求：
        //(1) super();————B的构造方法
        //(2) 调用B的非静态代码块
        System.out.println("15.C类的构造方法");
    }

    int rand8(){
        return 7;
    }

    int rand7(){
        int i;
        do {
            i = rand8();
        }while (i == 8);
        return 1;
    }
}


