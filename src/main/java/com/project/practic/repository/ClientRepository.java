package com.project.practic.repository;

import com.project.practic.entity.Client;
import com.project.practic.entity.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Override
    List<Client> findAll();

    @Query("select client " +
            "from Client client " +
            "left join fetch client.order")
    Set<Client> findClientFetched();

    @Override
    Optional<Client> findById(Long id);
}
