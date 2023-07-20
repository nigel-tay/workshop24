package sg.edu.nus.iss.workshop24.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Date date;
    private String customerName;
    private String shipAddress;
    private String notes;
    private Double tax;
}
