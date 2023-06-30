package com.project.practic.controller;

import com.project.practic.dto.ClientDto;
import com.project.practic.dto.IngredientDto;
import com.project.practic.dto.MenuDto;
import com.project.practic.entity.Ingredient;
import com.project.practic.entity.Menu;
import com.project.practic.service.IngredientService;
import com.project.practic.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final IngredientService ingredientService;


    @PostMapping("/menu")
    public ResponseEntity<Menu> addMenuDto(@RequestBody MenuDto menuDto) {
        return new ResponseEntity(menuService.saveMenu(menuDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuDto>> getMenuDto() {
        return new ResponseEntity<>(menuService.findAll(),
                HttpStatus.OK);
    }


    @PostMapping("/ingredient")
    public ResponseEntity<Ingredient> addIngredientDto(@RequestBody IngredientDto ingredientDto) {
        return new ResponseEntity(ingredientService.saveIngredient(ingredientDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/ingredient")
    public ResponseEntity<List<IngredientDto>> getIngredientDto() {
        return new ResponseEntity<>(ingredientService.findAll(),
                HttpStatus.OK);
    }

    @PostMapping("/menu/{menuId}/ingredient/{ingredientId}/add")
    public ResponseEntity<Ingredient> addIngredientFromMenu(@PathVariable Long menuId,
                                                       @PathVariable Long ingredientId) {
        return new ResponseEntity(menuService.saveMenuFromIngredient(menuId, ingredientId),
                HttpStatus.CREATED);
    }

    @GetMapping("/menu/ingredient")
    public ResponseEntity<List<MenuDto>> getIngredientFromMenuDto() {
        return new ResponseEntity<>(menuService.findAllFetched(),
                HttpStatus.OK);
    }

    @PostMapping("/menu/{menuId}/client/{clientId}/add")
    public ResponseEntity<Menu> addMenu(@PathVariable Long menuId,
                                        @PathVariable Long clientId) {
        return new ResponseEntity(menuService.saveMenuFromClient(menuId, clientId),
                HttpStatus.CREATED);
    }

    @GetMapping("/menu/client")
    public ResponseEntity<Set<MenuDto>> getMenuClientDto() {
        return new ResponseEntity<>(menuService.findClientFetched(),
                HttpStatus.OK);
    }

}