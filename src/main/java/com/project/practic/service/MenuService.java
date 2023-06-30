package com.project.practic.service;

import com.project.practic.dto.ClientDto;
import com.project.practic.dto.MenuDto;
import com.project.practic.entity.Client;
import com.project.practic.entity.Ingredient;
import com.project.practic.entity.Menu;
import com.project.practic.exception.MenuException;
import com.project.practic.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final IngredientService ingredientService;
    private final ClientService clientService;

    @Transactional
    public List<MenuDto> findAll() {
        List<Menu> list = menuRepository.findAll();
        return list.stream()
                .map(Menu::toMenuDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MenuDto> findAllFetched() {
        List<Menu> list = menuRepository.findAllFetched();
        return list.stream()
                .map(Menu::toMenuDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Set<MenuDto> findClientFetched() {
        Set<Menu> menuSet = menuRepository.findMenuFetched();
        return menuSet.stream()
                .map(Menu::toMenuDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public Menu saveMenu(MenuDto menuDto) {
        var menu = MenuDto.toMenu(menuDto);
        menuRepository.save(menu);
        return menu;
    }

    @Transactional
    public Menu saveMenuFromIngredient(Long menuId, Long ingredientId) {
        Menu menu = getMenu(menuId);
        Ingredient ingredient = ingredientService.getIngredient(ingredientId);
        menu.addIngredient(ingredient);
        ingredient.setMenu(menu);
        return menu;
    }

    @Transactional
    public Menu getMenu(Long id) {
        return menuRepository.findById(id).orElseThrow(() ->
                new MenuException(MessageFormat.format("Could not find menu with id: {0}", id)));
    }

    @Transactional
    public Menu saveMenuFromClient(Long menuId, Long clientId) {
        Menu menu = getMenu(menuId);
        Client client = clientService.getClient(clientId);

        menu.addClient(client);
        client.addMenu(menu);

        menuRepository.save(menu);

        return menu;
    }
}
