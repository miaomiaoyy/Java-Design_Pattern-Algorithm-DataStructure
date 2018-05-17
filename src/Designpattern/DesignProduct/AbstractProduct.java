package Designpattern.DesignProduct;

public abstract class AbstractProduct implements IProduct {
        protected void printBefore() {
            System.out.println("before print"); // 这里所公共的实现
        }
}
