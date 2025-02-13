const API_URL = "http://localhost:8080/api";

export const getMovies = async () => {
    const response = await fetch(`${API_URL}/movies`);
    return response.json();
};

export const getQuotes = async () => {
    const response = await fetch(`${API_URL}/quotes`);
    return response.json();
};

export const getQuoteByMovie = async (movieId) => {
    const response = await fetch(`${API_URL}/quote?movie=${movieId}`);
    return response.json();
};

export const createMovie = async (movie) => {
    const response = await fetch(`${API_URL}/movies`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(movie),
    });
    return response.json();
};

export const createQuote = async (quote) => {
    const response = await fetch(`${API_URL}/quote`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(quote),
    });
    return response.json();
};
