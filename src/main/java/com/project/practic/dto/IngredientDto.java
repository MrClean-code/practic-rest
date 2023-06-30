package com.project.practic.dto;

import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import lombok.Data;

import javax.persistence.*;

@Data
public class IngredientDto {
    private Long id;
    private String name;

    public static Ingredient toIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());

        return ingredient;
    }
}
