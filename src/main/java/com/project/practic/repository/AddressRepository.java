package com.project.practic.repository;

import com.project.practic.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    @Override
    List<Address> findAll();
}
