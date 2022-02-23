package interview.wikicredit.data;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * DTO object to represent WkipediaData from database
 */
@Value
@Builder
public class WikipediaDataDTO {
    Integer recordId;
    String companyName;
    LocalDateTime loadedDate;
    String summary;
}
