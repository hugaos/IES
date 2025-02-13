import React, { useState, useEffect } from 'react';
import { getMovies, getQuotes, createMovie, createQuote } from './services/api';

const App = () => {
    const [movies, setMovies] = useState([]);
    const [quotes, setQuotes] = useState([]);
    const [newMovie, setNewMovie] = useState({ title: '', year: '' });
    const [newQuote, setNewQuote] = useState({ quote: '', movieId: '' });

    useEffect(() => {
        const fetchMoviesAndQuotes = async () => {
            setMovies(await getMovies());
            setQuotes(await getQuotes());
        };
        fetchMoviesAndQuotes();
    }, []);

    const handleAddMovie = async () => {
        const addedMovie = await createMovie(newMovie);
        setMovies([...movies, addedMovie]);
        setNewMovie({ title: '', year: '' });
    };

    const handleAddQuote = async () => {
        const addedQuote = await createQuote(newQuote);
        setQuotes([...quotes, addedQuote]);
        setNewQuote({ quote: '', movieId: '' });
    };

    return (
        <div>
            <h1>Movies and Quotes</h1>

            <h2>Movies</h2>
            <ul>
                {movies.map((movie) => (
                    <li key={movie.id}>{movie.title} ({movie.year})</li>
                ))}
            </ul>

            <h2>Add New Movie</h2>
            <input
                type="text"
                placeholder="Title"
                value={newMovie.title}
                onChange={(e) => setNewMovie({ ...newMovie, title: e.target.value })}
            />
            <input
                type="text"
                placeholder="Year"
                value={newMovie.year}
                onChange={(e) => setNewMovie({ ...newMovie, year: e.target.value })}
            />
            <button onClick={handleAddMovie}>Add Movie</button>

            <h2>Quotes</h2>
            <ul>
                {quotes.map((quote) => (
                    <li key={quote.id}>{quote.quote} - {quote.movie.title}</li>
                ))}
            </ul>

            <h2>Add New Quote</h2>
            <input
                type="text"
                placeholder="Quote"
                value={newQuote.quote}
                onChange={(e) => setNewQuote({ ...newQuote, quote: e.target.value })}
            />
            <input
                type="text"
                placeholder="Movie ID"
                value={newQuote.movieId}
                onChange={(e) => setNewQuote({ ...newQuote, movieId: e.target.value })}
            />
            <button onClick={handleAddQuote}>Add Quote</button>
        </div>
    );
};

export default App;
