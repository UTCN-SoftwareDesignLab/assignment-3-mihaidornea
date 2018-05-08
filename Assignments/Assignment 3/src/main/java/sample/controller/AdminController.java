package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sample.dto.UserDto;
import sample.service.user.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userCreateForm")
    public String creatingForm() {
        return "/userCreateForm";
    }

    @PostMapping("/userCreateForm")
    public String createUser(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/userCreateForm";
        userService.create(userDto);
        return "/adminSuccess";
    }

    @GetMapping("/userDeleteForm")
    public String deleteForm() {
        return "/userDeleteForm";
    }

    @PostMapping("/userDeleteForm")
    public String deleteUser(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors("username"))
            return "/userDeleteForm";
        userService.deleteByUsername(userDto);
        return "/adminSuccess";
    }

    @GetMapping("/userUpdateForm")
    public String updateForm(){
        return "/userUpdateForm";
    }

    @PostMapping("/userUpdateForm")
    public String updateUser(@RequestParam Map<String, String> field){
        UserDto userDto = userService.findByUsername(field.get("username"));
        userService.update(userDto, field.get("newUsername"));
        return "/adminSuccess";
    }

    @GetMapping("/userFindForm")
    public String findForm(){
        return "/userFindForm";
    }


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
