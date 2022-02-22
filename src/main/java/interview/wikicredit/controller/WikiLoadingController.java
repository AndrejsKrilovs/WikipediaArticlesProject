package interview.wikicredit.controller;

import interview.wikicredit.data.WikipediaData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/wiki")
public class WikiLoadingController {
  /*
  TODO: implement two endpoints.
   One should create WikipediaData from Wikipedia REST API (see README.md), store it, and return loaded entity.
   Second one should return WikipediaData from database, if such record exists.
   Both endpoints should receive company id as an input, it is also up to you how to handle errors.
   */
}
