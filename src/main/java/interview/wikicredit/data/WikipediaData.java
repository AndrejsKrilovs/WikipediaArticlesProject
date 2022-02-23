package interview.wikicredit.data;

import lombok.Data;

import java.sql.Timestamp;

/**
 * WikipediaData table representation from database
 */
@Data
public class WikipediaData {
  private Company cid;
  private Integer pageId;
  private String summary;
  private Timestamp loadingTimestamp;
}
