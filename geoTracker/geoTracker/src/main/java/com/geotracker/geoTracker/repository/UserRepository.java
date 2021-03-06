package com.geotracker.geoTracker.repository;

import com.geotracker.geoTracker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String userName);

    @Override
    default User save(User user) {
        return null;
    }

    public User findById(long id);
}
