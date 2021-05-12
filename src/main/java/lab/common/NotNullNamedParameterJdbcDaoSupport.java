package lab.common;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class NotNullNamedParameterJdbcDaoSupport
    extends org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport {

  @NotNull
  @Override
  public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    return Objects.requireNonNull(super.getNamedParameterJdbcTemplate());
  }

  @NotNull
  public JdbcTemplate jdbcTemplate() {
    return Objects.requireNonNull(super.getJdbcTemplate());
  }
}
