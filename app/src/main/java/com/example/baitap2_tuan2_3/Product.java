package com.example.baitap2_tuan2_3;

public class Product extends Goods{

    private Catalog dm;

    public Catalog getDm() {
        return dm;
    }

    public void setDm(Catalog dm) {
        this.dm = dm;
    }

    public Product(String id, String name, Catalog dm) {
        super(id, name);
        this.dm = dm;
}

    public Product(String id, String name) {
        super(id, name);

    }

    public Product(){
        super();
    }
}
