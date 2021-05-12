package lab.controller;

import javax.validation.Valid;
import lab.domain.User;
import lab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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
@RequestMapping("/adduser.form")
public class UserFormController {

  UserService userService;

  @ModelAttribute("userFormBean")
  public User getUserFormBean() {
    return new User();
  }

  @GetMapping
  public String get() {
    return "adduserform";
  }

  @PostMapping
  public ModelAndView processSubmit(@Valid User user,
                                    Errors errors) {
    if (errors.hasErrors()) {
      log.info("Adduserform validation failed.");
      return new ModelAndView("adduserform");
    } else {
      log.info("Adding new {}", user);
      userService.saveUser(user);

      return new ModelAndView("userlistview", "userList", userService.loadAllUsers());
    }
  }
}
