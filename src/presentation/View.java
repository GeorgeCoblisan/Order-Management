package presentation;

import businessLogic.ClientBLL;
import businessLogic.OrderBLL;
import businessLogic.ProductBLL;
import dataAccess.ConnectionFactory;
import model.Client;
import model.Order;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source View
 */

public class View {

    //component for main interface
    JFrame frame = new JFrame();
    JFrame frameClient = new JFrame();
    JFrame frameProduct = new JFrame();
    JFrame frameOrder = new JFrame();
    JFrame frameShowClient = new JFrame();
    JFrame frameShowProduct = new JFrame();
    JFrame frameShowOrder = new JFrame();

    JPanel panel = new JPanel();
    JPanel panelClient = new JPanel();
    JPanel panelProduct = new JPanel();
    JPanel panelOrder = new JPanel();

    JButton mainClient = new JButton("Client");
    JButton mainProduct = new JButton("Product");
    JButton mainOrder = new JButton("Order");

    //components for Client interface
    JButton insertClient = new JButton("Add new client");
    JButton editClient = new JButton("Edit client");
    JButton deleteClient = new JButton("Delete client");
    JButton viewTableClient = new JButton("View table Client");

    JLabel textNameClient = new JLabel("Name");
    JTextField nameClient = new JTextField(10);
    JLabel textEmailClient = new JLabel("Email");
    JTextField emailClient = new JTextField(10);
    JLabel textAgeClient = new JLabel("Age");
    JTextField ageClient = new JTextField(2);
    JLabel textIDClient = new JLabel("ID");
    JTextField IDClient = new JTextField(2);
    JLabel editTextNameClient = new JLabel("Name");
    JTextField editNameClient = new JTextField(10);
    JLabel editTextEmailClient = new JLabel("Email");
    JTextField editEmailClient = new JTextField(10);
    JLabel editTextAgeClient = new JLabel("Age");
    JTextField editAgeClient = new JTextField(2);
    JLabel textDelete = new JLabel("Delete client with id:");
    JTextField delClient = new JTextField(2);

    DefaultTableModel clientModel = new DefaultTableModel();
    JTable client = new JTable(clientModel);

    //components for Product interface
    JButton insertProduct = new JButton("Add new product");
    JButton editProduct = new JButton("Edit product");
    JButton deleteProduct = new JButton("Delete product");
    JButton viewTableProduct = new JButton("View table Product");

    JLabel textProdus = new JLabel("Product");
    JTextField produs = new JTextField(10);
    JLabel textQuantity = new JLabel("Quantity");
    JTextField quantity = new JTextField(4);
    JLabel textStock = new JLabel("Stock");
    JTextField stock = new JTextField(4);
    JLabel textIDProduct = new JLabel("ID");
    JTextField IDProduct = new JTextField(2);
    JLabel editTextProdus = new JLabel("Product");
    JTextField editProdus = new JTextField(10);
    JLabel editTextQuantity = new JLabel("Quantity");
    JTextField editQuantity = new JTextField(4);
    JLabel editTextStock = new JLabel("Stock");
    JTextField editStock = new JTextField(4);
    JLabel textDeleteProduct = new JLabel("Delete product with id:");
    JTextField delProduct = new JTextField(2);

    DefaultTableModel productModel = new DefaultTableModel();
    JTable product = new JTable(productModel);

    //components for Order interface

    JLabel textSelectClient = new JLabel("Select client with ID:");
    JLabel textSelectProduct = new JLabel("Select product with ID:");
    JLabel textSelectQuantity = new JLabel("Select quantity:");
    JTextField selectClient = new JTextField(3);
    JTextField selectProduct = new JTextField(3);
    JTextField selectQuantity = new JTextField(3);
    JButton select = new JButton("Select and make bill");
    DefaultTableModel orderModel = new DefaultTableModel();
    JTable order = new JTable(orderModel);
    JButton viewOrderTable = new JButton("View order table");

    public View() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setVisible(true);
        frame.setTitle("Edit");

        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Alegeti pe ce tabela doriti sa lucrati"));
        panel.add(mainClient);
        panel.add(mainProduct);
        panel.add(mainOrder);

        frame.add(panel);

        frameClient.setSize(1200, 1000);
        frameClient.add(panelClient);

        clientModel.addColumn("ID");
        clientModel.addColumn("Name");
        clientModel.addColumn("Email");
        clientModel.addColumn("Age");
        frameShowClient.setSize(700, 600);
        frameShowClient.add(new JScrollPane(client));

        frameProduct.setSize(1200, 1000);
        frameProduct.add(panelProduct);
        productModel.addColumn("ID");
        productModel.addColumn("Produs");
        productModel.addColumn("Quantity");
        productModel.addColumn("Stock");
        frameShowProduct.setSize(700, 600);
        frameShowProduct.add(new JScrollPane(product));

        frameOrder.setSize(1200, 1000);
        frameOrder.add(panelOrder);
        orderModel.addColumn("ID");
        orderModel.addColumn("ID client");
        orderModel.addColumn("ID produs");
        orderModel.addColumn("quantity");
        frameShowOrder.setSize(700, 600);
        frameShowOrder.add(new JScrollPane(order));
    }

    public void showClientGUI() {
        panelClient.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0; panelClient.add(insertClient, c);
        c.gridx = 1; panelClient.add(textNameClient, c);
        c.gridx = 2; panelClient.add(nameClient, c);
        c.gridx = 3; panelClient.add(textEmailClient, c);
        c.gridx = 4; panelClient.add(emailClient, c);
        c.gridx = 5; panelClient.add(textAgeClient, c);
        c.gridx = 6; panelClient.add(ageClient, c);
        c.gridy = 2;
        c.gridx = 0; panelClient.add(editClient, c);
        c.gridx = 1; panelClient.add(textIDClient, c);
        c.gridx = 2; panelClient.add(IDClient, c);
        c.gridx = 3; panelClient.add(editTextNameClient, c);
        c.gridx = 4; panelClient.add(editNameClient, c);
        c.gridx = 5; panelClient.add(editTextEmailClient, c);
        c.gridx = 6; panelClient.add(editEmailClient, c);
        c.gridx = 7; panelClient.add(editTextAgeClient, c);
        c.gridx = 8; panelClient.add(editAgeClient, c);
        c.gridy = 3;
        c.gridx = 0; panelClient.add(deleteClient, c);
        c.gridx = 1; panelClient.add(textDelete, c);
        c.gridx = 2; panelClient.add(delClient, c);
        c.gridy = 4;
        panelClient.add(viewTableClient, c);
        frameClient.setVisible(true);
    }

    public void displayClient() {
        int id = 0;
        String name = "";
        String email = "";
        int age = 0;
        int ok = 1;
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement findStatement = null;
        ResultSet rs = null;
        PreparedStatement headerStatement = null;
        ResultSet r = null;
        try {
            findStatement = dbConnection.prepareStatement("select * from client");
            rs = findStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idClient");
                name = rs.getString("name");
                email = rs.getString("email");
                age = rs.getInt("age");
                clientModel.addRow(new Object[]{id, name, email, age});
                if(ok == 1) {
                    System.out.println("Header of the Client table");
                    ReflectionExample.retrieveProperties(new Client(id, name, email, age));
                    ok = 0;
                }
            }
        }
        catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        frameShowClient.setVisible(true);
    }

    public void insertClient() {
        int age = Integer.parseInt(ageClient.getText());
        Client c = new Client(nameClient.getText(), emailClient.getText(), age);
        ClientBLL clientBLL = new ClientBLL();
        clientBLL.insertClient(c);
    }

    public void editClient() {
        int id = Integer.parseInt(IDClient.getText());
        int age = Integer.parseInt(editAgeClient.getText());
        ClientBLL clientBLL = new ClientBLL();
        Client c = new Client(id, editNameClient.getText(), editEmailClient.getText(), age);
        clientBLL.editClient(c);
    }

    public void deleteClient() {
        int id = Integer.parseInt(delClient.getText());
        ClientBLL clientBLL = new ClientBLL();
        Client c = new Client(id);
        clientBLL.deleteClient(c);
    }

    public void resetClientTable() {
        while(clientModel.getRowCount() > 0)
            clientModel.removeRow(0);
    }

    public void setClientGUI(ActionListener mal) {
        mainClient.addActionListener(mal);
    }
    public void setInsertClient(ActionListener mal) {
        insertClient.addActionListener(mal);
    }
    public void setEditClient(ActionListener mal) {
        editClient.addActionListener(mal);
    }
    public void setDeleteClient(ActionListener mal) {
        deleteClient.addActionListener(mal);
    }
    public void SetViewTableClient(ActionListener mal) {
        viewTableClient.addActionListener(mal);
    }

    public void showProductGUI() {
        panelProduct.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0; panelProduct.add(insertProduct, c);
        c.gridx = 1; panelProduct.add(textProdus, c);
        c.gridx = 2; panelProduct.add(produs, c);
        c.gridx = 3; panelProduct.add(textQuantity, c);
        c.gridx = 4; panelProduct.add(quantity, c);
        c.gridx = 5; panelProduct.add(textStock, c);
        c.gridx = 6; panelProduct.add(stock, c);
        c.gridy = 2;
        c.gridx = 0; panelProduct.add(editProduct, c);
        c.gridx = 1; panelProduct.add(textIDProduct, c);
        c.gridx = 2; panelProduct.add(IDProduct, c);
        c.gridx = 3; panelProduct.add(editTextProdus, c);
        c.gridx = 4; panelProduct.add(editProdus, c);
        c.gridx = 5; panelProduct.add(editTextQuantity, c);
        c.gridx = 6; panelProduct.add(editQuantity, c);
        c.gridx = 7; panelProduct.add(editTextStock, c);
        c.gridx = 8; panelProduct.add(editStock, c);
        c.gridy = 3;
        c.gridx = 0; panelProduct.add(deleteProduct, c);
        c.gridx = 1; panelProduct.add(textDeleteProduct, c);
        c.gridx = 2; panelProduct.add(delProduct, c);
        c.gridy = 4;
        panelProduct.add(viewTableProduct, c);
        frameProduct.setVisible(true);
    }

    public void displayProduct() {
        int id = 0;
        String produs = "";
        int quantity = 0;
        int stock = 0;
        int ok = 1;
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("select * from product");
            rs = findStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idproduct");
                produs = rs.getString("produs");
                quantity = rs.getInt("quantity");
                stock = rs.getInt("stock");
                productModel.addRow(new Object[]{id, produs, quantity, stock});
                if(ok == 1) {
                    System.out.println("Header of the Product table");
                    ReflectionExample.retrieveProperties(new Product(id, produs, quantity, stock));
                    ok = 0;
                }
            }
        }
        catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        frameShowProduct.setVisible(true);
    }

    public void insertProduct() {
        int q = Integer.parseInt(quantity.getText());
        int s = Integer.parseInt(stock.getText());
        Product p = new Product(produs.getText(), q, s);
        ProductBLL productBLL = new ProductBLL();
        productBLL.insertProduct(p);
    }

    public void editProduct() {
        int id = Integer.parseInt(IDProduct.getText());
        int q = Integer.parseInt(editQuantity.getText());
        int s = Integer.parseInt(editStock.getText());
        Product p = new Product(id, editProdus.getText(), q, s);
        ProductBLL productBLL = new ProductBLL();
        productBLL.editProduct(p);
    }

    public void deleteProduct() {
        int id = Integer.parseInt(delProduct.getText());
        Product p = new Product(id);
        ProductBLL productBLL = new ProductBLL();
        productBLL.deleteProduct(p);
    }

    public void resetProductTable() {
        while(productModel.getRowCount() > 0)
            productModel.removeRow(0);
    }

    public void setProductGUI(ActionListener mal) {
        mainProduct.addActionListener(mal);
    }
    public void setInsertProduct(ActionListener mal) {
        insertProduct.addActionListener(mal);
    }
    public void setEditProduct(ActionListener mal) {
        editProduct.addActionListener(mal);
    }
    public void setDeleteProduct(ActionListener mal) {
        deleteProduct.addActionListener(mal);
    }
    public void SetViewTableProduct(ActionListener mal) {
        viewTableProduct.addActionListener(mal);
    }

    public void showOrderGUI() {
        panelOrder.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        c.gridx = 0; panelOrder.add(textSelectClient, c);
        c.gridx = 1; panelOrder.add(selectClient, c);
        c.gridy = 2;
        c.gridx = 0; panelOrder.add(textSelectProduct, c);
        c.gridx = 1; panelOrder.add(selectProduct, c);
        c.gridy = 3;
        c.gridx = 0; panelOrder.add(textSelectQuantity, c);
        c.gridx = 1; panelOrder.add(selectQuantity, c);
        c.gridy = 4;
        panelOrder.add(select, c);
        c.gridy = 5;
        panelOrder.add(viewOrderTable, c);
        frameOrder.setVisible(true);
    }

    public void displayOrder() {
        int id = 0;
        int idClient = 0;
        int idProduct = 0;
        int quantity = 0;
        int ok = 1;
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement findStatement = null;
        ResultSet rs = null;
        PreparedStatement headerStatement = null;
        ResultSet r = null;
        try {
            findStatement = dbConnection.prepareStatement("select * from orderr");
            rs = findStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idorderr");
                idClient = rs.getInt("idClient");
                idProduct = rs.getInt("idProduct");
                quantity = rs.getInt("quantity");
                orderModel.addRow(new Object[]{id, idClient, idProduct, quantity});
                if(ok == 1) {
                    System.out.println("Header of the Order table");
                    ReflectionExample.retrieveProperties(new Order(id, idClient, idProduct, quantity));
                    ok = 0;
                }
            }
        }
        catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        frameShowOrder.setVisible(true);
    }

    public void insertOrder() {
        int idC = Integer.parseInt(selectClient.getText());
        int idP = Integer.parseInt(selectProduct.getText());
        int q = Integer.parseInt(selectQuantity.getText());
        Order o = new Order(idC, idP, q);
        OrderBLL orderBLL = new OrderBLL();
        orderBLL.insertOrder(o);
    }

    public void selectAndMakeBill() {
        int idClient = Integer.parseInt(selectClient.getText());
        String name = "";
        String email = "";
        int age = 0;
        int idProduct = Integer.parseInt(selectProduct.getText());
        String produs = "";
        int quantity = 0;
        int stock = 0;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatementClient = null;
        ResultSet rs = null;
        PreparedStatement findStatementProduct = null;
        ResultSet rs1 = null;
        try {
            findStatementClient = dbConnection.prepareStatement("select * from client where idClient = ?");
            findStatementClient.setInt(1, Integer.parseInt(selectClient.getText()));
            rs = findStatementClient.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                email = rs.getString("email");
                age = rs.getInt("age");
            }
            findStatementProduct = dbConnection.prepareStatement("select * from Product where idproduct = ?");
            findStatementProduct.setInt(1, Integer.parseInt(selectProduct.getText()));
            rs1 = findStatementProduct.executeQuery();
            while (rs1.next()) {
                produs = rs1.getString("produs");
                quantity = rs1.getInt("quantity");
                stock = rs1.getInt("stock");
            }
        }
        catch (SQLException e) {
            e.getMessage();
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatementClient);
            ConnectionFactory.close(rs1);
            ConnectionFactory.close(findStatementProduct);
            ConnectionFactory.close(dbConnection);
        }

        if(Integer.parseInt(selectQuantity.getText()) < quantity) {
            insertOrder();

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("bill.txt", "UTF-8");
            } catch (Exception e) {
                System.out.println("File not found");
            }
            writer.println("Bill");
            writer.println("Client: " +name + " " +email + " " +age);
            writer.println("Product: " +produs + " " +quantity + " " +stock);
            writer.println("Qauntity purchased: " +selectQuantity.getText());
            writer.close();

            Product p = new Product(idProduct, produs, quantity - Integer.parseInt(selectQuantity.getText()), stock - Integer.parseInt(selectQuantity.getText()));
            ProductBLL productBLL = new ProductBLL();
            productBLL.editProduct(p);

            JOptionPane.showMessageDialog(null, "Bill isued", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Quantity less", "Eroare", JOptionPane.ERROR_MESSAGE);
    }

    public void setOrderGUI(ActionListener mal) {
        mainOrder.addActionListener(mal);
    }
    public void makeBill(ActionListener mal) {
        select.addActionListener(mal);
    }
    public void showOrderTable(ActionListener mal) {
        viewOrderTable.addActionListener(mal);
    }
    public void resetOrderTable() {
        while(orderModel.getRowCount() > 0)
            orderModel.removeRow(0);
    }
}
