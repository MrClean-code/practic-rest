package com.project.practic.service;

import com.project.practic.dto.ClientDto;
import com.project.practic.dto.IngredientDto;
import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import com.project.practic.exception.IngredientException;
import com.project.practic.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Transactional
    public List<IngredientDto> findAll() {
        List<Ingredient> list = ingredientRepository.findAll();
        list.stream().forEach(x-> System.out.println(x.toString()));
        return list.stream()
                .map(Ingredient::toIngredientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Ingredient saveIngredient(IngredientDto ingredientDto) {
        var ingredient = IngredientDto.toIngredient(ingredientDto);
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    @Transactional
    public Ingredient getIngredient(Long id){
        return ingredientRepository.findById(id).orElseThrow(() ->
                new IngredientException(MessageFormat.format("Could not find ingredient with id: {0}", id)));

    }

}
