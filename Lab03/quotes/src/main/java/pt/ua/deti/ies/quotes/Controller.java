package pt.ua.deti.ies.quotes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import pt.ua.deti.ies.quotes.Quote;
import pt.ua.deti.ies.quotes.QuoteService;
import pt.ua.deti.ies.quotes.Movie;
import pt.ua.deti.ies.quotes.MovieService;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class Controller {

    private final QuoteService quoteService;
    private final MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable("id") Long movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/quote")
    public Quote getQuote(@RequestParam(value = "movie", required = false) Long movieId) {
        return (movieId != null) ? quoteService.getQuoteByMovie(movieId) : quoteService.getRandomQuote();
    }

    @GetMapping("/quotes")
    public List<Quote> getQuotes(@RequestParam(value = "movie", required = false) Long movieId) {
        return quoteService.getQuotesByMovie(movieId);
    }

    @GetMapping("/quotes/{id}")
    public Quote getQuoteById(@PathVariable("id") Long quoteId) {
        return quoteService.getQuote(quoteId);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.postMovie(movie);
    }

    @PostMapping("/quote")
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.postQuote(quote);
    }
}

