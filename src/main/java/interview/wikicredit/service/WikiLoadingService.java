package interview.wikicredit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import interview.wikicredit.data.Company;
import interview.wikicredit.data.WikipediaData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * WikiLoading service to provide information from wikipedia
 */
@Service
@RequiredArgsConstructor
public class WikiLoadingService {
    private final static String EXTRACT_PROPERTY = "extract";
    private final static String PAGE_ID_PROPERTY = "pageid";
    private final static String URL = "https://en.wikipedia.org/api/rest_v1/page/summary/%s";
    private final static String URL_INCORRECT_EXCEPTION = "Incorrect URL for company %s";
    private final static String DATA_PARSING_EXCEPTION = "Cannot parse data to json from external resource:/n %s";
    private final static String COMPANY_NAME_VALIDATE_EXCEPTION = "Company name cannot be empty!";

    private final CompanyService companyService;

    /**
     * Gets data from external service and saves it in local database
     * @param name is name of a company
     * @return wikipedia data about company
     */
    public WikipediaData loadEntity(String name) {
        if(name.isBlank()) {
            throw new ValidationException(COMPANY_NAME_VALIDATE_EXCEPTION);
        }

        try{
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> loadedData = mapper.readValue(new URL(String.format(URL, name)), Map.class);

            Company company = companyService.findCompanyByName(name.trim());
            Integer pageId = (Integer) loadedData.get(PAGE_ID_PROPERTY);
            String summary = String.valueOf(loadedData.get(EXTRACT_PROPERTY));
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

            WikipediaData entity = new WikipediaData();
            entity.setCompany(company);
            entity.setPageId(pageId);
            entity.setSummary(summary);
            entity.setLoadingTimestamp(timestamp);

            return entity;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(String.format(URL_INCORRECT_EXCEPTION, name));
        } catch (IOException ioException) {
            throw new RuntimeException(String.format(DATA_PARSING_EXCEPTION, ioException.getCause()));
        }
    }
}
