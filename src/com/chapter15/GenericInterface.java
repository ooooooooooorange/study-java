package com.chapter15;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/9 15:12
 */
public class GenericInterface {
    public static void main(String[] args) {

    }
}
interface A<T,V>{
    T fun1 (T t);
    V fun2 (V v);
}
interface B<T,V> extends A<T,V> {
}

class C<T,V> implements B<T,V>{

    @Override
    public T fun1(T t) {
        return null;
    }

    @Override
    public V fun2(V v) {
        return null;
    }
}