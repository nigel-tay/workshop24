package sg.edu.nus.iss.workshop24.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop24.model.Order;
import sg.edu.nus.iss.workshop24.model.OrderDetails;

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

    public boolean updateOrder(Order order) {

        Date orderDate = order.getOrderDate();
        String customerName = order.getCustomerName();
        String shipAddress = order.getShipAddress();
        String notes = order.getNotes();
        Double tax = order.getTax();
        
        int result = jTemplate.update(UPDATE_ORDER_SQL, orderDate, customerName, shipAddress, notes, tax);

        return result > 0 ? true: false;
    }

    public boolean updateOrderDetails(OrderDetails orderDetails) {

        Integer orderId = orderDetails.getOrderId();
        String product = orderDetails.getProduct();
        Double unitPrice = orderDetails.getUnitPrice();
        Double discount = orderDetails.getDiscount();
        Integer quantity = orderDetails.getQuantity();
        
        int result = jTemplate.update(UPDATE_ORDER_DETAILS_SQL, orderId, product, unitPrice, discount, quantity);

        return result > 0 ? true: false;
    }
}
