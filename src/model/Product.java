package model;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source Product
 */

public class Product {
    private int id;
    private String produs;
    private int quantity;
    private int stock;

    public Product(int id, String produs, int quantity, int stock) {
        super();
        this.id = id;
        this.produs = produs;
        this.quantity = quantity;
        this.stock = stock;
    }
    public Product(String produs, int quantity, int stock) {
        super();
        this.produs = produs;
        this.quantity = quantity;
        this.stock = stock;
    }
    public Product(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProdus() {
        return produs;
    }
    public void setProdus(String produs) {
        this.produs = produs;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", produs='" + produs + '\'' +
                ", quantity=" + quantity +
                ", stock=" + stock +
                '}';
    }
}
