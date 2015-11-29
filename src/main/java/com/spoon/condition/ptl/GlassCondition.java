package com.spoon.condition.ptl;

import com.spoon.condition.MyBaseCondition;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015-11-28
 */
public class GlassCondition extends MyBaseCondition {
    private Integer style;
    private Integer material;
    private Integer brand;
    private Integer shape;
    private String color;
    private String width;
    private String column;
    private String order;

    public Integer getStyle() {
        return this.style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getMaterial() {
        return this.material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public Integer getBrand() {
        return this.brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getShape() {
        return this.shape;
    }

    public void setShape(Integer shape) {
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

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
