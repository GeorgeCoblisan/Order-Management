package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import dataAccess.ConnectionFactory;
import model.Client;

import javax.swing.*;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source CLientDAO
 */

public class ClientDAO extends AbstractDAO<Client> {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (name,email,age)"
            + " VALUES (?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where idClient = ?";

    private static final String editStatementString = "UPDATE client SET name = ?, email = ?, age = ? WHERE idClient = ?";

    private static final String deleteStatementString = "DELETE FROM client WHERE idClient = ?";

    @Override
    public Client deleteTable(int id) {
        return super.deleteTable(id);
    }
    @Override
    public Client findId(int id) {
        return super.findId(id);
    }
    @Override
    public Client insertTable(String a, String b, int c) {
        return super.insertTable(a, b, c);
    }
    @Override
    public Client editTable(String a, String b, int c, int id) {
        return super.editTable(a, b, c, id);
    }

    public static Client findById(int clientId) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            toReturn = new Client(clientId, name, email, age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static int insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, client.getName());
            insertStatement.setString(2, client.getEmail());
            insertStatement.setInt(3, client.getAge());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Insert", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Insert", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static int edit(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement editStatement = null;
        int editedId = -1;
        try {
            editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            editStatement.setString(1, client.getName());
            editStatement.setString(2, client.getEmail());
            editStatement.setInt(3, client.getAge());
            editStatement.setInt(4, client.getId());
            editStatement.executeUpdate();

            ResultSet rs = editStatement.getGeneratedKeys();
            if (rs.next()) {
                editedId = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Edit", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: update " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Edit", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return editedId;
    }

    public static int delete(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, client.getId());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }
}
