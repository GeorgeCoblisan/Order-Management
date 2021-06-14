package businessLogic;

import java.util.NoSuchElementException;

import dao.ProductDAO;
import model.Product;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source ProductBLL
 */

public class ProductBLL {

    public ProductBLL() {
    }

    public Product find(int id) {
        Product st = ProductDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return st;
    }

    public int insertProduct(Product Product) {
        return ProductDAO.insert(Product);
    }

    public int editProduct(Product Product) {
        return ProductDAO.edit(Product);
    }

    public int deleteProduct(Product Product) {
        return ProductDAO.delete(Product);
    }
}

