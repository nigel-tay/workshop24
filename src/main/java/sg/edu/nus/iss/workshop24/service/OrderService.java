package sg.edu.nus.iss.workshop24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop24.model.Order;
import sg.edu.nus.iss.workshop24.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository oRepo;

    public void makeOrder(Order order) {
        
        System.out.println(oRepo.updateOrder(order));
    }
}
