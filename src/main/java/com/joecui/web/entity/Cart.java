package com.joecui.web.entity;

public class Cart {

    Integer id;

    Integer user_id;

    Integer food_id;

    Integer quantity;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public String toString() {
//        return "Cart [id=" + id + ", user_id=" + user_id + ", food_id=" + food_id + "," +
//                " quantity=" + quantity + "]";
//    }

//    public String toString() {
//        return  "ok" + quantity +;
//    }
}
