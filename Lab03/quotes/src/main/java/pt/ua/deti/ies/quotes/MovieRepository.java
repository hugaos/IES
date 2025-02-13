package pt.ua.deti.ies.quotes;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.ua.deti.ies.quotes.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

