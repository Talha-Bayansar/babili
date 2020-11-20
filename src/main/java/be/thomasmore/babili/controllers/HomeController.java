package be.thomasmore.babili.controllers;

import be.thomasmore.babili.model.Inlevering;
import be.thomasmore.babili.model.Opdracht;
import be.thomasmore.babili.model.User;
import be.thomasmore.babili.repositories.InleveringRepository;
import be.thomasmore.babili.repositories.OpdrachtRepository;
import be.thomasmore.babili.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;


@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/","/{error}"})
    public String home(Principal principal, @PathVariable(required = false) String error, Model model) {
        String loggedInName = principal != null ? principal.getName() : "nobody";
        if (error != null){
            model.addAttribute("error", "Gelieve een correcte gebruikersnaam en paswoord in te geven.");
        }
        logger.info("logged in: " + loggedInName);
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}