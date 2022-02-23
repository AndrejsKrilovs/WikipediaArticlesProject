package interview.wikicredit.controller;

import interview.wikicredit.Mapper;
import interview.wikicredit.data.WikipediaData;
import interview.wikicredit.data.WikipediaDataDTO;
import interview.wikicredit.service.WikiLoadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WikipediaLoading endpoint representation
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wiki.svc")
public class WikiLoadingController {
    private final Mapper mapper;
    private final WikiLoadingService wikiLoadingService;

    /**
     * Endpoint to load data from external service and generate report.
     */
    @PostMapping("/{company}")
    public WikipediaDataDTO loadEntityAndGenerateReport(@PathVariable("company") String name)  {
        return mapper.toDTO(wikiLoadingService.loadEntity(name));
    }
}
