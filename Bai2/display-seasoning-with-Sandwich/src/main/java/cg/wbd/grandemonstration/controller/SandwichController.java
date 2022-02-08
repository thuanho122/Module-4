package cg.wbd.grandemonstration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/saves")
    public String save(@RequestParam("condiments") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "save";
    }
}