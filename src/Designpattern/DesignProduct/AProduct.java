package Designpattern.DesignProduct;

import Designpattern.DesignProduct.AbstractProduct;

public class AProduct extends AbstractProduct {
        private String name;

        public AProduct(String name) {
            this.name = name;
        }

        @Override
        public void print() {
            this.printBefore();
            System.out.println("print A >>>" + name);
        }
    }


