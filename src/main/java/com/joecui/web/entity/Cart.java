package com.joecui.web.entity;

public class Cart {

    Integer id;

    Integer user_id;

    Integer food_id;

    String food_name;

    Integer food_price;

    Integer quantity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Integer getFood_price() {
        return food_price;
    }

    public void setFood_price(Integer food_price) {
        this.food_price = food_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", user_id=" + user_id + ", food_id=" + food_id + "," +
                ", food_name" + food_name + ", food_price" + food_price + ", quantity=" + quantity + "]";
    }


}
