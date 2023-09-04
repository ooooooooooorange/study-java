package com.chapter15.homework;

import org.junit.Test;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/6/10 16:29
 */
public class Homework01 {
    @Test
    public void testList(){
        DAO<com.chapter15.homework.User> userDAO = new DAO<User>();
        userDAO.save("001", new User(1, 10, "jack"));
        userDAO.save("002", new User(2, 18, "king"));
        userDAO.save("003", new User(3, 38, "smith"));
        System.out.println(userDAO.list());
        userDAO.update("003", new User(3, 58, "milan"));
        System.out.println(userDAO.list());
        userDAO.delete("001");
        System.out.println(userDAO.list());
    }
}
