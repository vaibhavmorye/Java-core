package com.geotracker.geoTracker.service;

import com.geotracker.geoTracker.dao.UserDAO;
import com.geotracker.geoTracker.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserDAO userDAO;

    public User save(User user){
        return userDAO.save(user);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public User findOne(long id){
        return userDAO.findOne(id);
    }

    public void delete(Long id){
        userDAO.delete(id);
    }


}
