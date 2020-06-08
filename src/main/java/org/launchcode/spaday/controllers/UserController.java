package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.launchcode.spaday.models.User;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here

        if (verify.equals(user.getPassword())){
            model.addAttribute("user", user);
            return "user/index";

        } else {
            //add an error attribute "passwords should match"
            String error = "Passwords should match";
            model.addAttribute("verify", verify);
            return "user/add";
        }
    }

}
