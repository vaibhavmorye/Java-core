package com.geotracker.geoTracker.service;

import com.geotracker.geoTracker.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {

    Logger Logger = LoggerFactory.getLogger(UserDetailsServiceImp.class);
    @Resource
    UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Logger.debug("string s :{}", s);
        return null;
    }
}
