package interview.wikicredit.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * WikipediaData table representation from database
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "wikicredit")
public class WikipediaData {
  @Id
  private Integer id;

  @OneToOne
  @JoinColumn(name = "cid", unique = true)
  private Company company;

  @Lob
  private String summary;
  private Integer pageId;
  private Timestamp loadingTimestamp;
}
