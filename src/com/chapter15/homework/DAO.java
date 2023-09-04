package com.chapter15.homework;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 16:23
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<String, T>();

    public DAO() {
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        save(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }
}
