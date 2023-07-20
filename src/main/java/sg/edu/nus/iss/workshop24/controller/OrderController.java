package sg.edu.nus.iss.workshop24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.workshop24.model.Order;
import sg.edu.nus.iss.workshop24.service.OrderService;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    OrderService oService;

    @GetMapping
    public String getFormPage(Model m) {
        m.addAttribute("order", new Order());
        return "form";
    }

    @GetMapping("/orderdetails")
    public String getOrderDetailsPage(@ModelAttribute("order") Order order) {
        oService.makeOrder(order);
        return "orderdetails";
    }
}
