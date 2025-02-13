package com.example.quoteAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class QuoteController {

    private static final List<Quote> quotes = List.of(
            new Quote(1, "Run, Forrest, run! - Forrest Gump (1994)"),
            new Quote(2, "Speed. I am speed. - Cars (2006)"),
            new Quote(3, "A tortilla is either corn or wheat... - One Day (2011)"),
            new Quote(4, "Power belongs to those who take it. - Mr. Robot (2015)"),
            new Quote(5, "I love you 3000. - Avengers: Endgame (2019)")
    );

    private static final Set<String> shows = Set.of("forrestgump", "cars", "oneday", "mrrobot", "avengers");

    private final Random random = new Random();

    @GetMapping("/api/quote")
    public Quote getRandomQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    @GetMapping("/api/shows")
    public Set<String> getShows() {
        return shows;
    }

    @GetMapping("/api/quotes")
    public Quote getQuoteByShow(@RequestParam("show") String show) {
        return quotes.stream()
                .filter(quote -> quote.content().toLowerCase().contains(show.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}
