package vn.ht.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    Map<String,String> treeTranslate = new HashMap<>() ;

    public Dictionary(){
        treeTranslate.put("Hello","Xin chao");
        treeTranslate.put("Cat","Con Mèo");
        treeTranslate.put("Dog","Con Chó ");
        treeTranslate.put("Duck","Con Vịt");
    }

    public Map<String, String> getTreeTranslate() {
        return treeTranslate;
    }
}
