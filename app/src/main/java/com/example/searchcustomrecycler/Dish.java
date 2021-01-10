package com.example.searchcustomrecycler;

public class Dish {
    private String name;
    private int dish_id;

    public Dish(String name, int dish_id) {
        this.name = name;
        this.dish_id = dish_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }
}
