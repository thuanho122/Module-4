package vn.ht.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.ht.model.Dictionary;

import java.util.Map;
import java.util.TreeMap;
@Controller
public class DictionaryController {
    @GetMapping("/run")
    public String translate(String word, Model model) {
        String res;
        Dictionary dictionary = new Dictionary();
        Map<String,String> treeTranslate = new TreeMap<>();
        treeTranslate = dictionary.getTreeTranslate() ;

        if(treeTranslate.get(word)!= null){
            res = treeTranslate.get(word) ;
        }else {
            model.addAttribute("message", "khong co trong tu dien");
            return "index";

        }
        model.addAttribute("res", res);
        return "index";
    }
}

