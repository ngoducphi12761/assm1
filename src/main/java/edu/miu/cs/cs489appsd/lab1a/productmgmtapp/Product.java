package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import java.util.Date;

public class Product {
    private Date  dateSupplied;
    private  String productId ;
    private String name;
    private int quantityInStock;
    private double unitPrice;

    public static class Builder {
        public  String productId ;
        public String name;
        public Date  dateSupplied;
        public int quantityInStock;
        private double unitPrice;
        public Builder withProductId(String productId) {
            this.productId = productId;
            return this;
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withDateSupplied(Date dateSupplied) {
            this.dateSupplied = dateSupplied;
            return this;
        }
        public Builder withQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
            return this;
        }
        public Builder withUnitPrice(double unitPrice) {
               this.unitPrice = unitPrice;
               return this;
        }
        public Product build() {
            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.dateSupplied = builder.dateSupplied;
        this.quantityInStock = builder.quantityInStock;
        this.unitPrice = builder.unitPrice;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
