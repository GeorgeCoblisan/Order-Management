package businessLogic;

import dao.OrderDAO;
import model.Order;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source OrderBLL
 */

public class OrderBLL {

    public OrderBLL() {

    }

    public int insertOrder(Order order) {
        return OrderDAO.insert(order);
    }
}
