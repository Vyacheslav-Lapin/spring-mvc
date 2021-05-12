package lab.service;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

import java.util.List;
import lab.dao.UserDao;
import lab.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.DispatcherServlet;

@Service
@RequiredArgsConstructor
public class UserService {

  UserDao userDao;

  @Transactional(readOnly = true, propagation = SUPPORTS, isolation = READ_COMMITTED)
  public List<User> loadAllUsers() {
    return userDao.selectAll();
  }

  @Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
  public void saveUser(User user) {
    userDao.insert(user);
  }
}
