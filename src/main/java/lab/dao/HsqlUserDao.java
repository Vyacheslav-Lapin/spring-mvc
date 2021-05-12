package lab.dao;

import static lab.domain.User.Fields.firstName;
import static lab.domain.User.Fields.id;
import static lab.domain.User.Fields.lastName;

import java.util.List;
import java.util.Map;
import lab.common.NotNullNamedParameterJdbcDaoSupport;
import lab.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

@Slf4j
public class HsqlUserDaoNotNull extends NotNullNamedParameterJdbcDaoSupport implements UserDao {

  private static final RowMapper<User> userMapper =
      (rs, rowNum) -> User.builder()
                          .id(rs.getInt(id))
                          .firstName(rs.getString(firstName))
                          .lastName(rs.getString(lastName)).build();

  @Override
  public void insert(User user) {
    if (user != null) {
      log.debug("Processing user: {}", user);
      getNamedParameterJdbcTemplate()
          .update(
              "insert into user (firstName, lastName) values (:firstName, :lastName)",
              Map.of(
                  firstName, user.getFirstName(),
                  lastName, user.getLastName()));
    } else
      log.debug("Domain user is null!");
  }

  @Override
  public User select(int id) {
    User user = null;

    if (id > 0)
      user = getNamedParameterJdbcTemplate().queryForObject(
          "select id, firstname, lastname from user where id = :id",
          Map.of(User.Fields.id, id),
          userMapper);

    log.debug("Received user: {}", user);

    return user;
  }

  @Override
  public List<User> selectAll() {
    return jdbcTemplate()
               .query("select id, firstname, lastname from user", userMapper);
  }
}
