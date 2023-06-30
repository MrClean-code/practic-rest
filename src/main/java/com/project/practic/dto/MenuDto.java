package com.project.practic.dto;

import com.project.practic.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class MenuDto {

    private Long id;
    private String name;
    private String weight;
    private String price;
    private List<IngredientDto> ingredientList = new ArrayList<>();
    private Set<ClientDto> clients = new HashSet<>();


    public static Menu toMenu(MenuDto menuDto) {
        if (menuDto == null) {
            return null;
        }

        Menu menu = new Menu();

        menu.setId(menuDto.getId());
        menu.setName(menuDto.getName());
        menu.setWeight(menuDto.getWeight());
        menu.setPrice(menuDto.getPrice());
        menu.setIngredientList(menuDto.getIngredientList().stream()
                .map(IngredientDto::toIngredient)
                .collect(Collectors.toList()));

        menu.setClients(menuDto.getClients().stream()
                .map(ClientDto::toClient)
                .collect(Collectors.toSet()));

        return menu;
    }
}
