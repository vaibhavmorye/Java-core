package com.geotracker.geoTracker.service;

import java.util.List;


import com.geotracker.geoTracker.domain.BaseEntity;
import com.geotracker.geoTracker.dto.BaseDTO;
import com.geotracker.geoTracker.dto.PageRequestDTO;
import com.geotracker.geoTracker.dto.PageResponseDTO;
import com.geotracker.geoTracker.dto.ResponseDTO;


public interface IBaseVendorService<E extends BaseEntity, D extends BaseDTO> {

	ResponseDTO create(D dto, Long vendorId);

	ResponseDTO delete(Long id, Long vendorId);

	ResponseDTO deleteAll(List<Long> ids, Long vendorId);

	D findById(Long id, Long vendorId);

	ResponseDTO update(D dto, Long vendorId);

	List<D> findAll(Long vendorId);

	PageResponseDTO search(PageRequestDTO pageRequestDTO, Long vendorId);

	D toDTO(E entity, D dto);

	E toEntity(D dto, E entity);

}
