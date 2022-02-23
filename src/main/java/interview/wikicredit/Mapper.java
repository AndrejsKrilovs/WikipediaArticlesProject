package interview.wikicredit;

import interview.wikicredit.data.WikipediaData;
import interview.wikicredit.data.WikipediaDataDTO;
import org.springframework.stereotype.Component;

/**
 * Mapper class for Map WikipediaDataDTO and Wikipedia data objects
 */
@Component
public class Mapper {
    /**
     * Maps database WikipediaData object to JSON
     * @param wikipediaData is entity from database
     * @return mapped JSON object
     */
    public WikipediaDataDTO toDTO(WikipediaData wikipediaData) {
        return WikipediaDataDTO.builder()
                .loadedDate(wikipediaData.getLoadingTimestamp().toLocalDateTime())
                .companyName(wikipediaData.getCompany().getCompanyName())
                .summary(wikipediaData.getSummary())
                .recordId(wikipediaData.getId())
                .build();
    }
}
