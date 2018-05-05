package hospitalApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/goAdminHome")
    public String goHome(Model model) {
        return "administratorHome";
    }

    @GetMapping("/administratorHome")
    public String administratorIndex(Model model){
        return "administratorHome";
    }

    @GetMapping("/createUser")
    public String goToCreateForm(Model model){
        return "redirect:/userCreateForm";
    }

    @GetMapping("/findUser")
    public String goToFindForm(Model model){
        return "redirect:/userFindForm";
    }

    @GetMapping("/updateUser")
    public String goToUpdateForm(Model model){
        return "redirect:/userFindForm";
    }

    @GetMapping("/deleteUser")
    public String goToDeleteForm(Model model){
        return "redirect:/userDeleteForm";
    }

}
