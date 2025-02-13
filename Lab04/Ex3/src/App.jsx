import React, { useState, useEffect } from 'react';

const App = () => {
    const [posts, setPosts] = useState([]);
    const [title, setTitle] = useState('');
    const [body, setBody] = useState('');

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=10');
                const data = await response.json();
                setPosts(data);
            } catch (error) {
                console.error('Erro ao buscar os posts:', error);
            }
        };

        fetchPosts();
    }, []);

    const addPost = async (title, body) => {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
                method: 'POST',
                body: JSON.stringify({
                    title: title,
                    body: body,
                    userId: Math.random().toString(36).slice(2),
                }),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            });
            const newPost = await response.json();
            setPosts((prevPosts) => [newPost, ...prevPosts]);
            setTitle('');
            setBody('');
        } catch (error) {
            console.error('Erro ao adicionar o post:', error);
        }
    };


    const deletePost = async (id) => {
        try {
            const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`, {
                method: 'DELETE',
            });
            if (response.status === 200) {
                setPosts(posts.filter((post) => post.id !== id));
            }
        } catch (error) {
            console.error('Erro ao apagar o post:', error);
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        addPost(title, body);
    };

    return (
        <div className="app">
            <h1>Lista de Posts</h1>

            <div className="add-post-container">
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        placeholder="Título"
                        className="form-control"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                    />
                    <textarea
                        placeholder="Conteúdo"
                        className="form-control"
                        cols="30"
                        rows="5"
                        value={body}
                        onChange={(e) => setBody(e.target.value)}
                    ></textarea>
                    <button type="submit">Adicionar Post</button>
                </form>
            </div>

            <div className="posts-container">
                {posts.map((post) => (
                    <div className="post-card" key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                        <button onClick={() => deletePost(post.id)}>Apagar</button>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default App;
