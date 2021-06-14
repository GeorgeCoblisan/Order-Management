package start;

import java.sql.SQLException;
import java.util.logging.Logger;

import dao.ClientDAO;
import presentation.Controller;
import presentation.View;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source Start
 */

public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        ClientDAO c = new ClientDAO();
        //c.deleteTable(12);
        //c.insertTable("Andrei", "andrei.12@yahoo.com", 19);
        //c.editTable("Marius", "marius@gmail.com", 22, 11);

        View view = new View();
        Controller controller = new Controller(view);
    }
}

