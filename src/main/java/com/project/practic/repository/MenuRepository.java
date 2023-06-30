package com.project.practic.repository;

import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import com.project.practic.entity.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    @Override
    List<Menu> findAll();

    @Query("select menu " +
            "from Menu menu " +
            "left join fetch menu.ingredientList")
    List<Menu> findAllFetched();

    @Query("select menu " +
            "from Menu menu " +
            "left join fetch menu.clients")
    Set<Menu> findMenuFetched();
}
