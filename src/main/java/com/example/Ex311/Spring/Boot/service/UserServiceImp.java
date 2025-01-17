package com.example.Ex311.Spring.Boot.service;

import com.example.Ex311.Spring.Boot.dao.UserDao;
import com.example.Ex311.Spring.Boot.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {this.userDao = userDao;}

    @PostConstruct
    public void firstUser() {
        userDao.save(new User("First", "First"));
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public List<User> read() {
        return userDao.read();
    }

    @Override
    @Transactional
    public List<User> userPage(long id) { return userDao.userPage(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public User update(long id, String name, String lastname) {
        return userDao.update(id, name, lastname);
    }

    @Override
    public User upPage(long id) {
        return userDao.upPage(id);
    }


}
