package com.geotracker.geoTracker.dao;

import com.geotracker.geoTracker.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Optional;

public interface IBaseDAO<E extends BaseEntity> {

	void delete(E entity);

	void delete(Long id);

	List<E> findAll();

	Page<E> findAll(PageRequest pageRequest);

	Optional<E> findById(Long id);

	E save(E entity);

}
