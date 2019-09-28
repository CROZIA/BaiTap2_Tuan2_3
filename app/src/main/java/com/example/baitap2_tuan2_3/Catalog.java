package com.example.baitap2_tuan2_3;

import java.util.ArrayList;

public class Catalog extends Goods{

    private ArrayList<Product> productArrayList=null;

    public Catalog(String id, String name) {
        super(id, name);
        this.productArrayList=new ArrayList<Product>();
    }

    public Catalog() {
        super();
        this.productArrayList=new ArrayList<Product>();
    }

    public boolean isDuplicate(Product p){

        for (Product p1:productArrayList){
            if (p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product p){
        boolean isDup=isDuplicate(p);
        if (!isDup){
            p.setDm(this);
            return productArrayList.add(p);
        }
        return !isDup;
    }

    public ArrayList<Product> getProductArrayList(){
        return this.productArrayList;
    }
    public int size(){
        return productArrayList.size();
    }
    public Product get(int i){
        return productArrayList.get(i);
    }

}
