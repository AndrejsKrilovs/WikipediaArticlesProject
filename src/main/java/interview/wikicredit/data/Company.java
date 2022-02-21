package interview.wikicredit.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Company table representation from database
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "wikicredit")
public class Company {
  @Id
  @GeneratedValue
  private Integer cid;
  private String name;
}
