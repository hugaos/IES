import { useState } from 'react';
import './App.css';

function Square({ value, onSquareClick }) {
  return (
    <button className="square" onClick={onSquareClick}>
      {value}
    </button>
  );
}

function Board({ xIsNext, squares, onPlay }) {
  function handleClick(i) {
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    const nextSquares = squares.slice();
    if (xIsNext) {
      nextSquares[i] = 'X';
    } else {
      nextSquares[i] = 'O';
    }
    onPlay(nextSquares);
  }

  const winner = calculateWinner(squares);
  let status;
  if (winner) {
    status = 'Winner: ' + winner;
  } else {
    status = 'Next player: ' + (xIsNext ? 'X' : 'O');
  }

  return (
    <>
      <div className="status">{status}</div>
      {[0, 1, 2, 3, 4, 5].map((row) => (
        <div key={row} className="board-row">
          {[0, 1, 2, 3, 4, 5].map((col) => {
            const i = row * 6 + col;
            return (
              <Square
                key={i}
                value={squares[i]}
                onSquareClick={() => handleClick(i)}
              />
            );
          })}
        </div>
      ))}
    </>
  );
}

export default function Game() {
  const [history, setHistory] = useState([Array(9).fill(null)]);
  const [currentMove, setCurrentMove] = useState(0);
  const xIsNext = currentMove % 2 === 0;
  const currentSquares = history[currentMove];

  function handlePlay(nextSquares) {
    const nextHistory = [...history.slice(0, currentMove + 1), nextSquares];
    setHistory(nextHistory);
    setCurrentMove(nextHistory.length - 1);
  }

  function jumpTo(nextMove) {
    setCurrentMove(nextMove);
  }

  const moves = history.map((squares, move) => {
    let description;
    if (move > 0) {
      description = 'Go to move #' + move;
    } else {
      description = 'Go to game start';
    }
    return (
      <li key={move}>
        <button onClick={() => jumpTo(move)}>{description}</button>
      </li>
    );
  });

  return (
    <div className="game">
      <div className="game-board">
        <Board xIsNext={xIsNext} squares={currentSquares} onPlay={handlePlay} />
      </div>
      <div className="game-info">
        <ol>{moves}</ol>
      </div>
    </div>
  );
}

function calculateWinner(squares) {
  const size = 6;
  const winCondition = 3; // 3 em linha para vencer

  // Verificar linhas
  for (let row = 0; row < size; row++) {
    for (let col = 0; col <= size - winCondition; col++) {
      const start = row * size + col;
      if (
        squares[start] &&
        squares[start] === squares[start + 1] &&
        squares[start] === squares[start + 2]
      ) {
        return squares[start];
      }
    }
  }

  // Verificar colunas
  for (let col = 0; col < size; col++) {
    for (let row = 0; row <= size - winCondition; row++) {
      const start = row * size + col;
      if (
        squares[start] &&
        squares[start] === squares[start + size] &&
        squares[start] === squares[start + 2 * size]
      ) {
        return squares[start];
      }
    }
  }

  // Verificar diagonais (da esquerda para a direita)
  for (let row = 0; row <= size - winCondition; row++) {
    for (let col = 0; col <= size - winCondition; col++) {
      const start = row * size + col;
      if (
        squares[start] &&
        squares[start] === squares[start + size + 1] &&
        squares[start] === squares[start + 2 * size + 2]
      ) {
        return squares[start];
      }
    }
  }

  // Verificar diagonais (da direita para a esquerda)
  for (let row = 0; row <= size - winCondition; row++) {
    for (let col = winCondition - 1; col < size; col++) {
      const start = row * size + col;
      if (
        squares[start] &&
        squares[start] === squares[start + size - 1] &&
        squares[start] === squares[start + 2 * size - 2]
      ) {
        return squares[start];
      }
    }
  }

  return null; // Nenhum vencedor
}
