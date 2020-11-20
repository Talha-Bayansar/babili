package be.thomasmore.babili.controllers;

import be.thomasmore.babili.model.User;
import be.thomasmore.babili.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {


    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping({"/register/student", "/register/student/{filter}"})
    public String registerStudent(Principal principal, Model model, @PathVariable(required = false) String filter) {
        if (principal != null) {
            return "redirect:/user/overview-tasks";
        }
        model.addAttribute("classDanger", "form-control");
        if (filter != null) {
            if (filter.equals("userName")) {
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
            } else if (filter.equals("emailInUse")) {
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("PasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
            } else if (filter.equals("userAndEmailInUse")) {
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
                model.addAttribute("emailInUse", "Dit e-mail adres is reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("emailInUsePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("userNamePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
            } else if (filter.equals("userAndEmailInUsePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            }
        }
        return "register/register-student";
    }

    @PostMapping("/register/student")
    public String registerStudentPost(@RequestParam String userName,
                                      @RequestParam String password,
                                      @RequestParam String password2,
                                      @RequestParam String name,
                                      @RequestParam String email,
                                      Principal principal, Model model) {
        String returnValue = null;
        if (principal == null && !userName.isBlank()) {
            Optional<User> userWithUserName = userRepository.findByUsername(userName);
            if (!userWithUserName.isPresent() && password.equals(password2) && !userRepository.findByEmail(email).isPresent()) {
                User newUser = new User();
                newUser.setUsername(userName);
                String encode = passwordEncoder.encode(password);
                logger.info(String.format("password %s\n", encode));
                newUser.setPassword(encode);
                newUser.setUsername(userName);
                newUser.setName(name);
                newUser.setEmail(email);
                newUser.setRole("STUDENT");
                userRepository.save(newUser);
                autologin(userName, password);
                returnValue = "redirect:/user/overview-tasks";
            } else if (userWithUserName.isPresent() && userRepository.findByEmail(email).isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/student/userAndEmailInUsePasswordNotMatching";
            } else if (userWithUserName.isPresent() && userRepository.findByEmail(email).isPresent()) {
                returnValue = "redirect:/register/student/userAndEmailInUse";
            } else if (userWithUserName.isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/student/userNamePasswordNotMatching";
            } else if (userRepository.findByEmail(email).isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/student/emailInUsePasswordNotMatching";
            } else if (!password.equals(password2)) {
                returnValue = "redirect:/register/student/PasswordNotMatching";
            } else if (userWithUserName.isPresent()) {
                returnValue = "redirect:/register/student/userName";
            } else if (userRepository.findByEmail(email).isPresent()) {
                returnValue = "redirect:/register/student/emailInUse";
            }
        }
        return returnValue;
    }

    @GetMapping({"/register/teacher", "/register/teacher/{filter}"})
    public String registerTeacher(Principal principal, Model model, @PathVariable(required = false) String filter) {
        if (principal != null) {
            return "redirect:/user/overview-tasks";
        }
        model.addAttribute("classDanger", "form-control");
        if (filter != null) {
            if (filter.equals("userName")) {
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
            } else if (filter.equals("emailInUse")) {
                model.addAttribute("emailInUse", "Dit e-mail adres is reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("PasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
            } else if (filter.equals("userAndEmailInUse")) {
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("emailInUsePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            } else if (filter.equals("userNamePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
            } else if (filter.equals("userAndEmailInUsePasswordNotMatching")) {
                model.addAttribute("passwordNotOK", "Het ingegeven paswoord komt niet overeen.");
                model.addAttribute("classDanger", "form-control border-danger");
                model.addAttribute("userAlreadyInUse", "Deze gebruikersnaam is al reeds gekozen. Kies een andere gebruikersnaam!");
                model.addAttribute("emailInUse", "Dit e-mail adres is al reeds gebruikt. Gebruik een ander e-mail adres.");
            }
        }
        return "register/register-teacher";
    }

    @PostMapping("/register/teacher")
    public String registerTeacherPost(@RequestParam String userName,
                                      @RequestParam String password,
                                      @RequestParam String password2,
                                      @RequestParam String name,
                                      @RequestParam String email,
                                      Principal principal, Model model) {
        String returnValue = null;
        if (principal == null && !userName.isBlank()) {
            Optional<User> userWithUserName = userRepository.findByUsername(userName);
            if (!userWithUserName.isPresent() && password.equals(password2) && !userRepository.findByEmail(email).isPresent()) {
                User newUser = new User();
                newUser.setUsername(userName);
                String encode = passwordEncoder.encode(password);
                logger.info(String.format("password %s\n", encode));
                newUser.setPassword(encode);
                newUser.setUsername(userName);
                newUser.setName(name);
                newUser.setEmail(email);
                newUser.setRole("TEACHER");
                userRepository.save(newUser);
                autologin(userName, password);
                returnValue = "redirect:/user/overview-tasks";
            } else if (userWithUserName.isPresent() && userRepository.findByEmail(email).isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/teacher/userAndEmailInUsePasswordNotMatching";
            } else if (userWithUserName.isPresent() && userRepository.findByEmail(email).isPresent()) {
                returnValue = "redirect:/register/teacher/userAndEmailInUse";
            } else if (userWithUserName.isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/teacher/userNamePasswordNotMatching";
            } else if (userRepository.findByEmail(email).isPresent() && !password.equals(password2)) {
                returnValue = "redirect:/register/teacher/emailInUsePasswordNotMatching";
            } else if (!password.equals(password2)) {
                returnValue = "redirect:/register/teacher/PasswordNotMatching";
            } else if (userWithUserName.isPresent()) {
                returnValue = "redirect:/register/teacher/userName";
            } else if (userRepository.findByEmail(email).isPresent()) {
                returnValue = "redirect:/register/teacher/emailInUse";
            }
        }
        return returnValue;
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            logger.info("authentication done - result is " + auth.isAuthenticated());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    // Login form
    @RequestMapping("/")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/overview-tasks";
        return "home";
    }

    @RequestMapping("/errorLogin")
    public String errorLogin(Principal principal, Model model) {
        if (principal != null) return "redirect:/user/overview-tasks";
        model.addAttribute("error", "De gebruikersnaam en paswoord komen niet overeen.");
        return "home";
    }

}
