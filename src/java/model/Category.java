/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rioxv
 */
public class Category {
    private int cateID;
    private String cateName;

    public Category() {
    }
    public Category(int cateID, String cateName) {
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public int getCateid() {
        return cateID;
    }

    public void setCateid(int cateID) {
        this.cateID = cateID;
    }

    public String getCatename() {
        return cateName;
    }

    public void setCatename(String cateName) {
        this.cateName = cateName;
    }

    
    @Override
    public String toString() {
        return "Category{" + "cateid=" + cateID + ", catename=" + cateName + '}';
    }
    
}
