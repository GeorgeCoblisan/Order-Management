package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import businessLogic.validators.EmailValidator;
import businessLogic.validators.AgeValidator;
import businessLogic.validators.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source ClientBLL
 */

public class ClientBLL {

    private List<Validator<Client>> validators;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
    }

    public Client find(int id) {
        Client st = ClientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Client with id =" + id + " was not found!");
        }
        return st;
    }

    public int insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return ClientDAO.insert(client);
    }

    public int editClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return ClientDAO.edit(client);
    }

    public int deleteClient(Client client) {
        return ClientDAO.delete(client);
    }

}

