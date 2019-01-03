package com.geotracker.geoTracker.dao;

import com.geotracker.geoTracker.domain.User;
import com.geotracker.geoTracker.repository.BaseRepository;
import com.geotracker.geoTracker.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDAO extends BaseDAO {

    @Resource
    UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findbyUserName(username);
    }

    @Override
    public BaseRepository getRepository() {
        return userRepository;
    }



}
