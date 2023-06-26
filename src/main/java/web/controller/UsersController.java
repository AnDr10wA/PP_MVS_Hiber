package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> usersList;
        usersList = userService.showAllUsers();
        model.addAttribute("usersList", usersList);
        return "users-info";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping()
    public String createUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "newUser";
        }
        else {
        userService.addUser(user);
        return "redirect:/users";
        }
    }

    @GetMapping("/{id}/update")
    public String updateUser(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
