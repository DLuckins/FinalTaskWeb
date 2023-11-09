package com.example.FinalProjectWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("recipe", new Recipe());
        return "add";
    }
    @PostMapping("/add")
    public String create(Recipe recipe){
        System.out.println(recipe.getDesc());
        FinalProjectWebApplication.recipes.add(recipe);
        DBoperations.add(recipe);
        return "add";
    }
    @RequestMapping
    public String find(Model model, String q){
        List<Recipe> found = new ArrayList<>();
        List<Recipe> copy = FinalProjectWebApplication.recipes;
        if(q!=null) {
            for (Recipe recipe :
                    copy) {
                if (recipe.getName().toLowerCase().contains(q.toLowerCase())) {
                    found.add(recipe);
                }
            }
            System.out.println(found);
            model.addAttribute("found",found);
        }
        else{
            model.addAttribute("found",copy);
        }
            return "index";
        }
  /*  @RequestMapping("/")
    public String printHello(){
        return "search";
    }*/
}
