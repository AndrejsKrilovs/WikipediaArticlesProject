package interview.wikicredit.data;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class WikipediaData {
  int id;
  boolean articleExists;
  int pageId;
  String summary;
  Timestamp loadingTimestamp;
}
