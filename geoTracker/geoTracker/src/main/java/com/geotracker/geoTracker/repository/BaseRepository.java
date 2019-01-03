package com.geotracker.geoTracker.repository;

import com.geotracker.geoTracker.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseRepository<BaseEntity> extends JpaRepository<BaseEntity, Long> {
    //public BaseEntity save(BaseEntity baseEntity);
    public List<BaseEntity> findAll();
    public BaseEntity findById(long id);
    public void delete(long id);
}
