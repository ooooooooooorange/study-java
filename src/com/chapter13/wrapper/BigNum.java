package com.chapter13.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/31 22:42
 */
public class BigNum {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("234567888888888888888888888");
        System.out.println(bigInteger.add(new BigInteger("10")));
        System.out.println(bigInteger.subtract(new BigInteger("10")));
        System.out.println(bigInteger.multiply(new BigInteger("10")));
        System.out.println(bigInteger.divide(new BigInteger("10")));

        BigDecimal bigDecimal = new BigDecimal("1.888888888888888888888888");
        System.out.println(bigDecimal.add(new BigDecimal("10")));//11.888888888888888888888888
        System.out.println(bigDecimal.subtract(new BigDecimal("10")));//-8.111111111111111111111112
        System.out.println(bigDecimal.multiply(new BigDecimal("10")));//18.888888888888888888888880
        System.out.println(bigDecimal.divide(new BigDecimal("10"), BigDecimal.ROUND_CEILING));//0.1888888888888888888888888
    }
}
