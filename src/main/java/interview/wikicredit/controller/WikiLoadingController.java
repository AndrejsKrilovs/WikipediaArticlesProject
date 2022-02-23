package interview.wikicredit.controller;

import interview.wikicredit.data.WikipediaData;
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
    private final WikiLoadingService wikiLoadingService;

  /*
  TODO: implement two endpoints.
   One should create WikipediaData from Wikipedia REST API (see README.md), store it, and return loaded entity.
   Second one should return WikipediaData from database, if such record exists.
   Both endpoints should receive company id as an input, it is also up to you how to handle errors.
   */

    /**
     * Endpoint to load data from external service
     */
    @PostMapping("/{company}")
    public WikipediaData loadEntity(@PathVariable("company") String name)  {
        return wikiLoadingService.loadEntity(name);
    }
}
