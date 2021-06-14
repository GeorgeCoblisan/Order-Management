package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dataAccess.ConnectionFactory;
import model.Product;

import javax.swing.*;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source ProductDAO
 */

public class ProductDAO extends AbstractDAO<Product> {

    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO Product (produs,quantity,stock)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM Product where idproduct = ?";

    private static final String editStatementString = "UPDATE Product SET produs = ?, quantity = ?, stock = ? WHERE idproduct = ?";

    private static final String deleteStatementString = "DELETE FROM Product WHERE idproduct = ?";

    @Override
    public List<Product> findAll() {
        return super.findAll();
    }
    @Override
    public Product findId(int id) {
        return super.findId(id);
    }
    @Override
    public Product insertTable(String a, String b, int c) {
        return super.insertTable(a, b, c);
    }
    @Override
    public Product editTable(String a, String b, int c, int id) {
        return super.editTable(a, b, c, id);
    }
    @Override
    public Product deleteTable(int id) {
        return super.deleteTable(id);
    }

    public static Product findById(int ProductId) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, ProductId);
            rs = findStatement.executeQuery();
            rs.next();

            String produs = rs.getString("produs");
            int quantity = rs.getInt("quantity");
            int stock = rs.getInt("stock");
            toReturn = new Product(ProductId, produs, quantity, stock);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static int insert(Product Product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, Product.getProdus());
            insertStatement.setInt(2, Product.getQuantity());
            insertStatement.setInt(3, Product.getStock());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Insert", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: insert " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Insert", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static int edit(Product Product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement editStatement = null;
        int editedId = -1;
        try {
            editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            editStatement.setString(1, Product.getProdus());
            editStatement.setInt(2, Product.getQuantity());
            editStatement.setInt(3, Product.getStock());
            editStatement.setInt(4, Product.getId());
            editStatement.executeUpdate();

            ResultSet rs = editStatement.getGeneratedKeys();
            if (rs.next()) {
                editedId = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Edit", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: update " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Edit", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return editedId;
    }

    public static int delete(Product Product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, Product.getId());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }
}
