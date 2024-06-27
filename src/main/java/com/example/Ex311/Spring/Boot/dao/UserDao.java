package com.example.Ex311.Spring.Boot.dao;



import com.example.Ex311.Spring.Boot.entities.User;

import java.util.List;

public interface UserDao {


    void save(User user);

    List<User> read();

    User update(long id, String name, String lastname);

    void delete(long id);

//    void firstUser();

    List<User> userPage(long id);

    User upPage(long id);

}
