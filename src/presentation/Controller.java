package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source Controller
 */

public class Controller {
    View view;

    public Controller(View v) {
        view = v;
        v.setClientGUI(new showClientGUI());
        v.setInsertClient(new insertClient());
        v.SetViewTableClient(new displayClient());
        v.setEditClient(new editClient());
        v.setDeleteClient(new deleteClient());
        v.setProductGUI(new showProductGUI());
        v.setInsertProduct(new insertProduct());
        v.SetViewTableProduct(new displayProduct());
        v.setEditProduct(new editProduct());
        v.setDeleteProduct(new deleteProduct());
        v.setOrderGUI(new showOrderGUI());
        v.makeBill(new makeBill());
        v.showOrderTable(new viewOrderTable());
    }

    class showClientGUI implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showClientGUI();
            view.resetClientTable();
        }
    }
    class insertClient implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.insertClient();
            view.resetClientTable();
        }
    }
    class editClient implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.editClient();
            view.resetClientTable();
        }
    }
    class deleteClient implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.deleteClient();
            view.resetClientTable();
        }
    }
    class displayClient implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.displayClient();
        }
    }

    class showProductGUI implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showProductGUI();
            view.resetProductTable();
        }
    }
    class insertProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.insertProduct();
            view.resetProductTable();
        }
    }
    class editProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.editProduct();
            view.resetProductTable();
        }
    }
    class deleteProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.deleteProduct();
            view.resetProductTable();
        }
    }
    class displayProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.displayProduct();
        }
    }

    class showOrderGUI implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showOrderGUI();
        }
    }
    class makeBill implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.selectAndMakeBill();
            view.resetOrderTable();
        }
    }
    class viewOrderTable implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.displayOrder();
        }
    }
}
