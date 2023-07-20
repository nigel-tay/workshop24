package sg.edu.nus.iss.workshop24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class OrderController {

    @GetMapping
    public String getFormPage(Model m) {
        return "form";
    }
}
