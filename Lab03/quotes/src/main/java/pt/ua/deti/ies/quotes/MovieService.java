package pt.ua.deti.ies.quotes;

import pt.ua.deti.ies.quotes.MovieRepository;
import pt.ua.deti.ies.quotes.Movie;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }


    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow();
    }


    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
