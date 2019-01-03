package com.geotracker.geoTracker.dao;

import com.geotracker.geoTracker.domain.User;
import com.geotracker.geoTracker.repository.BaseRepository;
import com.geotracker.geoTracker.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class UserDAO extends BaseCrudDAO<User> {

    @Resource
    UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findOne(Long id){
        Optional<User> user = userRepository.findById(id);
        if( user.isPresent()) {
            return  user.get();
        }
        return null;
    }

    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }



}
