package sg.edu.nus.iss.workshop24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Integer id;
    private Integer orderId;
    private String product;
    private Double unitPrice;
    private Double discount;
    private Integer quantity;
}
