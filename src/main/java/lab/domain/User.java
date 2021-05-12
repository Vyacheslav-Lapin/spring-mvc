package lab.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class User {

  int id;

  @Size(min = 2, max = 20)
  @NotNull(message = "{NotNull.userFormBean.firstName}")
  String firstName;

  @NotNull
  @Size(min = 2, max = 30)
  String lastName;
}
