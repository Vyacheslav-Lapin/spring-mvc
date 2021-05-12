package lab.controller;

import javax.validation.Valid;
import lab.domain.User;
import lab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/addUser.form")
public class UserFormController {

  UserService userService;

  @ModelAttribute("user")
  public User getUserFormBean() {
    return new User();
  }

  @GetMapping
  public String get() {
    return "addUserForm";
  }

  @PostMapping
  public ModelAndView processSubmit(@Valid User user,
                                    Errors errors) {
    if (errors.hasErrors()) {
      log.info("AddUserForm validation failed.");
      return new ModelAndView("addUserForm");
    } else {
      log.info("Adding new {}", user);
      userService.saveUser(user);

      return new ModelAndView("usersView", "users", userService.loadAllUsers());
    }
  }
}
