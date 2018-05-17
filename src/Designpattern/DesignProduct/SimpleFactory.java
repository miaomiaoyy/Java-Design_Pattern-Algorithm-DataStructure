package Designpattern.DesignProduct;

import Designpattern.DesignProduct.AProduct;
import Designpattern.DesignProduct.BProduct;
import Designpattern.DesignProduct.IProduct;

public class SimpleFactory {
    public static IProduct getProduct(String name) {
        if ("A".equals(name)) {
            return new AProduct(name);
        } else if ("B".equals(name)) {
            return new BProduct(name);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
