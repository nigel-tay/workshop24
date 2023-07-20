package sg.edu.nus.iss.workshop24.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop24.model.Order;

@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate jTemplate;

    private String UPDATE_ORDER_SQL = 
        """
            INSERT INTO orders (order_date, customer_name, ship_address, notes, tax)
            VALUES (?, ?, ?, ?, ?);
        """;

    private String UPDATE_ORDER_DETAILS_SQL = 
        """
            INSERT INTO order_details (order_id, product, unit_price, discount, quantity)
            VALUES (?, ?, ?, ?, ?);
        """;

    public boolean makeOrder(Order order) {

        Date orderDate = order.getOrderDate();
        String customerName = order.getCustomerName();
        String shipAddress = order.getShipAddress();
        String notes = order.getNotes();
        Double tax = order.getTax();
        
        int result = jTemplate.update(UPDATE_ORDER_SQL, orderDate, customerName, shipAddress, notes, tax);

        return result > 0 ? true: false;
    }
}
