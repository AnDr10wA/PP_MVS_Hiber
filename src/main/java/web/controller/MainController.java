package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping
public class MainController {
    @GetMapping()
    public String mainPage() {
        return "main";
    }
}
