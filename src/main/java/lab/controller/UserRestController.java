package lab.controller;

import lab.dao.HsqlUserDao;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserRestController {

  //  ObjectMapper

  HsqlUserDao hsqlUserDao;

  @ResponseBody
  @GetMapping(value = "{id}", produces = "application/json")
  public final @NotNull ResponseEntity<String> method(@PathVariable int id) {
    val user = hsqlUserDao.select(id);
    return ResponseEntity.ok("""
        {
          "id": %d,
          "firstName": "%s",
          "lastName": "%s"
        }""".formatted(
        user.getId(),
        user.getFirstName(),
        user.getLastName()));
  }
}
