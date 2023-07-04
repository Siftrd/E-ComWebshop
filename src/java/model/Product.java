/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rioxv
 */
public class Product {
    private int id;
    private String name;
    private String image;
    private String title;
    private double price;
    private String description;

    public Product(){
        
    }
    public Product(int id, String name, String image, String title, double price, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "product{" + "id=" + id + ", name=" + name + ", image=" + image + ", title=" + title + ", price=" + price + ", description=" + description + '}';
    }
    
}
