package Designpattern.DesignProduct;

import Designpattern.DesignProduct.AbstractProduct;

public class BProduct extends AbstractProduct {

    private String name;

    public BProduct(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        this.printBefore();
        System.out.println("print B >>>" + name);
    }

}
