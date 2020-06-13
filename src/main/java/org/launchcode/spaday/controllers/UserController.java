package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, String verify,
                                     @ModelAttribute @Valid User user, Errors errors) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());


        if (errors.hasErrors()) {
//            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

        model.addAttribute(user);
        return "user/index";

//        model.addAttribute(new User());

//        if (user.getPassword().equals(verify)) {
//            model.addAttribute(new User());
//            return "user/index";
//        } else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }




        }


//        model.addAttribute(new User());
//        if (user.getPassword().equals(verify)) {
//           return "user/index";
//        }
//


}

