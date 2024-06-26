package com.example.Ex311.Spring.Boot.service;




import com.example.Ex311.Spring.Boot.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> read();

    List<User> userPage(long id);

    User delete(long id);

    User update(long id, String name, String lastname);

    User upPage(long id);
}
