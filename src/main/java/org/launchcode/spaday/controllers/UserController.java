package org.launchcode.spaday.controllers;
import org.springframework.web.bind.annotation.ModelAttribute;

//import org.launchcode.spaday.models.Client;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here

        if (verify.equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "user/index";
        } else {
            return "user/add";
        }
    }

}

