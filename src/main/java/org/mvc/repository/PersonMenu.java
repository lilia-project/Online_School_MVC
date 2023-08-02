package org.mvc.repository;

import org.mvc.entity.MenuItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMenu {

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.add(new MenuItem("/badex_war_exploded/form", "Додати студента JSON"));
        menuItems.add(new MenuItem("/badex_war_exploded/", "Головна"));
        menuItems.add(new MenuItem("/badex_war_exploded/all-students", "Усі студенти"));
        menuItems.add(new MenuItem("/badex_war_exploded/categories", "Приклад джейсону"));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
