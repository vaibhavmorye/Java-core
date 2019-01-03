package com.geotracker.geoTracker.dao;

import com.geotracker.geoTracker.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudDAO<E extends BaseEntity> implements IBaseDAO<E> {

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Page<E> findAll(PageRequest pageRequest) {
        return getRepository().findAll(pageRequest);
    }

    @Override
    public Optional<E> findById(Long id) {
        return getRepository().findById(id);
    }

    public abstract JpaRepository<E, Long> getRepository();

    @Override
    public E save(E entity) {
        return getRepository().saveAndFlush(entity);
    }



}
