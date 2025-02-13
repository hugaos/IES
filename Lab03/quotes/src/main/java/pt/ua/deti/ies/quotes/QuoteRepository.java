package pt.ua.deti.ies.quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import pt.ua.deti.ies.quotes.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByMovieId(Long movieId);
}

