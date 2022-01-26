package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class CustomerServlet{
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @GetMapping("/customers/save")
    public String save(long id, String name, String email, String address){
        Customer customer = new Customer();
        customerService.save(customer);
        return "list";
    }

    @GetMapping("/customers")
    public String list(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/info")
    public String info(@RequestParam Long id,Model model){
        return "info";
    }
}
