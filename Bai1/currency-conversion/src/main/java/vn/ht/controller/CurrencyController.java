package vn.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/index")
    public String convert(){
        return "index";
    }
    @PostMapping("/result")
    public String result(@RequestParam String usd, Model model){
        float result= Float.parseFloat(usd) * 23000;
        model.addAttribute("result",result);
        return  "result";
    }
}
