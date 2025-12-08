package com.example.demo.service;

import com.example.demo.dao.AuthorityDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private final UserDAO userDAO;
    private final AuthorityDAO authorityDAO;

    public UserServiceImp(UserDAO userDAO, AuthorityDAO authorityDAO) {
        this.userDAO = userDAO;
        this.authorityDAO = authorityDAO;
    }

    @Override
    public List<User>findAll(){
        return userDAO.findAll();
    }

    @Override
    public User save(User users) {
        return userDAO.save(users);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        List<Authority>authorities=authorityDAO.findAll();
        for (Authority au : authorities) {
            if (au.getUser().getUsername().equals(username))
                throw new RuntimeException("User has authority, Cannot delete");
        }
        userDAO.deleteByUsername(username);
    }
}
