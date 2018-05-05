package hospitalApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/goHome")
    public String goHome(Model model) {
        return "redirect:/userCreateForm";
    }

}
