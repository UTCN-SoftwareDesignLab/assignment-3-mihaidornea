package hospitalApplication.controller;

import hospitalApplication.dto.UserDto;
import hospitalApplication.entity.User;
import hospitalApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class UserFormController {

    UserService userService;

    @Autowired
    public UserFormController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userCreateForm")
    public String creatingForm(UserDto userDto) {
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
    public String deleteForm(UserDto userDto) {
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
    public String updateForm(Model model){
        return "/userUpdateForm";
    }

    @PostMapping("/userUpdateForm")
    public String updateUser(@RequestParam Map<String, String> field){
        UserDto userDto = userService.findByUsername(field.get("username"));
        userService.update(userDto, field.get("newUsername"));
        return "/adminSuccess";
    }

    @GetMapping("/userFindForm")
    public String findForm(Model model){
        return "/userFindForm";
    }

    @PostMapping
    public ModelAndView findUser(@RequestParam Map<String, String> field){
        UserDto userDtoByEmail = userService.findByEmail(field.get("information"));
        UserDto userDtoByUsername = userService.findByUsername(field.get("information"));
        ModelAndView mav = new ModelAndView("userFound");
        if (userDtoByEmail != null){
            mav.addObject("user", userDtoByEmail);
        } else if (userDtoByUsername != null){
            mav.addObject("user", userDtoByUsername);
        }
        return mav;
    }
}
