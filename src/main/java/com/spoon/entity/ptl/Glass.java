/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Entity
@Table(name = "ptl_glass")
public class Glass extends MyBaseEntity {
    private static final long serialVersionUID = 1L;
    private Product product;
    private int style;
    private int material;
    private int brand;
    private int shape;
    private String color;
    private String width;
    private String pics;
    private Double price;
    private String createtime;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStyle() {
        return this.style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getMaterial() {
        return this.material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getBrand() {
        return this.brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getShape() {
        return this.shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPics() {
        return this.pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
