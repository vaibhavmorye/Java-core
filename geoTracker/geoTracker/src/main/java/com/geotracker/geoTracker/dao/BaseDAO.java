package com.geotracker.geoTracker.dao;

import com.geotracker.geoTracker.domain.User;
import com.geotracker.geoTracker.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseDAO {

    public abstract JpaRepository getRepository();

    public User save(User user) {
        return (User)getRepository().save(user);
    }


    public List<User> findAll() {
        return getRepository().findAll();
    }


    public Optional<User> findOne(long id) {
        return  getRepository().findOne(id);
    }


    public void delete(long id) {
        getRepository().delete(id);
    }


}
