package com.project.practic.repository;

import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Override
    List<Ingredient> findAll();


}
