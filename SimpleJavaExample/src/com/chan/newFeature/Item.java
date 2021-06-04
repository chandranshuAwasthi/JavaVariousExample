package com.chan.newFeature;

import java.math.BigDecimal;

public class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;

        this.price = price;
    }

    public String getName() {
        return name;

    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (qty != item.qty) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return price != null ? price.equals(item.price) : item.price == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + qty;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    //constructors, getter/setters 
}
