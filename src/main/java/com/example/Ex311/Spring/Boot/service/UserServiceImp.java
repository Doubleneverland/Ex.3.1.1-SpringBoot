package com.example.Ex311.Spring.Boot.service;

import com.example.Ex311.Spring.Boot.dao.UserDao;
import com.example.Ex311.Spring.Boot.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {this.userDao = userDao;}

    @PostConstruct
    @Transactional
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
    public User delete(long id) {
        return userDao.delete(id);
    }

    @Override
    @Transactional
    public User update(long id, String name, String lastname) {
        return userDao.update(id, name, lastname);
    }

    @Override
    @Transactional
    public User upPage(long id) {
        return userDao.upPage(id);
    }


}
