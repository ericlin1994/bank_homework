package com.in28minutes.springboot.jdbc.h2.example.student.contoller;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product() {

    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 略過get與set方法
}
