package com.project.practic.entity;

import com.project.practic.dto.MenuDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu", schema = "practic")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private String weight;
    @Column(name = "price")
    private String price;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredientList;

    @ManyToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Set<Client> clients;

    public void addIngredient(Ingredient ingredient){
        ingredientList.add(ingredient);
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public static MenuDto toMenuDto(Menu menu) {

        MenuDto menuDto = new MenuDto();

        menuDto.setId(menu.getId());
        menuDto.setPrice(menu.getPrice());
        menuDto.setName(menu.getName());
        menuDto.setWeight(menu.getWeight());
        menuDto.setIngredientList(menu.getIngredientList().stream()
                .map(Ingredient::toIngredientDto)
                .collect(Collectors.toList()));
        menuDto.setClients(menu.getClients().stream()
                .map(Client::toClientDto)
                .collect(Collectors.toSet()));


        return menuDto;
    }

}